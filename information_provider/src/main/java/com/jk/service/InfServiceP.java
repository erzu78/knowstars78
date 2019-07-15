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
}
