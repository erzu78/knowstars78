package com.jk.controller;

import com.jk.pojo.Information;
import com.jk.pojo.Staff;
import com.jk.pojo.Topic;
import com.jk.pojo.Ty;
import com.jk.service.InfService;
import com.jk.service.InfServiceP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class InfControllerP implements InfService {

    @Autowired
    private InfServiceP infServiceP;


    @Override
    public List<Information> InfoList(@RequestParam(value="start") Integer start, @RequestParam(value="rows")Integer rows) {
        return infServiceP.infoList(start,rows);
    }

    @Override
    public long queryCount() {
        return infServiceP.queryCount();
    }

    @Override
    public void deleteInfo(Integer infid) {
        infServiceP.deleteInfo(infid);
    }

    @Override
    public void add(Information information) {
        infServiceP.add(information);
    }

    @Override
    public Information queryInfoById(Integer infid) {
        return infServiceP.queryInfoById(infid);
    }

    @Override
    public void upInfo(Information information) {
        infServiceP.upInfo(information);
    }

    @Override
    public void deleteAllInfo(String ids) {
        infServiceP.deleteAllInfo(ids);
    }

    @Override
    public List<Ty> queryTy() {
        return infServiceP.queryTy();
    }

    @Override
    public List<Information> toZwww(Integer start, Integer rows, Integer tid) {
        return infServiceP.toZwww(start,rows,tid);
    }

    @Override
    public List<Staff> queryStaff() {
        return infServiceP.queryStaff();
    }

    @Override
    public List<Topic> queryTopic() {
        return infServiceP.queryTopic();
    }

    @Override
    public List<Ty> tyList(Integer start, Integer rows) {
        return infServiceP.tyList(start,rows);
    }

    @Override
    public long queryTyCount() {
        return infServiceP.queryTyCount();
    }

    @Override
    public void addTy(Ty ty) {
         infServiceP.addTy(ty);
    }

    @Override
    public void deleteTy(Integer tid) {
        infServiceP.deleteTy(tid);
    }

    @Override
    public Ty queryTyById(Integer tid) {
        return infServiceP.queryTyById(tid);
    }

    @Override
    public void upTy(Ty ty) {
         infServiceP.upTy(ty);
    }

    @Override
    public void deleteAllTy(String ids) {
        infServiceP.deleteAllTy(ids);
    }

    @Override
    public List<Information> queryWzById(Integer infid) {

        return infServiceP.queryWzById(infid);
    }

    @Override
    public Integer queryCc(Integer infid) {
        return infServiceP.queryCc(infid);
    }

    @Override
    public List<Information> queryClo(Integer infid) {
        return infServiceP.queryClo(infid);
    }

    @Override
    public List<Information> queryXa(Integer infid) {
        return infServiceP.queryXa(infid);
    }

    @Override
    public List<Information> queryAllWz(Integer infid) {
        return infServiceP.queryAllWz(infid);
    }

    @Override
    public List<Information> queryAllWzBySid(Integer sid) {
        return infServiceP.queryAllWzBySid(sid);
    }

    @Override
    public Integer queryCountById(Integer sid) {
        return infServiceP.queryCountById(sid);
    }

    @Override
    public List<Ty> queryTyy(Integer start, Integer rows) {
        return infServiceP.queryTyy(start,rows);
    }

    @Override
    public List<Information> queryTopicWz(Integer topicid) {
        return infServiceP.queryTopicWz(topicid);
    }

    @Override
    public List<Topic> queryTopicByTid(Integer tid) {
        return infServiceP.queryTopicByTid(tid);
    }

    @Override
    public List<Topic> topicList(Integer start, Integer rows) {
        return infServiceP.topicList(start,rows);
    }

    @Override
    public long queryTopicCount() {
        return infServiceP.queryTopicCount();
    }

    @Override
    public void addTopic(Topic topic) {
        infServiceP.addTopic(topic);
    }

    @Override
    public Topic queryTopicById(Integer topicid) {
        return infServiceP.queryTopicById(topicid);
    }

    @Override
    public void upTopic(Topic topic) {
        infServiceP.upTopic(topic);
    }

    @Override
    public void deleteTopic(Integer topicid) {
        infServiceP.deleteTopic(topicid);
    }

    @Override
    public void deleteAllTopic(String ids) {
        infServiceP.deleteAllTopic(ids);
    }

    @Override
    public List<Topic> queryTopicc() {
        return infServiceP.queryTopicc();
    }

    @Override
    public List<Information> MyInfoList(Integer start, Integer rows, Integer sid) {
        return infServiceP.MyInfoList(start,rows,sid);
    }

    @Override
    public long queryCountt(Integer sid) {
        return infServiceP.queryCountt(sid);
    }

    @Override
    public void qxR(Integer infid) {
        infServiceP.qxR(infid);
    }

    @Override
    public void toR(Integer infid) {
        infServiceP.toR(infid);
    }


}
