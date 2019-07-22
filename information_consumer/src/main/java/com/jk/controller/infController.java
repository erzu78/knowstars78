package com.jk.controller;


import com.alibaba.fastjson.JSONObject;
import com.jk.pojo.Information;
import com.jk.pojo.Staff;
import com.jk.pojo.Topic;
import com.jk.pojo.Ty;
import com.jk.service.InfService;
import com.jk.service.InfServiceFeign;
import com.jk.util.OSSClientUtil;
import com.sun.xml.internal.ws.api.server.SDDocumentFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class infController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private InfServiceFeign infServiceFeign;

    @RequestMapping("/infoList")
    @ResponseBody
    //分页查询资讯列表
    public Map<String, Object> userList(@RequestParam(value = "start") Integer start, @RequestParam(value = "rows") Integer rows) {
        List<Information> list = infServiceFeign.InfoList(start, rows);
        long count = infServiceFeign.queryCount();
        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("rows", list);
        return map;
    }
    //我的资讯
    @RequestMapping("/MyInfoList")
    @ResponseBody
    //分页查询资讯列表
    public Map<String, Object> MyInfoList(@RequestParam(value = "start") Integer start, @RequestParam(value = "rows") Integer rows) {
        String staffString = (String) redisTemplate.opsForValue().get("staffjs");
        Staff staff = JSONObject.parseObject(staffString, Staff.class);

        List<Information> list = infServiceFeign.MyInfoList(start, rows,staff.getSid());
        long count = infServiceFeign.queryCountt(staff.getSid());
        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("rows", list);
        return map;
    }
    @RequestMapping("toSaa")
    public String toSa() {
        String staffString = (String) redisTemplate.opsForValue().get("staffjs");
    /*    Staff staff = JSONObject.parseObject(staffString, Staff.class);*/
        return  staffString;
    }










    @RequestMapping("/deleteInfo")
    @ResponseBody
    //删除方法
    public void deleteInfo(@RequestParam(value="infid") Integer infid){
        infServiceFeign.deleteInfo(infid);
    }
    @PostMapping ("/addInfo")
    @ResponseBody
    //新增方法
    public void add(Information information){
   String staffString = (String) redisTemplate.opsForValue().get("staffjs");
        Staff staff =  JSONObject.parseObject(staffString, Staff.class);
        System.out.println(staff.getSid());
       information.setAuthorid(staff.getSid());
        information.setHot(1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        information.setReleasetime(sdf.format(new Date()));
        infServiceFeign.add(information);
    }
    @RequestMapping("/queryInfoById")
    @ResponseBody
    //修改回显
    public Information queryInfoById(@RequestParam(value="infid") Integer infid){
        System.out.println(infid);
        return infServiceFeign.queryInfoById(infid);
    }
    @RequestMapping("/upInfo")
    @ResponseBody
    //修改方法
    public void upInfo(Information information){
        information.setAuthorid(2);
        information.setHot(1);
        infServiceFeign.upInfo(information);
    }
    @RequestMapping("/deleteAllInfo")
    @ResponseBody
    //批量删除
    public void deleteAllInfo(@RequestParam(value="ids")String ids){
        infServiceFeign.deleteAllInfo(ids);
        }
    @RequestMapping("/updaloadImg")
    @ResponseBody
    //oss图片上传
    public HashMap<String, Object> uploadImg(MultipartFile imgg) throws IOException {
        if (imgg == null || imgg.getSize() <= 0) {

            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient = new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(imgg);
        String imgUrl = ossClient.getImgUrl(name);
        System.out.println(imgUrl);
      /*  String[] split = imgUrl.split("\\?");
        System.out.println(split[0]);*/
        Map<String, Object> map = new HashMap<>();
        map.put("imngName", imgUrl);

        return (HashMap<String, Object>) map;
    }
    @RequestMapping("/toZww")
    @ResponseBody
    //显示更多
    public List<Information> toZww(@RequestParam(value="start") Integer start, @RequestParam(value="rows")Integer rows){
         return  infServiceFeign.InfoList(start,rows);
    }
    @RequestMapping("/queryTy")
    @ResponseBody
    //查询类型
    public List<Ty> queryTy(){
      return   infServiceFeign .queryTy();
    }
    @RequestMapping("/toZwww")
    @ResponseBody
    public List<Information> toZwww(@RequestParam(value="start") Integer start, @RequestParam(value="rows")Integer rows,@RequestParam(value="tid")Integer tid){
        System.out.println(start);
        System.out.println(rows);
        System.out.println(tid);
        return  infServiceFeign.toZwww(start,rows,tid);
    }
    @RequestMapping("/queryStaff")
    @ResponseBody
    //作者查询
    public List<Staff> queryStaff(){
        return  infServiceFeign.queryStaff();
    }
    @RequestMapping("/queryTopicc")
    @ResponseBody
    public List<Topic> queryTopicc(){
        return infServiceFeign.queryTopicc();
    }
    @RequestMapping("/queryTopic")
    @ResponseBody
    public List<Topic> queryTopic(){
        return infServiceFeign.queryTopic();
    }
    @RequestMapping("/tyList")
    @ResponseBody
    //分页查询类别列表
    public Map<String,Object> tyList(@RequestParam(value="start") Integer start, @RequestParam(value="rows")Integer rows ) {
        List<Ty> list= infServiceFeign.tyList(start,rows);
        long count = infServiceFeign.queryTyCount();
        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("rows",list);
        return map;
    }
    @PostMapping ("/addTy")
    @ResponseBody
    //新增方法
    public void addTy(Ty ty){
        infServiceFeign.addTy(ty);
    }
    @RequestMapping("/deleteTy")
    @ResponseBody
    //删除种类方法
    public void deleteTy(@RequestParam(value="tid") Integer tid){

        infServiceFeign.deleteTy(tid);
    }
    @RequestMapping("/queryTyById")
    @ResponseBody
    //修改回显
    public Ty queryTyById(@RequestParam(value="tid") Integer tid){
        return infServiceFeign.queryTyById(tid);
    }
    @RequestMapping("/upTy")
    @ResponseBody
    //修改方法
    public void upTy(Ty ty){
        infServiceFeign.upTy(ty);
    }
    @RequestMapping("/deleteAllTy")
    @ResponseBody
    //批量删除
    public void deleteAllTy(@RequestParam(value="ids")String ids){
        infServiceFeign.deleteAllTy(ids);
    }
    @RequestMapping("/queryWzById")
    @ResponseBody
    public List<Information> queryWzById(@RequestParam(value="infid") Integer infid){

        List<Information> in= infServiceFeign.queryWzById(infid);
        return in;
    }
    @RequestMapping("/queryCc")
    @ResponseBody
    public Integer queryCc(@RequestParam(value="infid") Integer infid){
        System.out.println(infid);
        Integer dd= infServiceFeign.queryCc(infid);
        System.out.println(dd);
        return dd;
    }
    //查找进几条
    @RequestMapping("/queryClo")
    @ResponseBody
    public List<Information> queryClo(@RequestParam(value="infid") Integer infid){
         return infServiceFeign.queryClo(infid);
    }
    //下一篇
    @RequestMapping("/queryXa")
    @ResponseBody
    public List<Information> queryXa(@RequestParam(value="infid") Integer infid){
        return infServiceFeign.queryXa(infid);
    }
    @RequestMapping("queryAllWz")
    @ResponseBody
    public List<Information> queryAllWz(@RequestParam(value="infid") Integer infid){
         return infServiceFeign.queryAllWz(infid);
    }
    @RequestMapping("queryAllWzBySid")
    @ResponseBody
    public List<Information> queryAllWzBySid(@RequestParam(value="sid") Integer sid){
        return infServiceFeign.queryAllWzBySid(sid);
    }
    @RequestMapping("queryCountById")
    @ResponseBody
    public Integer queryCountById(@RequestParam(value="sid") Integer sid){
        System.out.println(sid);
        Integer dd= infServiceFeign.queryCountById(sid);
        System.out.println(dd);
        return dd;
    }
    @RequestMapping("queryTyy")
    @ResponseBody
    public List<Ty> queryTyy(@RequestParam(value="start") Integer start, @RequestParam(value="rows")Integer rows){
        return infServiceFeign.queryTyy(start,rows);
    }
    @RequestMapping("queryTopicWz")
    @ResponseBody
    public List<Information> queryTopicWz(@RequestParam(value="topicid") Integer topicid){
          return infServiceFeign.queryTopicWz(topicid);
    }
    @RequestMapping("queryTopicByTid")
    @ResponseBody
    public List<Topic> queryTopicByTid(@RequestParam(value="tid") Integer tid){
        return infServiceFeign.queryTopicByTid(tid);
    }
    @RequestMapping("/topicList")
    @ResponseBody
    //分页查询资讯列表
    public Map<String,Object> topicList(@RequestParam(value="start") Integer start, @RequestParam(value="rows")Integer rows ) {
        List<Topic> list= infServiceFeign.topicList(start,rows);
        long count = infServiceFeign.queryTopicCount();
        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("rows",list);
        return map;
    }
    @PostMapping ("/addTopic")
    @ResponseBody
    //新增方法
    public void addTy(Topic topic){
        infServiceFeign.addTopic(topic);
    }
    //修改回显
    @RequestMapping("/queryTopicById")
    @ResponseBody
    //修改回显
    public Topic queryTopicById(@RequestParam(value="topicid") Integer tid){
        return infServiceFeign.queryTopicById(tid);
    }
    @RequestMapping("upTopic")
    @ResponseBody
    public void upTopic(Topic topic){
        infServiceFeign.upTopic(topic);
    }
    @RequestMapping("/deleteTopic")
    @ResponseBody
    //删除种类方法
    public void deleteTopic(@RequestParam(value="topicid") Integer topicid){

        infServiceFeign.deleteTopic(topicid);
    }
    @RequestMapping("/deleteAllTopic")
    @ResponseBody
    //删除种类方法
    public void deleteAllTopic(@RequestParam(value="ids") String ids){

        infServiceFeign.deleteAllTopic(ids);
    }
}
