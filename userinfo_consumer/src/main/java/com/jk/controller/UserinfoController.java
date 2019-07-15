package com.jk.controller;

import com.jk.pojo.User;
import com.jk.service.UserinfoServiceFeign;
import com.jk.util.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        @ResponseBody
        public User findUserinfo(Integer userId){

            User userinfo = userinfoServiceFeign.findUserinfo(userId);
            return userinfo;

    }


    //个人密码修改
    @PostMapping("updatePass")
    public void updatePass(User user){
        userinfoServiceFeign.updatePass(user);
    }


    //个人信息修改
    @PostMapping("saveUser")
    public void saveUser(User user){
        userinfoServiceFeign.saveUser(user);
    }

    /**
     * OSS阿里云上传图片
     */
    @RequestMapping("updaloadImg")
    @ResponseBody
    public HashMap<String, Object> uploadImg(MultipartFile imgg) throws IOException {
        if (imgg == null || imgg.getSize() <= 0) {

            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient = new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(imgg);
        String imgUrl = ossClient.getImgUrl(name);
      /*  String[] split = imgUrl.split("\\?");*/

        Map<String, Object> map = new HashMap<>();
        map.put("imngName", imgUrl);


        return (HashMap<String, Object>) map;
    }

    //我的收藏
    @RequestMapping("findCollect")
    @ResponseBody
    public List<User> findCollect(Integer userid){

        List<User> collect = userinfoServiceFeign.findCollect(userid);
        return collect;
    }
}
