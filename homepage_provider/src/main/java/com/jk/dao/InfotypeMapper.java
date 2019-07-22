package com.jk.dao;

import com.jk.pojo.Infotype;

import java.util.List;

public interface InfotypeMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Infotype record);

    int insertSelective(Infotype record);

    Infotype selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Infotype record);

    int updateByPrimaryKey(Infotype record);

    List<Infotype> queryZiXun();
}
