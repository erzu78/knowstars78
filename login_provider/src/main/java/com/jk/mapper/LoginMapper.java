package com.jk.mapper;

import com.jk.pojo.Staff;
import com.jk.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface LoginMapper {



    @Select("SELECT * FROM  t_user tu  WHERE tu.username = #{username} AND tu.password = #{password} ")
    User findUserByNamePWD(User loginuser);

    @Select("select count(*) from t_user where username=#{username}")
    Integer findUserByName(String username);

    @Insert("insert into t_user(username,password) values(#{username},#{password})")
    void addLoginUser(User loginuser);

    List<User> findUser(Integer start, Integer pageSize);

    @Select("select count(*) from t_user")
    Long UserSum();

    @Delete("delete  from t_user where uid=#{uid}")
    void delOne(Integer uid);

    @Select("select * from t_staff where staffname=#{staffname} and staffpassword=#{staffpassword}")
    Staff findStaffByNamePWD(Staff loginstaff);

    @Select("select count(*) from t_staff where staffname=#{staffname}")
    Integer findStaffByName(String staffname);

    @Insert("insert into t_staff(staffname,staffpassword,role,staffstatus) values(#{staffname},#{staffpassword},0,0)")
    void addLoginStaff(Staff loginstaff);

    List<Staff> findStaff(Integer start, Integer pageSize);

    List<Staff> findStaff2(Integer start, Integer pageSize);

    @Select("select count(*) from t_staff where staffstatus=0")
    Long StaffSum();

    @Select("select count(*) from t_staff where staffstatus=1")
    Long StaffSum2();

    @Select("select uid from t_user where username=#{username}")
    User finduserByUserName(String username);

    @Update("update t_staff set role=1 where sid=#{sid}")
    void updaterole(String sid);

    @Update("update t_staff set staffstatus=0 where sid=#{sid}")
    void yeshenhe(String sid);

    @Update("delete from  t_staff where sid=#{sid}")
    void deleteStaffOne(String sid);

    @Select("select * from t_staff where staffname=#{staffname}")
    Staff findStaffById(String staffname);

    @Update("update  t_staff set staffimg=#{staffimg},staffinfo=#{staffinfo},stafftype=#{stafftype} where sid=#{sid}")
    void updateStaff(Staff staff);
}
