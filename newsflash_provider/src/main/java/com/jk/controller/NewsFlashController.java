package com.jk.controller;

import com.jk.pojo.NewsFlash;
import com.jk.service.NewsFlashService;
import com.jk.service.NewsFlashServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class NewsFlashController  implements NewsFlashServiceApi {


    @Autowired
    private NewsFlashService newsFlashService;

    @Override

    public List<NewsFlash> NewsFlashList(@RequestParam(value="start")Integer start, @RequestParam(value="rows")Integer rows) {
        return newsFlashService.NewsFlashList(start,rows);
    }



    public long queryCount() {
        return newsFlashService.queryCount();
    }
}
