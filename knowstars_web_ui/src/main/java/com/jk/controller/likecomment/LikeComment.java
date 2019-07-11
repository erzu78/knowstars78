package com.jk.controller.likecomment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LikeComment {
    @RequestMapping("toCouponList")
    public String toCouponList(){
        return "likecomment/likecomment";
    }

    @RequestMapping("toShowDiscuss")
    public String toShowDiscuss(){
        return "likecomment/likecomment";
    }

}
