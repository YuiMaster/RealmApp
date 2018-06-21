package com.yui.realmapp.db;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmModel;

/**
 * realm 基本操作类
 * 增删查改
 *
 * @author liaoyuhuan
 * @time 2018/6/13  13:46
 * @description
 */

public abstract class BaseRealmDao<T extends RealmModel> {
    private Realm realm;
    private Class<T> mClass;

    public BaseRealmDao(final Class<T> cls) {
        realm = Realm.getDefaultInstance();
        mClass = cls;
    }

    /**
     * 插入
     *
     * @param data
     */
    public void insert(T data) {
        realm.beginTransaction();
        realm.copyToRealm(data);
        realm.commitTransaction();
    }

    /**
     * 查找所有
     *
     * @return
     */
    public List<T> findAll() {
        return realm.where(mClass).findAll();
    }

    /**
     * 查找
     *
     * @param key
     * @param value
     * @return
     */
    public List<T> find(String key, String value) {
        return realm.where(mClass).equalTo(key, value).findAll();
    }

    /**
     * 更新
     *
     * @param data
     */
    public void update(T data) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(data);
        realm.commitTransaction();
    }

    /**
     * 更新
     *
     * @param list
     */
    public void updateList(List<T> list) {
        realm.beginTransaction();
        for (T data : list) {
            realm.copyToRealmOrUpdate(data);
        }
        realm.commitTransaction();
    }

    /**
     * 更新
     *
     * @param list
     */
    public void addAll(List<T> list) {
        realm.beginTransaction();
        deleteAll();
        for (T data : list) {
            realm.copyToRealmOrUpdate(data);
        }
        realm.commitTransaction();
    }

    /**
     * 删除
     */
    public void delete(String key, String value) {
        realm.where(mClass).equalTo(key, value).findAll().deleteAllFromRealm();
    }

    /**
     * 删除所有
     */
    public void deleteAll() {
        realm.where(mClass).findAll().deleteAllFromRealm();
    }

    /**
     * 关闭事务
     */
    public void closeRealm() {
        if (realm != null) {
            realm.close();
        }
    }
}
