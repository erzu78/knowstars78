package com.jk.controller;


import com.jk.pojo.Information;
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
    public Information queryInfoById(@RequestParam(value="infid") Integer infid){
        System.out.println(infid);
        return infServiceFeign.queryInfoById(infid);
    }
    @RequestMapping("/upInfo")
    @ResponseBody
    public void upInfo(Information information){
        information.setAuthorid(2);
        infServiceFeign.upInfo(information);
    }
    @RequestMapping("/deleteAllInfo")
    @ResponseBody
    public void deleteAllInfo(@RequestParam(value="ids")String ids){
        infServiceFeign.deleteAllInfo(ids);
        }
    @RequestMapping("/updaloadImg")
    @ResponseBody
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

}
