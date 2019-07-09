package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "information-provider")
public interface InfServiceFeign extends InfService {

}
