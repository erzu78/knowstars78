package com.jk.controller;

import com.jk.pojo.NewsFlash;
import com.jk.service.InfService;
import com.jk.service.NewsFlashServiceApi;
import com.jk.service.NewsFlashServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class NewsFlashControllerc {

    @Autowired
    private NewsFlashServiceApi newsFlashServiceApi;

     //查询快讯方法
    @RequestMapping("NewsFlashList")
    public Map<String,Object> userList(@RequestParam(value="start") Integer start, @RequestParam(value="rows")Integer rows ) {
        List<NewsFlash> list= newsFlashServiceApi.NewsFlashList(start,rows);
        long count = newsFlashServiceApi.queryCount();
        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("rows",list);
        return map;
    }


}
