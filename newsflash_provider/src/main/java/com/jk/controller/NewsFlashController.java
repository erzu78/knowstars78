package com.jk.controller;

import com.jk.pojo.NewsFlash;
import com.jk.service.NewsFlashService;
import com.jk.service.NewsFlashServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @Override
    public void delById(@RequestParam(value="flashid")Integer flashid) {
        newsFlashService.delById(flashid);
    }

    @Override
    public void addNewsFlash( NewsFlash newsFlash) {
        System.out.println(newsFlash.getFlashinfo());
        System.out.println(newsFlash.getFlashtitle());
        newsFlashService.addNewsFlash(newsFlash);
    }





    @Override
    public NewsFlash queryNewsById(@RequestParam(value="flashid")Integer flashid) {
        return newsFlashService.queryNewsById(flashid);
    }

    @Override
    public void UpdNews( NewsFlash newsFlash) {
        newsFlashService.UpdNews(newsFlash);
    }

    @Override
    public List<NewsFlash> NewsQueryAll() {
        return newsFlashService.NewsQueryAll();
    }


}
