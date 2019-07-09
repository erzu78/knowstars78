package com.jk.service;

import com.jk.pojo.NewsFlash;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface NewsFlashServiceApi {

    @GetMapping(value = "/NewsFlashList")
    List<NewsFlash> NewsFlashList(@RequestParam(value="start") Integer start, @RequestParam(value="rows")Integer rows);
    @GetMapping(value = "/queryCount")
    long queryCount();

    /*@RequestMapping("/NewsFlashList")
    long queryCount();*/
}
