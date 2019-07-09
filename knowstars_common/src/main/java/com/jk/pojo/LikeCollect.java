package com.jk.pojo;

/**
 * 点赞收藏
 */
public class LikeCollect {
    private Integer likecollectId;
    private Integer likeNum;   // 点赞数量
    private Integer collectNum;//收藏数量
    private Integer ziid;      //资讯id
    private Integer userId;   //用户id

    public Integer getLikecollectId() {
        return likecollectId;
    }

    public void setLikecollectId(Integer likecollectId) {
        this.likecollectId = likecollectId;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public Integer getZiid() {
        return ziid;
    }

    public void setZiid(Integer ziid) {
        this.ziid = ziid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
