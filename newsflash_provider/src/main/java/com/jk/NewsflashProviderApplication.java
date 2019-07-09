package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.jk.dao")
public class NewsflashProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsflashProviderApplication.class, args);
	}

}
