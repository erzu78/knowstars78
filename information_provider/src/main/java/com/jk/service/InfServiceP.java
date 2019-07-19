package com.jk.service;

import com.jk.pojo.Information;
import com.jk.pojo.Staff;
import com.jk.pojo.Topic;
import com.jk.pojo.Ty;

import java.util.HashMap;
import java.util.List;

public interface InfServiceP {
    List<Information> infoList(Integer start, Integer rows);
    long queryCount();
    void deleteInfo(Integer infid);
    void add(Information information);
    Information queryInfoById(Integer infid);
    void upInfo(Information information);
    void deleteAllInfo(String ids);
    List<Ty> queryTy();
    List<Information> toZwww(Integer start, Integer rows, Integer tid);
    List<Staff> queryStaff();
    List<Topic> queryTopic();
    List<Ty> tyList(Integer start, Integer rows);
    long queryTyCount();
    void addTy(Ty ty);
    void deleteTy(Integer tid);

    Ty queryTyById(Integer tid);
    void upTy(Ty ty);
    void deleteAllTy(String ids);
    List<Information> queryWzById(Integer infid);
    Integer queryCc(Integer infid);
    List<Information> queryClo(Integer infid);
    List<Information> queryXa(Integer infid);
    List<Information> queryAllWz(Integer infid);
    List<Information> queryAllWzBySid(Integer sid);
    Integer queryCountById(Integer sid);
    List<Ty> queryTyy(Integer start, Integer rows);
    List<Information> queryTopicWz(Integer topicid);
    List<Topic> queryTopicByTid(Integer tid);
    List<Topic> topicList(Integer start, Integer rows);
    long queryTopicCount();
    void addTopic(Topic topic);
    Topic queryTopicById(Integer topicid);
    void upTopic(Topic topic);

    void deleteTopic(Integer topicid);

    void deleteAllTopic(String ids);
}
