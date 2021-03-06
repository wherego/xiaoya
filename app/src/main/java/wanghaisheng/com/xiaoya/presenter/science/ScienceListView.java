package wanghaisheng.com.xiaoya.presenter.science;

import wanghaisheng.com.xiaoya.beans.Science;
import wanghaisheng.com.xiaoya.presenter.base.BaseListView;

/**
 * Created by sheng on 2016/4/16.
 */
public interface ScienceListView extends BaseListView{

    void renderFirstLoadData(Science datas);
    void refreshComplete(Science datas);
    void loadMoreComplete(Science datas);

}
