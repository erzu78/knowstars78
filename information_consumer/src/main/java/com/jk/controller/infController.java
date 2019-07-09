package com.jk.controller;


import com.jk.pojo.Information;
import com.jk.service.InfService;
import com.jk.service.InfServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class infController {
    @Autowired
    private InfServiceFeign infServiceFeign;
    @RequestMapping("/infoList")
    @ResponseBody
    //分页查询资讯列表
    public Map<String,Object> userList(@RequestParam(value="start") Integer start, @RequestParam(value="rows")Integer rows ) {
        List<Information> list= infServiceFeign.InfoList(start,rows);
        long count = infServiceFeign.queryCount();
        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("rows",list);
        return map;
    }
    @RequestMapping("/deleteInfo")
    @ResponseBody
    public void deleteInfo(@RequestParam(value="infid") Integer infid){
        infServiceFeign.deleteInfo(infid);
    }

}
