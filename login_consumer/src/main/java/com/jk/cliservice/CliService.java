package com.jk.cliservice;

import com.jk.service.LoginService;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value ="zy-provider")
public interface CliService extends LoginService {
}
