package com.jk.controller;

import com.jk.pojo.User;
import com.jk.service.UserinfoServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @title: UserinfoController
 * @projectName knowstars78
 * @description: TODO
 * @date 2019/7/9 000917:57
 */
@RestController
public class UserinfoController {
    @Autowired
    private UserinfoServiceFeign userinfoServiceFeign;


    //个人信息查询
    @RequestMapping("findUserinfo")
    public User findUserinfo(){
        Integer userId = 1;
        User userinfo = userinfoServiceFeign.findUserinfo(userId);
        return userinfo;

    }
}
