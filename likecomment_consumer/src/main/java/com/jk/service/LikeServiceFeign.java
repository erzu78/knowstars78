package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "likecomment-provider")
public interface LikeServiceFeign extends LikeService{

}
