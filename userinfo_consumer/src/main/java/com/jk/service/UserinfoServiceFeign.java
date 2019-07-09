package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Administrator
 * @title: UserinfoServiceFeign
 * @projectName knowstars78
 * @description: TODO
 * @date 2019/7/9 000917:58
 */
@FeignClient(value = "userinfo-provider")
public interface UserinfoServiceFeign extends UserinfoService{

}
