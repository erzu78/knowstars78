package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.cliservice.CliService;
import com.jk.pojo.Staff;
import com.jk.pojo.User;
import com.jk.service.LoginService;
import com.jk.util.HttpClient;
import com.jk.util.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
public class LoginController {

    @Autowired
    private CliService cliService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private RedisTemplate redisTemplate;

    //用户登录页面
    @RequestMapping(value="loginuser")
    public String loginuser(User loginuser){
        User userModel=loginService.login(loginuser);
        if(userModel!=null){
            //将对象或者集合转换成json字符串
            String userjs = JSON.toJSONString(userModel);
            System.out.println("loginuser = [" + userjs + "]");
            redisTemplate.opsForValue().set("userjs",userjs);
            redisTemplate.expire("userjs",3600000, TimeUnit.MILLISECONDS);			//设置一个key 过期时间是10s
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
            if(staffModel.getStaffstatus()!=1){
                //将对象或者集合转换成json字符串
                String staffjs = JSON.toJSONString(staffModel);
                System.out.println("loginstaff = [" + staffjs + "]");
                redisTemplate.opsForValue().set("staffjs",staffjs);
                redisTemplate.expire("userjs",3600000, TimeUnit.MILLISECONDS);
                return "1";
            }else{
                return "3";
            }
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

    //员工查询审核
    @RequestMapping("findStaff")
    public HashMap<String,Object> findStaff(@RequestParam("start") Integer start, @RequestParam("pageSize") Integer pageSize){
        HashMap<String,Object> hashMap=loginService.findStaff(start,pageSize);
        return hashMap;
    }

    //员工查询未审核
    @RequestMapping("findStaff2")
    public HashMap<String,Object> findStaff2(@RequestParam("start") Integer start, @RequestParam("pageSize") Integer pageSize){
        HashMap<String,Object> hashMap=loginService.findStaff2(start,pageSize);
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
        hashMap.put("tpl_id","175070");
        hashMap.put("tpl_value","%23code%23%3D"+newcode);
        hashMap.put("key","0b7984c30e2e0cf4f7078b4dc3e620fa");

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

    //根据用户名查询用户id
    @RequestMapping("finduserByUserName")
    public User finduserByUserName(@RequestParam("username") String username){

        User user=loginService.finduserByUserName(username);
        String userjs = JSON.toJSONString(user);
        redisTemplate.opsForValue().set("userjs",userjs);
        redisTemplate.expire("userjs",3600000, TimeUnit.MILLISECONDS);

        return user;
    }

    //设置作者
    @RequestMapping("updaterole")
    public void updaterole(@RequestParam("sid") String sid){
        loginService.updaterole(sid);

    }


    //审核通过
    @RequestMapping("yeshenhe")
    public void yeshenhe(@RequestParam("sid") String sid){
        loginService.yeshenhe(sid);

    }

    //审核未通过||删除
    @RequestMapping("deleteStaffOne")
    public void deleteStaffOne(@RequestParam("sid") String sid){
        loginService.deleteStaffOne(sid);

    }

    //回显注册信息
    @RequestMapping("findStaffById")
    public Staff findStaffById(@RequestParam("staffname") String staffname){
        Staff staff=loginService.findStaffById(staffname);
        return staff;
    }

    //修改管理人员
    @RequestMapping("updateStaff")
    public void updateStaff(Staff staff){
        loginService.updateStaff(staff);
    }


    /**
     * OSS阿里云上传图片
     */
    @RequestMapping("updaloadImg")
    @ResponseBody
    public HashMap<String, Object> uploadImg(MultipartFile imgg) throws IOException {
        if (imgg == null || imgg.getSize() <= 0) {

            throw new IOException("file不能为空");
        }

        OSSClientUtil ossClient = new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(imgg);
        String imgUrl = ossClient.getImgUrl(name);
        //String[] split = imgUrl.split("\\?");

        Map<String, Object> map = new HashMap<>();
        map.put("imngName", imgUrl);

        return (HashMap<String, Object>) map;
    }






}
