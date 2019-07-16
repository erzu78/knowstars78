package com.jk.controller.video;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    //点击一个视频携带着Id跳转到此视频的介绍页面
    @RequestMapping("toSingleVideo")
    public String toSingleVideo(Integer viId, Model model){
          model.addAttribute("viId",viId);
          return "video/singleVideo";
    }
    //打开后台修改页面
    @RequestMapping("toUpdateVideoDialog")
    public String toUpdateVideoDialog(){
          return "video/upVideoDialog";
    }
    //携带着Id跳转到最近视频页面
    @RequestMapping("latelyVideo")
    public String latelyVideo(Integer vid,Model model){
        model.addAttribute("vid",vid);
        return "video/recentVideo";
    }
    //去推荐作者的视频信息页面
    @RequestMapping("toAuthorVideo")
    public String toAuthorVideo(Integer authorId,Model model){
          model.addAttribute("authorId",authorId);
          return "video/authorVideo";
    }

    //去轮播图展示页面 测试
    @RequestMapping("toLunBo")
    public String toLunBo(){
        return "video/test";
    }




}
