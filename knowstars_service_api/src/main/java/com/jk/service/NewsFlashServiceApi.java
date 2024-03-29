package com.jk.service;

import com.jk.pojo.NewsFlash;
import com.jk.pojo.Video;
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
    @GetMapping(value = "/NewsQueryAll")
    List<NewsFlash> NewsQueryAll();
    @GetMapping(value = "/queryNews")
    List<NewsFlash> queryNews();
    @GetMapping("/queryNewsFlashById/{flashid}")
    NewsFlash queryNewsFlashById(@PathVariable(value="flashid")Integer flashid);
    @GetMapping(value = "/queryNewsAll")
    List<NewsFlash> queryNewsAll();
    @GetMapping("/queryNewsFlashByIdPlusOne/{flashid}")
    NewsFlash queryNewsFlashByIdPlusOne(@RequestParam(value="flashid")Integer flashid);
    @GetMapping(value = "/queryNext")
    List<NewsFlash> queryNext(@PathVariable(value="flashid")Integer flashid);

    /*@RequestMapping("/NewsFlashList")
    long queryCount();*/
}
