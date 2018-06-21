package com.yui.realmapp.db;

import com.yui.realmapp.bean.BannerDataBean;

import java.util.ArrayList;
import java.util.List;


/**
 * @author liaoyuhuan
 * @time 2018/6/13  14:10
 * @description
 */
public class BannerDataBeanDao extends BaseRealmDao<BannerDataBean> {
    private static final String TAG = "BannerDataBeanDao";

    public BannerDataBeanDao() {
        super(BannerDataBean.class);
    }

    /**
     * 取得 banner url list
     *
     * @return
     */
    public List getUrlList() {
        final List<BannerDataBean> list = findAll();
        final List<String> urlList = new ArrayList<>();
        for (final BannerDataBean dataBean : list) {
            if (dataBean.isValid()) {
                urlList.add(dataBean.getImage());
            }
        }


        return urlList;
    }
}
