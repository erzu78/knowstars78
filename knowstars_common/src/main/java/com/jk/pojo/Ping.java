package com.jk.pojo;

import java.util.HashMap;

//评论表
public class Ping {

    private String pingId;
    private String pingInfo;
    private Integer userId;
    private String userImg;
    private String userName;
    private String likeCount;
    private String piId;
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
