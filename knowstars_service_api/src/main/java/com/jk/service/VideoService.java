package com.jk.service;

import com.jk.pojo.Video;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface VideoService {

    @GetMapping("getVideo")
    String getVideo();

    @GetMapping("queryVideoCount")
    Integer queryVideoCount();

    @GetMapping("queryVideo/{start}/{pageSize}")
    List<Video> queryVideo(@PathVariable(value = "start") Integer start,@PathVariable(value = "pageSize") Integer pageSize);

    @PostMapping("saveVideo")
    void saveVideo(Video video);

    @GetMapping("queryAboutVideo")
    List<Video> queryAboutVideo();
}
