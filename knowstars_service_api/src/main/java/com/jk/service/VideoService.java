package com.jk.service;

import com.jk.pojo.Video;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface VideoService {

    @GetMapping("getVideo")
    String getVideo();

    @GetMapping("queryVideoCount")
    Integer queryVideoCount();

    @GetMapping("queryVideo/{start}/{pageSize}")
    List<Video> queryVideo(@PathVariable(value = "start") Integer start,@PathVariable(value = "pageSize") Integer pageSize);

    @PostMapping("saveVideo")
    void saveVideo(@RequestBody Video video);

    @GetMapping("queryAboutVideo")
    List<Video> queryAboutVideo();

    @GetMapping("querySingleVideo/{videoId}")
    Video querySingleVideo(@PathVariable(value = "videoId") Integer videoId);

    @GetMapping("findVideoById/{vid}")
    Video findVideoById(@PathVariable(value = "vid") Integer vid);

    @PostMapping("updateVideo")
    void updateVideo(Video video);

    @PostMapping("deleteVideo/{vid}")
    void deleteVideo(@PathVariable(value = "vid") Integer vid);
}
