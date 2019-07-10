package com.jk.pojo;

/**
 * 视频表
 */
public class Video {
     private Integer videoId;        // Id
     private String headline;        //大标题
     private String subtitle;        //小标题
     private String issuer;          //发布人
     private String issueTime;       //发布时间
     private String introduction;    //介绍
     private String videoImg;        //视频封面图片
     private String videoNews;       //视频


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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

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
}
