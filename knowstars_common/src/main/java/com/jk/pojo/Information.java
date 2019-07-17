package com.jk.pojo;

import java.io.Serializable;
import java.util.Date;
/*
* 资讯表
* */
public class Information implements Serializable{
    private Integer infid;//咨询id

    private Integer hot; //是否热门

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    private String inftitle;//咨询标题

    private Integer authorid;//关联作者id

    private String releasetime;//发布时间

    private String articleinformation;//文章内容

    private String articleimg;//文章封面

    private Integer tyid;//类型关联id

    private Integer topicid;//关联主题id

    private String subtitle;//二级标题

    private String tname; //类型名字业务字段

    private String topicname;//主题名字业务字段

    private String staffname;//作者名字业务字段

    private String stafftype;//作者类型关联子段

    private String staffinfo;//文章内容关联字段

    private String staffimg;

    public String getStaffimg() {
        return staffimg;
    }

    public void setStaffimg(String staffimg) {
        this.staffimg = staffimg;
    }

    public String getStaffinfo() {
        return staffinfo;
    }

    public void setStaffinfo(String staffinfo) {
        this.staffinfo = staffinfo;
    }

    public String getStafftype() {
        return stafftype;
    }

    public void setStafftype(String stafftype) {
        this.stafftype = stafftype;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public Integer getInfid() {
        return infid;
    }

    public void setInfid(Integer infid) {
        this.infid = infid;
    }

    public String getInftitle() {
        return inftitle;
    }

    public void setInftitle(String inftitle) {
        this.inftitle = inftitle == null ? null : inftitle.trim();
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public String getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(String releasetime) {
        this.releasetime = releasetime;
    }

    public String getArticleinformation() {
        return articleinformation;
    }

    public void setArticleinformation(String articleinformation) {
        this.articleinformation = articleinformation == null ? null : articleinformation.trim();
    }

    public String getArticleimg() {
        return articleimg;
    }

    public void setArticleimg(String articleimg) {
        this.articleimg = articleimg == null ? null : articleimg.trim();
    }

    public Integer getTyid() {
        return tyid;
    }

    public void setTyid(Integer tyid) {
        this.tyid = tyid;
    }

    public Integer getTopicid() {
        return topicid;
    }

    public void setTopicid(Integer topicid) {
        this.topicid = topicid;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }
}