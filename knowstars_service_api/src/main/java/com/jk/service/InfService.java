package com.jk.service;

import com.jk.pojo.Information;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

public interface InfService {

    @GetMapping(value = "/infoList")
    List<Information> InfoList(@RequestParam(value="start") Integer start, @RequestParam(value="rows")Integer rows);
    @GetMapping(value = "/queryCount")
    long queryCount();
    @RequestMapping("/delById")
    void deleteInfo(@RequestParam(value="infid") Integer infid);
    @PostMapping("/add")
    void add(@RequestBody  Information information);
    @RequestMapping("queryInfoById")
    Information queryInfoById(@RequestParam(value="infid") Integer infid);
    @RequestMapping("upInfo")
    void upInfo(@RequestBody  Information information);
    @RequestMapping("/deleteAllInfo")
    void deleteAllInfo(@RequestParam(value="ids")String ids);
}
