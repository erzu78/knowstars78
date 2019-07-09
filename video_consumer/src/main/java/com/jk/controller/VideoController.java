package com.jk.controller;

import com.jk.service.VideoServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {

                   @Autowired
                   private VideoServiceFeign videoServiceFeign;

                   @GetMapping("getVideo")
                   public String getVideo(){
                       return videoServiceFeign.getVideo();
                   }
}
