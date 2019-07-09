package com.jk.dao;

import com.jk.pojo.NewsFlash;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsFlashMapper {
    int deleteByPrimaryKey(Integer flashid);

    int insert(NewsFlash record);

    int insertSelective(NewsFlash record);

    NewsFlash selectByPrimaryKey(Integer flashid);

    int updateByPrimaryKeySelective(NewsFlash record);

    int updateByPrimaryKeyWithBLOBs(NewsFlash record);

    int updateByPrimaryKey(NewsFlash record);

    List<NewsFlash> NewsFlashList(@Param("start") Integer start, @Param("rows") Integer rows);

    long queryCount();
}