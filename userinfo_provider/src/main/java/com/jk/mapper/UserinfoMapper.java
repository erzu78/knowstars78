package com.jk.mapper;

import com.jk.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 * @title: UserinfoMapper
 * @projectName knowstars78
 * @description: TODO
 * @date 2019/7/9 000917:36
 */
public interface UserinfoMapper {
    User findUserinfo(@Param("userId") Integer userId);

    void saveUser(User user);

    void updatePass(User user);

    List<User> findCollect(@Param("userid") Integer userid);

    void cancelColl(@Param("infuserId") Integer infuserId);
}
