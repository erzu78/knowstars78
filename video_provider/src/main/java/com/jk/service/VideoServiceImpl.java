package com.jk.service;

import com.jk.mapper.VideoMapper;
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


}
