package com.jk.service;

import com.jk.mapper.InformationMapper;
import com.jk.pojo.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class InfServicePImpl implements InfServiceP {

    @Autowired
    private InformationMapper infMapper;


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
        infMapper.insert(information);
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
}
