package com.jk.pojo;

import java.util.HashMap;

//评论表
public class Ping {

    private String pingId;//评论id
    private String pingInfo;//评论内容
    private Integer userId;//用户id
    private String userImg;//用户头像
    private String userName;//用户名字
    private String likeCount;//点赞数量
    private String piId;//评论id
    private HashMap<String,String> pingMap;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPiId() {
        return piId;
    }

    public void setPiId(String piId) {
        this.piId = piId;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public HashMap<String, String> getPingMap() {
        return pingMap;
    }

    public void setPingMap(HashMap<String, String> pingMap) {
        this.pingMap = pingMap;
    }

    public String getPingId() {
        return pingId;
    }

    public void setPingId(String pingId) {
        this.pingId = pingId;
    }

    public String getPingInfo() {
        return pingInfo;
    }

    public void setPingInfo(String pingInfo) {
        this.pingInfo = pingInfo;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
