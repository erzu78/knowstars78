package com.jk.controller.homepage2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePage {
    @RequestMapping("toHomePage")
    public String toHomePage(){
        return "homePage/testMain";
    }

    @RequestMapping("toTree")
    public String toTree(){
        return "homePage/Tree";
    }
}
