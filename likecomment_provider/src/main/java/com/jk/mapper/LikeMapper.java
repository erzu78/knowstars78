package com.jk.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface LikeMapper {
    @Insert("INSERT INTO infuser VALUES(infuserId,#{in},#{userId})")
    void addInfuser(@Param("in") Integer in, @Param("userId") Integer userId);
    @Delete("DELETE FROM infuser WHERE infId=#{in} and userId=#{userId}")
    void delInfuser(@Param("in")Integer in, @Param("userId") Integer userId);
}
