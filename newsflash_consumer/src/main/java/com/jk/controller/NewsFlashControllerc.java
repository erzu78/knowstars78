package com.jk.controller;

import com.jk.pojo.Information;
import com.jk.pojo.NewsFlash;
import com.jk.pojo.Video;
import com.jk.service.InfService;
import com.jk.service.NewsFlashServiceApi;
import com.jk.service.NewsFlashServiceFeign;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    //快讯删除方法
    @RequestMapping("/delById")
    public void delById(@RequestParam(value="flashid") Integer flashid){
        newsFlashServiceApi.delById(flashid);

    }

     //添加快讯方法
    @PostMapping("/addNewsFlash")

    public void addNewsFlash(  NewsFlash newsFlash){
        System.out.println(newsFlash.getFlashinfo());
        System.out.println(newsFlash.getFlashtitle());
        System.out.println(121212);
        newsFlashServiceApi.addNewsFlash(newsFlash);
    }
     //根据ID回显快讯信息
    @RequestMapping("/queryNewsById")

    public NewsFlash queryNewsById(@RequestParam(value="flashid") Integer flashid){
        System.out.println(flashid);
        return newsFlashServiceApi.queryNewsById(flashid);
    }

  //修改快讯信息
    @PostMapping ("/UpdNews")
    public void UpdNews( NewsFlash newsFlash){

        newsFlashServiceApi.UpdNews(newsFlash);
    }

    @RequestMapping("NewsQueryAll")
    public String NewsQueryAll( Model model){

        List<NewsFlash> newslist=newsFlashServiceApi.NewsQueryAll();
        model.addAttribute("nslt",newslist);

        return "/homePage/testMain";
    }

    //查询前台首页快讯
    @GetMapping("queryNews")
    public List<NewsFlash> queryNews(){
        List<NewsFlash> list = newsFlashServiceApi.queryNews();
        return  list;
    }



    //根据快讯标题查询对应的信息
    @GetMapping("queryNewsFlashById")
    public NewsFlash queryNewsFlashById(Integer flashid){

        return newsFlashServiceApi.queryNewsFlashById(flashid);
    }








}
