package com.jk.controller;


import com.jk.service.InfService;
import com.jk.service.InfServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class infController {

    @Autowired
    private InfService infService;

    @Autowired
    private InfServiceFeign infServiceFeign;

    @GetMapping("queryInf")
    public HashMap<String,Object> queryInf(){

        HashMap<String,Object> map = infService.queryInf();

        return map;
    }


}
