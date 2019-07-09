package com.jk.service;

import com.jk.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoServiceImpl implements VideoService {

                    @Autowired(required = true)
                    private VideoMapper videoMapper;


    @Override
    @GetMapping("getVideo")
    public String getVideo() {
        return "调用生产者success";
    }


}
