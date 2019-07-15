package com.jk.service;

import com.jk.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Administrator
 * @title: UserinfoService
 * @projectName knowstars78
 * @description: TODO
 * @date 2019/7/9 000917:41
 */
public interface UserinfoService {
    @RequestMapping("findUserinfo")
    User findUserinfo(Integer userId);

    @PostMapping("saveUser")
    void saveUser(User user);

    @PostMapping("updatePass")
    void updatePass(User user);

    @RequestMapping("findCollect")
    List<User> findCollect(Integer userid);

    @PostMapping("cancelColl")
    void cancelColl(Integer infuserId);
}
