package com.ylf.jucaipen.jucaipen;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/27.
 */
public class Communction implements Serializable{
    private  String userLogo;
    private  int id;
    private  String userName;
    private  String time;
    private  String content;

    public Communction(String userLogo, int id, String userName, String time, String content) {
        this.userLogo = userLogo;
        this.id = id;
        this.userName = userName;
        this.time = time;
        this.content = content;
    }

    public void setUserLogo(String userLogo) {
        this.userLogo = userLogo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserLogo() {
        return userLogo;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }
}
