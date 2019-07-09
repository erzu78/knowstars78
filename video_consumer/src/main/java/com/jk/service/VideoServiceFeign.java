package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "video-provider")
public interface VideoServiceFeign extends VideoService{


}
