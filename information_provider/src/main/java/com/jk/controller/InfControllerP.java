package com.jk.controller;

import com.jk.service.InfService;
import com.jk.service.InfServiceP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class InfControllerP implements InfService {

    @Autowired
    private InfServiceP infServiceP;

    @Override
    @GetMapping("queryInf")
    public HashMap<String, Object> queryInf() {

        return infServiceP.queryInf();
    }
}
