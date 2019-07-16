package com.jk.mapper;

import com.jk.pojo.Information;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InformationMapper {
    int deleteByPrimaryKey(Integer infid);

    int insert(Information information);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Integer infid);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);

    List<Information> infoList(@Param("start") Integer start, @Param("rows") Integer rows);
    long queryCount();

    void delAll(@Param("ids") String ids);

    List<Information> toZwww(@Param("start") Integer start, @Param("rows") Integer rows, @Param("tid") Integer tid);

   List<Information>  queryWzById(Integer infid);
}