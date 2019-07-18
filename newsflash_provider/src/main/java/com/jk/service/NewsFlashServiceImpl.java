package com.jk.service;

import com.jk.dao.NewsFlashMapper;
import com.jk.pojo.NewsFlash;
import com.jk.pojo.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class NewsFlashServiceImpl  implements NewsFlashService {

    @Autowired
    NewsFlashMapper  newsFlashMapper;

    @Override
    public List<NewsFlash> NewsFlashList(Integer start, Integer rows) {
        return newsFlashMapper.NewsFlashList(start,rows);
    }

    @Override
    public long queryCount() {
        return newsFlashMapper.queryCount();
    }

    @Override
    public void delById(Integer flashid) {
        newsFlashMapper.delById(flashid);
        System.out.println(flashid+  "Impl");
    }

    @Override
    public void addNewsFlash(NewsFlash newsFlash) {





        Date date = new Date();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        newsFlash.setCreattime(df.format(date));

        System.out.println(df.format(date));
        newsFlashMapper.insert(newsFlash);
    }

    @Override
    public NewsFlash queryNewsById(Integer flashid) {
        return newsFlashMapper.queryNewsById(flashid);
    }

    @Override
    public void UpdNews(NewsFlash newsFlash) {
        Date date1 = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        newsFlash.setCreattime(sdf.format(date1));
        System.out.println(sdf.format(date1));
        newsFlashMapper.updateByPrimaryKey(newsFlash);
    }

    @Override
    public List<NewsFlash> NewsQueryAll() {
        return newsFlashMapper.NewsQueryAll();
    }

    @Override
    public List<NewsFlash> queryNews() {
        return newsFlashMapper.queryNews();
    }

    @Override
    public NewsFlash queryNewsFlashById(Integer flashid) {
        return newsFlashMapper.queryNewsFlashById(flashid);
    }

    @Override
    public List<NewsFlash> queryNewsAll() {
        return newsFlashMapper.queryNewsAll();
    }




    @Override
    public NewsFlash queryNewsFlashByIdPlusOne(Integer flashid) {
        System.out.println(flashid);
        return newsFlashMapper.queryNewsFlashByIdPlusOne(flashid);
    }

    @Override
    public List<NewsFlash> queryNext(Integer flashid) {
        return newsFlashMapper.queryNext(flashid);
    }


}
