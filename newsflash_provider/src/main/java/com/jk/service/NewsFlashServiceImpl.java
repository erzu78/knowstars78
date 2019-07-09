package com.jk.service;

import com.jk.dao.NewsFlashMapper;
import com.jk.pojo.NewsFlash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
