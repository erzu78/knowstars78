package com.jk.controller.userinfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 * @title: UserinfoKnow
 * @projectName knowstars78
 * @description: TODO
 * @date 2019/7/9 000921:25
 */
@Controller
public class UserinfoKnow {
    //跳转个人信息页面
    @RequestMapping("toUserinfo")
    public String toUserinfo(){

        return "userinfo/userinfoShow";
    }

    //跳转账号和密码页面

    @RequestMapping("toAccPass")
    public String toAccPass(){

        return "userinfo/accPassShow";
    }




    //跳转我的收藏页面
    @RequestMapping("toCollect")
    public String toCollect(){
        return "userinfo/collectShow";
    }

    @RequestMapping("toUpPassDialog")
    public String toUpPassDialog(Integer userId, Model model){
        model.addAttribute("userId",userId);
        return "userinfo/upPassDialog";
    }

    //跳转搜索页面
    @RequestMapping("toSearch")
    public String toSearch(){
        return "userinfo/searchKnow";
    }
}
