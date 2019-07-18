package com.jk.dao;

import com.jk.pojo.NewsFlash;
import com.jk.pojo.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsFlashMapper {
    int deleteByPrimaryKey(@Param("flashid")Integer  flashid);

    int insert(NewsFlash newsFlash);

    int insertSelective(NewsFlash newsFlash);

    NewsFlash selectByPrimaryKey(Integer flashid);

    int updateByPrimaryKeySelective(NewsFlash newsFlash);

    int updateByPrimaryKeyWithBLOBs(NewsFlash newsFlash);

    int updateByPrimaryKey(NewsFlash newsFlash);

    List<NewsFlash> NewsFlashList(@Param("start") Integer start, @Param("rows") Integer rows);

    long queryCount();

    void delById(@Param("flashid") Integer flashid);

    NewsFlash queryNewsById(@Param("flashid") Integer flashid);


    List<NewsFlash> NewsQueryAll();

    List<NewsFlash> queryNews();

    NewsFlash queryNewsFlashById(@Param("flashid")Integer flashid);

    List<NewsFlash> queryNewsAll();


    NewsFlash queryNewsFlashByIdPlusOne(@Param("flashid")Integer flashid);

    List<NewsFlash> queryNext(@Param("flashid")Integer flashid);
}