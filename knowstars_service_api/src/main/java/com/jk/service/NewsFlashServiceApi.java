package com.jk.service;

import com.jk.pojo.NewsFlash;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface NewsFlashServiceApi {

    @GetMapping(value = "/NewsFlashList")
    List<NewsFlash> NewsFlashList(@RequestParam(value="start") Integer start, @RequestParam(value="rows")Integer rows);
    @GetMapping(value = "/queryCount")
    long queryCount();
    @RequestMapping("/delById")
    void delById(@RequestParam(value="flashid") Integer flashid);
    @PostMapping("/addNewsFlash")
    void addNewsFlash(@RequestBody NewsFlash newsFlash);
    @RequestMapping("/queryNewsById")
    NewsFlash queryNewsById(@RequestParam(value="flashid")Integer flashid);
    @PostMapping ("/UpdNews")
    void UpdNews(@RequestBody NewsFlash newsFlash);

    /*@RequestMapping("/NewsFlashList")
    long queryCount();*/
}
