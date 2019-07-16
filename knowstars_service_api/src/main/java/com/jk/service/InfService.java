package com.jk.service;

import com.jk.pojo.Information;
import com.jk.pojo.Staff;
import com.jk.pojo.Topic;
import com.jk.pojo.Ty;
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
    @RequestMapping("/queryTy")
    List<Ty> queryTy();
    @RequestMapping("/toZwww")
    List<Information> toZwww(@RequestParam(value="start") Integer start, @RequestParam(value="rows")Integer rows,@RequestParam(value="tid")Integer tid);
    @RequestMapping("/queryStaff")
    List<Staff> queryStaff();
    @RequestMapping("/queryTopic")
    List<Topic> queryTopic();
    @GetMapping(value = "/tyList")
    List<Ty> tyList(@RequestParam(value="start") Integer start, @RequestParam(value="rows")Integer rows);
    @GetMapping(value = "/queryTyCount")
    long queryTyCount();
    @PostMapping("/addTy")
    void addTy(@RequestBody Ty ty);
    @RequestMapping("/deleteTy")
    void deleteTy(@RequestParam(value="tid")Integer tid);
    @RequestMapping("/queryTyById")
    Ty queryTyById(@RequestParam(value="tid")Integer tid);
    @RequestMapping("upTy")
    void upTy(@RequestBody Ty ty);
    @RequestMapping("/deleteAllTy")
    void deleteAllTy(@RequestParam(value="ids")String ids);
    @RequestMapping("/queryWzById")
    List<Information>  queryWzById(@RequestParam(value="infid")Integer infid);
}
