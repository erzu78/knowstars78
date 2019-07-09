package com.jk.service;

import com.jk.pojo.Information;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

public interface InfService {

    @GetMapping(value = "/infoList")
    List<Information> InfoList(@RequestParam(value="start") Integer start, @RequestParam(value="rows")Integer rows);
    @GetMapping(value = "/queryCount")
    long queryCount();
    @RequestMapping("/delById")
    void deleteInfo(@RequestParam(value="infid") Integer infid);

}
