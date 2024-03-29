package com.jk.service;

import com.jk.pojo.Staff;
import com.jk.pojo.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

public interface LoginService  {

    @RequestMapping(value="loginuser")
    User login(User loginuser);

    @RequestMapping(value="addLoginUser")
    String addLoginUser(User loginuser);

    @RequestMapping("findUser")
    HashMap<String,Object> findUser(@RequestParam("start") Integer start, @RequestParam("pageSize") Integer pageSize);

    @RequestMapping("delOne")
    void delOne(@RequestParam("uid")Integer uid);

    @RequestMapping(value="loginstaff")
    Staff loginstaff(Staff loginstaff);

    @RequestMapping(value="addLoginStaff")
    String addLoginStaff(Staff loginstaff);

    @RequestMapping("findStaff")
    HashMap<String, Object> findStaff(@RequestParam("start") Integer start, @RequestParam("pageSize") Integer pageSize);

    @RequestMapping("findStaff2")
    HashMap<String, Object> findStaff2(@RequestParam("start") Integer start, @RequestParam("pageSize") Integer pageSize);

    @RequestMapping("finduserByUserName")
    User finduserByUserName(@RequestParam("username") String username);

    @RequestMapping("updaterole")
    void updaterole(@RequestParam("sid") String sid);

    @RequestMapping("yeshenhe")
    void yeshenhe(@RequestParam("sid") String sid);

    @RequestMapping("deleteStaffOne")
    void deleteStaffOne(@RequestParam("sid") String sid);

    @RequestMapping("findStaffById")
    Staff findStaffById(@RequestParam("staffname") String staffname);

    @RequestMapping("updateStaff")
    void updateStaff(@RequestBody Staff staff);
}
