package com.jk.dao;

import com.jk.pojo.NewsFlash;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsFlashMapper {
    int deleteByPrimaryKey(@Param("flashid")Integer  flashid);

    int insert(NewsFlash newsFlash);

    int insertSelective(NewsFlash newsFlash);

    NewsFlash selectByPrimaryKey(Integer flashid);

    int updateByPrimaryKeySelective(NewsFlash record);

    int updateByPrimaryKeyWithBLOBs(NewsFlash record);

    int updateByPrimaryKey(NewsFlash record);

    List<NewsFlash> NewsFlashList(@Param("start") Integer start, @Param("rows") Integer rows);

    long queryCount();

    void delById(@Param("flashid") Integer flashid);

    NewsFlash queryNewsById(@Param("flashid") Integer flashid);
}