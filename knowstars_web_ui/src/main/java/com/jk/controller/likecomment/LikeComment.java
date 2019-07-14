package com.jk.controller.likecomment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LikeComment {

    /**
     * 跳转点赞
     * @return
     */
    @RequestMapping("toCouponList")
    public String toCouponList(){
        return "likecomment/likecomment";
    }


}
