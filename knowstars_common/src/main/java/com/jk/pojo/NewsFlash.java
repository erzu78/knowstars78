package com.jk.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 快讯表
 */
public class NewsFlash  implements Serializable {
    private Integer flashid; //快讯id

    private String flashtitle; //快讯标题
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    private String creattime;   //快讯创建时间

    private String flashinfo;   //快讯内容

    public Integer getFlashid() {
        return flashid;
    }

    public void setFlashid(Integer flashid) {
        this.flashid = flashid;
    }

    public String getFlashtitle() {
        return flashtitle;
    }

    public void setFlashtitle(String flashtitle) {
        this.flashtitle = flashtitle == null ? null : flashtitle.trim();
    }



    public String getFlashinfo() {
        return flashinfo;
    }

    public void setFlashinfo(String flashinfo) {
        this.flashinfo = flashinfo == null ? null : flashinfo.trim();
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }
}