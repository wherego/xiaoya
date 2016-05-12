package wanghaisheng.com.xiaoya.ui.meitu;

import android.support.v4.app.Fragment;

import java.util.List;

import wanghaisheng.com.xiaoya.api.meitu.MeituApi;
import wanghaisheng.com.xiaoya.ui.BaseTopNagigationFragment;
import wanghaisheng.com.xiaoya.ui.PagerAdapter;
import wanghaisheng.com.xiaoya.utils.ArrayUtils;

/**
 * Created by sheng on 2016/5/11.
 */
public class BaseBeautyMeituFragment extends BaseTopNagigationFragment {

    public static BaseBeautyMeituFragment newInstance() {
        BaseBeautyMeituFragment fragment = new BaseBeautyMeituFragment();

        return fragment;
    }


    @Override
    protected PagerAdapter initPagerAdapter() {
        //将title类的数组转换成list
        List<String> titles = ArrayUtils.arrayToList(MeituApi.BEAUTY_TAG_NAME);
        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager(), titles) {
            @Override
            public Fragment getItem(int position) {
                MeituBeautyHomeListFragment fragment = MeituBeautyHomeListFragment.newInstance(MeituApi.BEAUTY_TAG_ID[position]);
                return fragment;
            }
        };

        return pagerAdapter;
    }
}