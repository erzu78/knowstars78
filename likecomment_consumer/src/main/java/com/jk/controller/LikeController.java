package com.jk.controller;

import com.jk.service.LikeServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class LikeController {
    @Autowired
    private LikeServiceFeign likeServiceFeign;
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     *
     * @param key
     * @param liveTime
     * @return
     */
    @RequestMapping("zizi")
    public Long incr(String key, long liveTime) {
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        Long increment = entityIdCounter.getAndIncrement();

        if ((null == increment || increment.longValue() == 0) && liveTime > 0) {//初始设置过期时间
            entityIdCounter.expire(liveTime, TimeUnit.SECONDS);
        }

        return increment;
    }
/**
     * @Description: 初始化自增长值
     * @param key key
     * @param liveTime 当前值
    */
@RequestMapping("zeng")
    public void setIncr(String key, long liveTime) {
              RedisAtomicLong counter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
               counter.set(liveTime);
                counter.expire(0, TimeUnit.SECONDS);
             }

   /* @GetMapping("add")
    public void addOne(){
        redisTemplate.opsForValue().set("liveTime","1");
    }

    @GetMapping("findredisTest")
    public String findredisTest(){
        String str = (String) redisTemplate.opsForValue().get("liveTime");
        return str;
    }*/

}
