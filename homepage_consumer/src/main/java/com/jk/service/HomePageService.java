package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "homepage-provider"/*,fallback = HomePageServiceImpl.class*/)
public interface HomePageService extends HomePageServiceApi {

}
