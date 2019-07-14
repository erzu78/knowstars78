package com.jk.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    private Integer uid;//用户id
    private String username;//用户名称
    private String password;//用户登陆密码
    private String userhead;//头像
    private Integer usersex;//性别

    private String birthday;//生日
    private String userintro;//个人简介
    private Integer profession;//职业
    private Integer trade;//行业
    private String account;//用户登录名

    private Integer infuserId;//收藏中间表的Id
    private Integer infId;//中间表收藏的Id
    private Integer userId;//中间表用户的Id


    private Integer infid;//咨询id
    private String inftitle;//咨询标题
    private String articleimg;//文章封面

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserhead() {
        return userhead;
    }

    public void setUserhead(String userhead) {
        this.userhead = userhead;
    }

    public Integer getUsersex() {
        return usersex;
    }

    public void setUsersex(Integer usersex) {
        this.usersex = usersex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUserintro() {
        return userintro;
    }

    public void setUserintro(String userintro) {
        this.userintro = userintro;
    }

    public Integer getProfession() {
        return profession;
    }

    public void setProfession(Integer profession) {
        this.profession = profession;
    }

    public Integer getTrade() {
        return trade;
    }

    public void setTrade(Integer trade) {
        this.trade = trade;
    }

    public Integer getInfId() {
        return infId;
    }

    public void setInfId(Integer infId) {
        this.infId = infId;
    }

    public Integer getInfuserId() {
        return infuserId;
    }

    public void setInfuserId(Integer infuserId) {
        this.infuserId = infuserId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        this.inftitle = inftitle;
    }

    public String getArticleimg() {
        return articleimg;
    }

    public void setArticleimg(String articleimg) {
        this.articleimg = articleimg;
    }
}
