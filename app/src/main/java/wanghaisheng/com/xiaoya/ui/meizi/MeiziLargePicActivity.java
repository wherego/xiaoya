package wanghaisheng.com.xiaoya.ui.meizi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.apkfuns.logutils.LogUtils;

import java.util.ArrayList;

import butterknife.Bind;
import wanghaisheng.com.xiaoya.R;
import wanghaisheng.com.xiaoya.ui.BaseActivity;

/**
 * Created by sheng on 2016/5/8.
 */
public class MeiziLargePicActivity extends BaseActivity {
    public static final String ARG_INEX = "arg_index";
    public static final String ARG_GROUPID = "arg_groupid";
    public static final String ARG_URLS = "arg_urls";

    private int index;
    private String groupId;
    private ArrayList<String> urls = new ArrayList<>();

    @Bind(R.id.large_toolbar)
    Toolbar mToolbar;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    PagerAdapter pagerAdapter;

    @Override
    public void getDatas(Bundle savedInstanceState) {
        Intent intent = getIntent();
        this.index = intent.getIntExtra(ARG_INEX,0);
        this.groupId = intent.getStringExtra(ARG_GROUPID);
        this.urls = intent.getStringArrayListExtra(ARG_URLS);
    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return true;
    }

    @Override
    protected boolean isApplyStatusBarColor() {
        return true;
    }

    @Override
    protected void initInjector() {
        mActivityComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_large_pic;
    }

    @Override
    public void initView() {
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mToolbar.setTitle("Meizi");
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //supportFinishAfterTransition();
                onBackPressed();
            }
        });
    }

    @Override
    public void initData() {
        LogUtils.d("print urls..............");
        LogUtils.d(urls);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),urls,groupId);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(index);
    }
}
