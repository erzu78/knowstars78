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



}
