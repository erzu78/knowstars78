package com.jk.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CorsMapping implements WebMvcConfigurer {
    //重写Cors映射方法
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //addMapping 声明那些路径需要跨域访问
        registry.addMapping("/**")
                //声明对某个服务器开启跨域
                .allowedOrigins("http://localhost:8280","http://192.168.1.234:8280")
                //设置允许跨域请求的http类型OPTIONS必须要有
        .allowedMethods("GET","POST","DELETE","PUT","OPTIONS")
        .allowCredentials(true)
                //设置预检存活时间
        .maxAge(3600);
    }
}
