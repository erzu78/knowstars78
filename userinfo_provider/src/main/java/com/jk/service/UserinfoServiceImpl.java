package com.jk.service;

import com.jk.mapper.UserinfoMapper;
import com.jk.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Administrator
 * @title: UserinfoServiceImpl
 * @projectName knowstars78
 * @description: TODO
 * @date 2019/7/9 000917:37
 */
@RestController
public class UserinfoServiceImpl implements UserinfoService{

    @Autowired
    private UserinfoMapper userinfoMapper;


    @Override

    public User findUserinfo(@RequestBody Integer userId) {
        return userinfoMapper.findUserinfo(userId);
    }

    @Override
    public void saveUser(@RequestBody User user) {
        userinfoMapper.saveUser(user);
    }

    @Override
    public void updatePass(@RequestBody User user ) {
        userinfoMapper.updatePass(user);
    }

    @Override
    public List<User> findCollect(@RequestBody Integer userid) {
        return userinfoMapper.findCollect(userid);
    }

    @Override
    public void cancelColl(@RequestBody Integer infuserId) {
        userinfoMapper.cancelColl(infuserId);
    }
}
