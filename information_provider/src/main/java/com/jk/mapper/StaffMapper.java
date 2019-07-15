package com.jk.mapper;

import com.jk.pojo.Staff;

import java.util.List;

public interface StaffMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    List<Staff> queryStaff();
}