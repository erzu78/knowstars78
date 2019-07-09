package com.jk.service;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

public interface InfService {

    @GetMapping("queryInf")
    HashMap<String, Object> queryInf();
}
