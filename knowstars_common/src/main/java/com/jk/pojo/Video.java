package com.jk.pojo;

/**
 * 视频表
 */
public class Video {
     private Integer videoId;        // Id
     private String headline;        //大标题
    // private String issuer;          //发布人
     private String issueTime;       //发布时间
     private String introduction;    //介绍
     private String videoImg;        //视频封面图片
     private String videoNews;       //视频
     private Integer staffId;        //连接staff表的外键

    /*Staff表中的字段*/
    private Integer sid;
    private String staffname;//登录名
    private String staffimg;//员工头像
    private String staffinfo;//员工格言

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

/*    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }*/

    public String getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(String issueTime) {
        this.issueTime = issueTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg;
    }

    public String getVideoNews() {
        return videoNews;
    }

    public void setVideoNews(String videoNews) {
        this.videoNews = videoNews;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

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
}
