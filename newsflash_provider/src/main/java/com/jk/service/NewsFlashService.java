package com.jk.service;

import com.jk.pojo.NewsFlash;

import java.util.List;

public interface NewsFlashService {
    List<NewsFlash> NewsFlashList(Integer start, Integer rows);

    long queryCount();

    void delById(Integer flashid);

    void addNewsFlash(NewsFlash newsFlash);

    NewsFlash queryNewsById(Integer flashid);

    void UpdNews(NewsFlash newsFlash);
}
