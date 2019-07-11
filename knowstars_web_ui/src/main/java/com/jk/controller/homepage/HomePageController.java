package com.jk.controller.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {


   /*@RequestMapping("toHomePage")
    public  String toHomePage(){
       return "homePage/testMain";
   }*/

    /**
     * 主页面跳转
     * @return
     */
   @RequestMapping("toHome")
    public String toHome(){
       return "homePage/testMain";
   }


}
