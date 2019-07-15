package com.jk.service;

import com.jk.mapper.InformationMapper;
import com.jk.mapper.StaffMapper;
import com.jk.mapper.TopicMapper;
import com.jk.mapper.TyMapper;
import com.jk.pojo.Information;
import com.jk.pojo.Staff;
import com.jk.pojo.Topic;
import com.jk.pojo.Ty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class InfServicePImpl implements InfServiceP {

    @Autowired
    private InformationMapper infMapper;
    @Autowired
    private TyMapper tyMapper;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private TopicMapper topicMapper;
    @Override
    public List<Information> infoList(Integer start, Integer rows) {
        return infMapper.infoList(start,rows);
    }

    @Override
    public long queryCount() {
        return infMapper.queryCount();
    }

    @Override
    public void deleteInfo(Integer infid) {
        infMapper.deleteByPrimaryKey(infid);
    }

    @Override
    public void add(Information information) {
        infMapper.insertSelective(information);
    }

    @Override
    public Information queryInfoById(Integer infid) {
        return infMapper.selectByPrimaryKey(infid);
    }

    @Override
    public void upInfo(Information information) {
        infMapper.updateByPrimaryKey(information);
    }

    @Override
    public void deleteAllInfo(String ids) {
        infMapper.delAll(ids);
    }

    @Override
    public List<Ty> queryTy() {
        return tyMapper.queryTy();
    }

    @Override
    public List<Information> toZwww(Integer start, Integer rows, Integer tid) {
        return infMapper.toZwww(start,rows,tid);
    }

    @Override
    public List<Staff> queryStaff() {
        return staffMapper.queryStaff();
    }

    @Override
    public List<Topic> queryTopic() {
        return topicMapper.queryTopic();
    }

    @Override
    public List<Ty> tyList(Integer start, Integer rows) {
        return tyMapper.tyList(start,rows);
    }

    @Override
    public long queryTyCount() {
        return tyMapper.queryTyCount();
    }

    @Override
    public void addTy(Ty ty) {
        tyMapper.insert(ty);
    }

    @Override
    public void deleteTy(Integer tid) {
        tyMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public Ty queryTyById(Integer tid) {
        return tyMapper.selectByPrimaryKey(tid);
    }

    @Override
    public void upTy(Ty ty) {
        tyMapper.updateByPrimaryKey(ty);
    }

    @Override
    public void deleteAllTy(String ids) {
        tyMapper.deleteAllTy(ids);
    }

}
