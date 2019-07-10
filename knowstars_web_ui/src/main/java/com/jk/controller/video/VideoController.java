package com.jk.controller.video;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VideoController {


       //去首页视频页面
      @RequestMapping("toHomeVideo")
      public String toHomeVideo(){
          return "video/homeVideo";
      }

    //去后台视频展示页面
    @RequestMapping("toVideoShow")
    public String tologin(){
        return "video/videoShow";
    }

    //打开后台新增弹框
    @RequestMapping("toAddVideoDialog")
    public String toAddVideoDialog(){
          return "video/addVideoDialog";
    }



}
