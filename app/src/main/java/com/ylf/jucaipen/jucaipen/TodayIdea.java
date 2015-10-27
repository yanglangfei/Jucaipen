package com.ylf.jucaipen.jucaipen;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/27.
 */
public class TodayIdea implements Serializable {

    private  int id;
    private  String time;
    private  String content;

    public TodayIdea(int id, String time, String content) {
        this.id = id;
        this.time = time;
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }
}
