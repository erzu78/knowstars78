package com.jk.service;

import com.jk.mapper.VideoMapper;
import com.jk.pojo.Staff;
import com.jk.pojo.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VideoServiceImpl implements VideoService {

                    @Autowired(required = true)
                    private VideoMapper videoMapper;


    @Override
    @GetMapping("getVideo")
    public String getVideo() {
        return "调用生产者success";
    }

    @Override
    @GetMapping("queryVideoCount")
    public Integer queryVideoCount() {
        return videoMapper.queryVideoCount();
    }

    @Override
    @GetMapping("queryVideo/{start}/{pageSize}")
    public List<Video> queryVideo(@PathVariable(value = "start") Integer start,@PathVariable(value = "pageSize") Integer pageSize) {
        return videoMapper.queryVideo(start,pageSize);
    }

    @Override
    @PostMapping("saveVideo")
    public void saveVideo(@RequestBody Video video) {
        videoMapper.addVideo(video);
    }

    @Override
    @GetMapping("queryAboutVideo")
    public List<Video> queryAboutVideo() {
        return videoMapper.queryAboutVideo();
    }

    @Override
    public Video querySingleVideo(Integer videoId) {
        return videoMapper.querySingleVideo(videoId);
    }

    @Override
    @GetMapping("findVideoById/{vid}")
    public Video findVideoById(@PathVariable(value = "vid") Integer vid) {
        return videoMapper.findVideoById(vid);
    }

    @Override
    @PostMapping("updateVideo")
    public void updateVideo(@RequestBody Video video) {
        videoMapper.updateVideo(video);
    }

    @Override
    @PostMapping("deleteVideo/{vid}")
    public void deleteVideo(@PathVariable(value = "vid") Integer vid) {
        videoMapper.deleteVideo(vid);
    }

    @Override
    public List<Staff> queryAuthor() {
        return videoMapper.queryAuthor();
    }

    @Override
    @GetMapping("queryGengDuoVideo")
    public List<Video> queryGengDuoVideo() {
        return videoMapper.queryGengDuoVideo();
    }

    @Override
    @GetMapping("queryAuthorVideo/{videoId}")
    public List<Video> queryAuthorVideo(@PathVariable("videoId") Integer videoId) {
        return videoMapper.queryAuthorVideo(videoId);
    }

    @Override
    @GetMapping("queryLunBo")
    public List<Video> queryLunBo() {
        return videoMapper.queryLunBo();
    }


}
