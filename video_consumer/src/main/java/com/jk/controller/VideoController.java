package com.jk.controller;

import com.jk.pojo.Video;
import com.jk.service.VideoServiceFeign;
import com.jk.util.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VideoController {

                   @Autowired
                   private VideoServiceFeign videoServiceFeign;

                   @GetMapping("getVideo")
                   public String getVideo(){
                       return videoServiceFeign.getVideo();
                   }

                   //后台视频查询
                   @GetMapping("queryVideo")
                   public HashMap<String,Object> queryVideo(Integer start,Integer pageSize){
                       Integer sum = videoServiceFeign.queryVideoCount();
                       List<Video> list = videoServiceFeign.queryVideo(start,pageSize);
                       HashMap<String, Object> hashMap = new HashMap<>();
                       hashMap.put("rows",list);
                       hashMap.put("total",sum);
                       return hashMap;
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
        String[] split = imgUrl.split("\\?");

        Map<String, Object> map = new HashMap<>();
        map.put("imngName", split[0]);

        return (HashMap<String, Object>) map;
    }

                  //新增或者修改
                  @PostMapping("saveorupdateVideo")
                  public void saveorupdateVideo(Video video){
                      if (video.getVideoId() != null){
                          videoServiceFeign.updateVideo(video);
                      }else {
                          videoServiceFeign.saveVideo(video);
                      }

                  }

                  //查询前台视频展示专栏
                  @GetMapping("queryAboutVideo")
                  public List<Video> queryAboutVideo(){
                      List<Video> list = videoServiceFeign.queryAboutVideo();
                      return list;
                  }

                  //根据视频Id查询对应的单个视频信息
                  @GetMapping("querySingleVideo")
                  public Video querySingleVideo(Integer videoId){

                      return videoServiceFeign.querySingleVideo(videoId);
                  }

                 //后台 回显
                 @PostMapping("findVideoById")
                 public Video toUpdateVideoDialog(Integer vid){
                    Video video = videoServiceFeign.findVideoById(vid);
                    return video;
                 }
                 //后台删除
                @PostMapping("deleteVideo")
                public void deleteVideo(Integer vid){
                    videoServiceFeign.deleteVideo(vid);
                }



}
