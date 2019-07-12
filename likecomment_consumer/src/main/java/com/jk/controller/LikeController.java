package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.service.LikeServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class LikeController {
   /* @Autowired
    private LikeServiceFeign likeServiceFeign;*/


    @Autowired
    private RedisTemplate redisTemplate;



    /**
     * 操作点赞
     * @param infId
     * @return
     */
    @RequestMapping("zizi")
    public void incr(String infId) {

        Integer userId = 25;
        String inId = (String) redisTemplate.opsForValue().get("userZhan"+userId+infId);

        if(inId!=null){

                redisTemplate.boundValueOps("infzhan"+infId).increment(-1);

                redisTemplate.delete("userZhan"+userId+infId);

        } else{
            RedisAtomicLong entityIdCounter = new RedisAtomicLong("infzhan"+infId, redisTemplate.getConnectionFactory());
            entityIdCounter.getAndIncrement();
            redisTemplate.opsForValue().set("userZhan"+userId+infId,infId);
        }

    }

    /**
     * 查询点赞
     * @param infId
     * @return
     */
    @GetMapping("queryZhan")
    public HashMap<String,String> queryZhan(String infId){

        Integer userId = 25;

        String zhanCount = (String) redisTemplate.opsForValue().get("infzhan"+infId);
        String inId = (String) redisTemplate.opsForValue().get("userZhan"+userId+infId);

        HashMap<String,String> map = new HashMap<>();
        map.put("zhanCount",zhanCount);
        map.put("inId",inId);

        return map;
    }


    /**
     * 操作收藏
     * @param infId
     */
    @RequestMapping("opShou")
    public void opShou(String infId) {

        Integer userId = 25;
        String inId = (String) redisTemplate.opsForValue().get("userShou"+userId+infId);

        if(inId!=null){

            redisTemplate.boundValueOps("infshou"+infId).increment(-1);

            redisTemplate.delete("userShou"+userId+infId);

        } else{
            RedisAtomicLong entityIdCounter = new RedisAtomicLong("infshou"+infId, redisTemplate.getConnectionFactory());
            entityIdCounter.getAndIncrement();
            redisTemplate.opsForValue().set("userShou"+userId+infId,infId);
        }

    }

    /**
     * 查询收藏数量
     * @param infId
     * @return
     */
    @GetMapping("queryShou")
    public HashMap<String,String> queryShou(String infId){

        Integer userId = 25;

        String shouCount = (String) redisTemplate.opsForValue().get("infshou"+infId);
        String inId = (String) redisTemplate.opsForValue().get("userShou"+userId+infId);

        HashMap<String,String> map = new HashMap<>();
        map.put("shouCount",shouCount);
        map.put("inId",inId);

        return map;
    }


}
