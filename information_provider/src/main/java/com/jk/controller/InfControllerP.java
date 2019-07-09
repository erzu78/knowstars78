package com.jk.controller;

import com.jk.pojo.Information;
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
}
