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



    @Select("select * from t_user where username=#{username} and password=#{password}")
    User findUserByNamePWD(User loginuser);

    @Select("select count(*) from t_user where username=#{username}")
    Integer findUserByName(String username);

    @Insert("insert into t_user(username,password) values(#{username},#{password})")
    void addLoginUser(User loginuser);

    List<User> findUser(Integer start, Integer pageSize);

    @Select("select count(*) from t_user ")
    Long UserSum();

    @Delete("delete  from t_user where uid=#{uid}")
    void delOne(Integer uid);

    @Select("select * from t_staff where staffname=#{staffname} and staffpassword=#{staffpassword}")
    Staff findStaffByNamePWD(Staff loginstaff);

    @Select("select count(*) from t_staff where staffname=#{staffname}")
    Integer findStaffByName(String staffname);

    @Insert("insert into t_staff(staffname,staffpassword,role) values(#{staffname},#{staffpassword},0)")
    void addLoginStaff(Staff loginstaff);

    List<User> findStaff(Integer start, Integer pageSize);

    @Select("select count(*) from t_staff ")
    Long StaffSum();

    @Select("select uid from t_user where username=#{username}")
    User finduserByUserName(String username);

    @Update("update t_staff set role=1 where sid=#{sid}")
    void updaterole(String sid);
}
