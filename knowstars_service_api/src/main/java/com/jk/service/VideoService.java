package com.jk.service;

import org.springframework.web.bind.annotation.GetMapping;

public interface VideoService {

    @GetMapping("getVideo")
    String getVideo();


}
