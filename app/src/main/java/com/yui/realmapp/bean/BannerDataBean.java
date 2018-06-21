package com.yui.realmapp.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @author liaoyuhuan
 * @time 2018/6/13  16:52
 * @description
 */
public class BannerDataBean extends RealmObject implements Parcelable {
    /**
     * id : 1
     * sort : 0
     * title :
     * image : https://download.huduntech.com/static/shoujihuifu/2.0/img/banner_3.png
     * url :
     * time : 2017-09-26 12:31:30
     * status : 1
     * ptype : 0
     * apkid :
     */
    @NonNull
    @PrimaryKey
    private String id;
    private String sort;
    private String title;
    private String image;
    private String url;
    private String time;
    private String status;
    private String ptype;
    private String apkid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getApkid() {
        return apkid;
    }

    public void setApkid(String apkid) {
        this.apkid = apkid;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.sort);
        dest.writeString(this.title);
        dest.writeString(this.image);
        dest.writeString(this.url);
        dest.writeString(this.time);
        dest.writeString(this.status);
        dest.writeString(this.ptype);
        dest.writeString(this.apkid);
    }

    public BannerDataBean() {
    }

    protected BannerDataBean(Parcel in) {
        this.id = in.readString();
        this.sort = in.readString();
        this.title = in.readString();
        this.image = in.readString();
        this.url = in.readString();
        this.time = in.readString();
        this.status = in.readString();
        this.ptype = in.readString();
        this.apkid = in.readString();
    }

    public static final Parcelable.Creator<BannerDataBean> CREATOR = new Parcelable.Creator<BannerDataBean>() {
        @Override
        public BannerDataBean createFromParcel(Parcel source) {
            return new BannerDataBean(source);
        }

        @Override
        public BannerDataBean[] newArray(int size) {
            return new BannerDataBean[size];
        }
    };
}