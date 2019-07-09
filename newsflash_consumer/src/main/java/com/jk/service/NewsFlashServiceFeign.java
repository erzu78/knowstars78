package com.jk.service;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "newsflash-provider")
public interface NewsFlashServiceFeign   extends  NewsFlashServiceApi{
}
