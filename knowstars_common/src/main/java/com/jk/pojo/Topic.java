package com.jk.pojo;

import java.util.Date;

public class Topic {
    private Integer topicid;

    private String topicname;

    private String topicimg;

    private String inftitle;

    public String getInftitle() {
        return inftitle;
    }

    public void setInftitle(String inftitle) {
        this.inftitle = inftitle;
    }

    private Integer tcount;

    private String tdate;

    public Integer getTopicid() {
        return topicid;
    }

    public void setTopicid(Integer topicid) {
        this.topicid = topicid;
    }

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname == null ? null : topicname.trim();
    }

    public String getTopicimg() {
        return topicimg;
    }

    public void setTopicimg(String topicimg) {
        this.topicimg = topicimg == null ? null : topicimg.trim();
    }

    public Integer getTcount() {
        return tcount;
    }

    public void setTcount(Integer tcount) {
        this.tcount = tcount;
    }

    public String getTdate() {
        return tdate;
    }

    public void setTdate(String tdate) {
        this.tdate = tdate;
    }
}