package com.jk.mapper;

import com.jk.pojo.Ty;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TyMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Ty ty);

    int insertSelective(Ty record);

    Ty selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Ty record);

    int updateByPrimaryKey(Ty record);

    List<Ty> queryTy();

    List<Ty> tyList(@Param("start") Integer start, @Param("rows") Integer rows);

    long queryTyCount();

    void addTy(Ty ty);

    void deleteAllTy(@Param("ids") String ids);

    List<Ty> queryTyy(@Param("start") Integer start, @Param("rows") Integer rows);
}