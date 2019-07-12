package com.jk.service;

import com.jk.mapper.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikeServiceImpl implements LikeService{
    @Autowired
    private LikeMapper likeMapper;

    @Override
    @RequestMapping("opShou")
    public void addInfuser(@RequestParam("infId") String infId, @RequestParam("userId") Integer userId) {

        Integer in = Integer.valueOf(infId);


               likeMapper.addInfuser(in, userId);

    }

    @Override
    public void delInfuser(String infId, Integer userId) {
        Integer in = Integer.valueOf(infId);
        likeMapper.delInfuser(in,userId);
    }


}
