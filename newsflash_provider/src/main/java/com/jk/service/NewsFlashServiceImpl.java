package com.jk.service;

import com.jk.dao.NewsFlashMapper;
import com.jk.pojo.NewsFlash;
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

      /*  Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String sd = sdf.format(date);
        newsFlash.setCreattime(sd);
        System.out.println(newsFlash);*/
        newsFlashMapper.insert(newsFlash);
    }

    @Override
    public NewsFlash queryNewsById(Integer flashid) {
        return newsFlashMapper.queryNewsById(flashid);
    }

    @Override
    public void UpdNews(NewsFlash newsFlash) {
        newsFlashMapper.updateByPrimaryKey(newsFlash);
    }
}
