package com.jk.controller.homePage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePage {
    @RequestMapping("toHomePage")
    public String toHomePage(){
        return "homePage/testmain";
    }
}
