package com.jk.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author Administrator
 * @title: Infor
 * @projectName knowstars78
 * @description: TODO
 * @date 2019/7/16 001621:04
 */
@Document(indexName = "t_information",type = "action")
public class Infor implements Serializable {
    private static final long serialVersionUID = -825750076828665665L;
    @Id
    private Integer id;

    private Integer infid;//咨询id

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        this.articleinformation = articleinformation;
    }

    public String getArticleimg() {
        return articleimg;
    }

    public void setArticleimg(String articleimg) {
        this.articleimg = articleimg;
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
        this.subtitle = subtitle;
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
}
