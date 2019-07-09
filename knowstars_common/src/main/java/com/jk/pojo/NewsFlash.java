package com.jk.pojo;

import java.util.Date;
/**
 * 快讯表
 */
public class NewsFlash {
    private Integer flashid; //快讯id

    private String flashtitle; //快讯标题

    private Date creattime;   //快讯创建时间

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

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public String getFlashinfo() {
        return flashinfo;
    }

    public void setFlashinfo(String flashinfo) {
        this.flashinfo = flashinfo == null ? null : flashinfo.trim();
    }
}