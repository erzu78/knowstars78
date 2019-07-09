package com.jk.service;

import com.jk.mapper.InfMapper;
import com.jk.pojo.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class InfServicePImpl implements InfServiceP {

    @Autowired
    private InfMapper infMapper;

    @Override
    public HashMap<String, Object> queryInf() {

        List<Information> list = infMapper.queryInf();

        HashMap<String,Object> map = new HashMap<>();
        map.put("rows",list);

        return map;
    }
}
