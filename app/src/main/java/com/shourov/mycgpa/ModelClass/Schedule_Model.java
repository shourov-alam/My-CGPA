package com.shourov.mycgpa.ModelClass;

import java.io.Serializable;

public class Schedule_Model implements Serializable {

    String title,des,date,is_notification,imageUri,before_day,mili_sort;
    int id;


    public Schedule_Model(String title, String des, String date, String is_notification, String imageUri, int id,String before_day,String mili_sort) {
        this.title = title;
        this.des = des;
        this.date = date;
        this.is_notification = is_notification;
        this.imageUri = imageUri;
        this.id = id;
        this.mili_sort=mili_sort;
        this.before_day=before_day;
    }

    public Schedule_Model(String title, String des, String date, String is_notification, String imageUri,String before_day,String mili_sort) {
        this.title = title;
        this.des = des;
        this.date = date;
        this.mili_sort=mili_sort;
        this.is_notification = is_notification;
        this.imageUri = imageUri;
        this.before_day=before_day;

    }


    public String getMili_sort() {
        return mili_sort;
    }

    public void setMili_sort(String mili_sort) {
        this.mili_sort = mili_sort;
    }

    public String getBefore_day() {
        return before_day;
    }

    public void setBefore_day(String before_day) {
        this.before_day = before_day;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIs_notification() {
        return is_notification;
    }

    public void setIs_notification(String is_notification) {
        this.is_notification = is_notification;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
