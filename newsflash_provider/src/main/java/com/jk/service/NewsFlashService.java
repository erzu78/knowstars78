package com.jk.service;

import com.jk.pojo.NewsFlash;
import com.jk.pojo.Video;

import java.util.List;

public interface NewsFlashService {
    List<NewsFlash> NewsFlashList(Integer start, Integer rows);

    long queryCount();

    void delById(Integer flashid);

    void addNewsFlash(NewsFlash newsFlash);

    NewsFlash queryNewsById(Integer flashid);

    void UpdNews(NewsFlash newsFlash);


    List<NewsFlash> NewsQueryAll();

    List<NewsFlash> queryNews();

    NewsFlash queryNewsFlashById(Integer flashid);

    List<NewsFlash> queryNewsAll();




    NewsFlash queryNewsFlashByIdPlusOne(Integer flashid);

    List<NewsFlash> queryNext(Integer flashid);
}
