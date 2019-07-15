package com.jk.controller;


import com.jk.pojo.Information;
import com.jk.pojo.Staff;
import com.jk.pojo.Topic;
import com.jk.pojo.Ty;
import com.jk.service.InfService;
import com.jk.service.InfServiceFeign;
import com.jk.util.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class infController {
    @Autowired
    private InfServiceFeign infServiceFeign;
    @RequestMapping("/infoList")
    @ResponseBody
    //分页查询资讯列表
    public Map<String,Object> userList(@RequestParam(value="start") Integer start, @RequestParam(value="rows")Integer rows ) {
        List<Information> list= infServiceFeign.InfoList(start,rows);
        long count = infServiceFeign.queryCount();
        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("rows",list);
        return map;
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
       information.setAuthorid(2);
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
        System.out.println(tid);
        return  infServiceFeign.toZwww(start,rows,tid);
    }
    @RequestMapping("/queryStaff")
    @ResponseBody
    //作者查询
    public List<Staff> queryStaff(){
        return  infServiceFeign.queryStaff();
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
}
