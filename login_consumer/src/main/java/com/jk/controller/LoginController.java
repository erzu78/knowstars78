package com.jk.controller;

import com.jk.cliservice.CliService;
import com.jk.pojo.Staff;
import com.jk.pojo.User;
import com.jk.service.LoginService;
import com.jk.util.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private CliService cliService;

    @Autowired
    private LoginService loginService;

    //用户登录页面
    @RequestMapping(value="loginuser")
    public String loginuser(User loginuser){
        User userModel=loginService.login(loginuser);
        if(userModel!=null){
            return "1";
        }else{
            return "2";
        }
    }

    //用户注册
    @RequestMapping("addLoginUser")
    public String addLoginUser(User loginuser) {
        String str = loginService.addLoginUser(loginuser);
        return str;
    }

    //用户查询页面
    @RequestMapping("findUser")
    public HashMap<String,Object> findUser(@RequestParam("start") Integer start, @RequestParam("pageSize") Integer pageSize){
        HashMap<String,Object> hashMap=loginService.findUser(start,pageSize);
        return hashMap;
    }

    //用户删除
    @RequestMapping("delOne")
    public String delOne(@RequestParam("uid")Integer uid){
        loginService.delOne(uid);
        return null;
    }

   //员工登录页面
    @RequestMapping(value="loginstaff")
    public String loginstaff(Staff loginstaff){
        Staff staffModel=loginService.loginstaff(loginstaff);
        if(staffModel!=null){
            return "1";
        }else{
            return "2";
        }
    }

    //员工注册
    @RequestMapping("addLoginStaff")
    public String addLoginStaff(Staff loginstaff) {
        String str = loginService.addLoginStaff(loginstaff);
        return str;
    }

    //员工查询页面
    @RequestMapping("findStaff")
    public HashMap<String,Object> findStaff(@RequestParam("start") Integer start, @RequestParam("pageSize") Integer pageSize){
        HashMap<String,Object> hashMap=loginService.findStaff(start,pageSize);
        return hashMap;
    }

    /**
     *手机验证码
     */
    @RequestMapping("sendPhoneCode")
    @ResponseBody
    public Map<String, Object> sendPhoneCode(String phoneName){
        String flg=null;//1 发送成功  2发送失败


        int newcode = (int)(Math.random()*899999)+100000;
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("mobile",phoneName);
        hashMap.put("tpl_id","172497");
        hashMap.put("tpl_value","%23code%23%3D"+newcode);
        hashMap.put("key","5528967c9bf6b1568e5385379e754630");

        try {
            String s = HttpClient.sendGet("http://v.juhe.cn/sms/send", hashMap);
            flg="1";
            hashMap.put("flg",1);
        } catch (Exception e) {
            e.printStackTrace();
            hashMap.put("flg",2);
        }
        hashMap.put("newcode",newcode);
        return hashMap;
    }

}
