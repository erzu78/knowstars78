package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LikeComment {
    @RequestMapping("toCouponList")
    public String toCouponList(){
        return "likecomment";
    }

}