package wanghaisheng.com.xiaoya.ui.meizi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewTreeObserver;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.apkfuns.logutils.LogUtils;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import wanghaisheng.com.xiaoya.R;
import wanghaisheng.com.xiaoya.presenter.meizi.MeiziLargePicPresenter;
import wanghaisheng.com.xiaoya.presenter.meizi.MeiziLargePicView;
import wanghaisheng.com.xiaoya.ui.BaseFragment;
import wanghaisheng.com.xiaoya.utils.ToastUtil;
import wanghaisheng.com.xiaoya.widget.view.TouchImageView;

/**
 * Created by sheng on 2016/5/8.
 */
public class MeiziLargePicFragment extends BaseFragment implements MeiziLargePicView {
    public static final String ARG_INDEX = "arg_index";
    public static final String ARG_URL = "arg_url";
    public static final String ARG_GROUPID = "arg_groupid";

    private int index;
    private String groupId;
    private String url;

    TouchImageView imageView;
    MaterialDialog mDialog;

    @Inject
    MeiziLargePicPresenter presenter;
    @Inject
    ToastUtil toastUtil;

    public static MeiziLargePicFragment newInstance(int index,String url,String groupId) {
        MeiziLargePicFragment fragment = new MeiziLargePicFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_INDEX,index);
        bundle.putString(ARG_URL,url);
        bundle.putString(ARG_GROUPID,groupId);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void initInjector() {
        mFragmentComponent.inject(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_large_pic;
    }

    @Override
    public void getSavedBundle(Bundle bundle) {
        this.index = getArguments().getInt(ARG_INDEX);
        this.groupId = getArguments().getString(ARG_GROUPID);
        this.url = getArguments().getString(ARG_URL);
        LogUtils.d("print urls..............");
        LogUtils.d(url);
    }

    @Override
    public void beforeInitView(View view) {

    }

    @Override
    public void initView(View view) {
        this.imageView = (TouchImageView) view.findViewById(R.id.image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().supportFinishAfterTransition();
            }
        });
        imageView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                getActivity().supportStartPostponedEnterTransition();
                return true;
            }
        });
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                mDialog = new MaterialDialog.Builder(getActivity()).content("保存图片")
                        .positiveText("确定")
                        .negativeText("取消")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                presenter.saveLargePic(url,groupId+"_"+index);
                            }
                        })
                        .onNegative(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                dialog.dismiss();
                            }
                        }).show();

                return true;
            }
        });
    }

    @Override
    public void initData() {
        presenter.attachView(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.d("url.........."+url);
        Picasso.with(getActivity()).load(url).into(imageView);
    }

    public View getSharedElement() {
        return imageView;
    }

    @Override
    public void onImageSaved(boolean imgSaved,String imgPath) {
        if(imgSaved) {
            toastUtil.showToast(String.format(getString(R.string.msg_image_saved),imgPath));
        } else {
            toastUtil.showToast(imgPath);
        }
        mDialog.dismiss();
    }
}