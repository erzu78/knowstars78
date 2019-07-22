package com.jk.service;

import com.jk.mapper.LoginMapper;
import com.jk.pojo.Staff;
import com.jk.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @RequestMapping("findUser")
    @Override
    public HashMap<String,Object> findUser(@RequestParam("start") Integer start, @RequestParam("pageSize") Integer pageSize) {
        HashMap<String,Object> hashMap=new HashMap<>();
        List<User> list=loginMapper.findUser(start,pageSize);
        Long UserSum=loginMapper.UserSum();
        hashMap.put("rows",list);
        hashMap.put("total",UserSum);
        return hashMap;
    }

    @RequestMapping("delOne")
    @Override
    public void delOne(@RequestParam("uid")Integer uid) {
        loginMapper.delOne(uid);
    }

    @RequestMapping(value="loginuser")
    @Override
    public User login(@RequestBody User loginuser) {
        return loginMapper.findUserByNamePWD(loginuser);
    }

    @RequestMapping(value="addLoginUser")
    @Override
    public String addLoginUser(@RequestBody User loginuser) {
        String str = "";
        //1 代表 失败 用户名相同  2代表成功
        Integer count = loginMapper.findUserByName(loginuser.getUsername());
        if (count != null && count > 0) {
            str = "1";
            System.out.println("已经存在相同用户名");
        } else {
            loginMapper.addLoginUser(loginuser);
            str = "2";
        }
        return str;
    }

    @RequestMapping(value="loginstaff")
    @Override
    public Staff loginstaff(@RequestBody Staff loginstaff) {
        return loginMapper.findStaffByNamePWD(loginstaff);
    }

    @RequestMapping(value="addLoginStaff")
    @Override
    public String addLoginStaff(@RequestBody Staff loginstaff) {
        String str = "";
        //1 代表 失败 用户名相同  2代表成功
        Integer count = loginMapper.findStaffByName(loginstaff.getStaffname());
        if (count != null && count > 0) {
            str = "1";
            System.out.println("已经存在相同用户名");
        } else {
            loginMapper.addLoginStaff(loginstaff);
            str = "2";
        }
        return str;
    }

    @RequestMapping("findStaff")
    @Override
    public HashMap<String, Object> findStaff(Integer start, Integer pageSize) {
        HashMap<String,Object> hashMap=new HashMap<>();
        List<Staff> list=loginMapper.findStaff(start,pageSize);
        Long UserSum=loginMapper.StaffSum();
        hashMap.put("rows",list);
        hashMap.put("total",UserSum);
        return hashMap;
    }


    @RequestMapping("findStaff2")
    @Override
    public HashMap<String, Object> findStaff2(Integer start, Integer pageSize) {
        HashMap<String,Object> hashMap=new HashMap<>();
        List<Staff> list=loginMapper.findStaff2(start,pageSize);
        Long UserSum=loginMapper.StaffSum2();
        hashMap.put("rows",list);
        hashMap.put("total",UserSum);
        return hashMap;
    }

    @RequestMapping("finduserByUserName")
    @Override
    public User finduserByUserName(String username) {
        User list=loginMapper.finduserByUserName(username);
        return list;
    }


    @RequestMapping("updaterole")
    @Override
    public void updaterole(String sid) {
       loginMapper.updaterole(sid);

    }

    @RequestMapping("yeshenhe")
    @Override
    public void yeshenhe(String sid) {
        loginMapper.yeshenhe(sid);
    }

    @RequestMapping("deleteStaffOne")
    @Override
    public void deleteStaffOne(String sid) {
        loginMapper.deleteStaffOne(sid);
    }

    @RequestMapping("findStaffById")
    @Override
    public Staff findStaffById(String staffname) {
        Staff staff=loginMapper.findStaffById(staffname);
        return staff;
    }

    @RequestMapping("updateStaff")
    @Override
    public void updateStaff(@RequestBody Staff staff) {
        loginMapper.updateStaff(staff);
    }
}