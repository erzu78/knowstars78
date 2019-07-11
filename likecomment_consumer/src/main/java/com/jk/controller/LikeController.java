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
    public Long incr(String infId, long liveTime) {
        RedisAtomicLong entityIdCounter = new RedisAtomicLong("infzhan"+infId, redisTemplate.getConnectionFactory());
        Long increment = entityIdCounter.getAndIncrement();

        if ((null == increment || increment.longValue() == 0) && liveTime > 0) {//初始设置过期时间
            entityIdCounter.expire(liveTime, TimeUnit.SECONDS);
        }

        return increment;
    }
    @RequestMapping("zizeng")
    public Long incrzi(String heartId, long liveTime) {
        RedisAtomicLong redisAtomicLong = new RedisAtomicLong("infzhan"+heartId, redisTemplate.getConnectionFactory());
        Long incrt = redisAtomicLong.getAndIncrement();

        if ((null == incrt || incrt.longValue() == 0) && liveTime > 0) {//初始设置过期时间
            redisAtomicLong.expire(liveTime, TimeUnit.SECONDS);
        }

        return incrt;
    }
/**
     * @Description: 初始化自增长值
     * @param key key
     * @param liveTime 当前值
    */
   /* @RequestMapping("zeng")
    public void setIncr(String infId, long liveTime) {
              RedisAtomicLong counter = new RedisAtomicLong("infzhan"+infId, redisTemplate.getConnectionFactory());
              counter.set(liveTime);
              counter.expire(0, TimeUnit.SECONDS);
}

    @RequestMapping("zengzeng")
    public void setIncrzeng(String heartId, long liveTime) {
        RedisAtomicLong counter = new RedisAtomicLong("infzhan"+heartId, redisTemplate.getConnectionFactory());
        counter.set(liveTime);
        counter.expire(0, TimeUnit.SECONDS);
    }
*/




    @GetMapping("queryZhan")
    public String queryZhan(String infId){

        String zhanCount = (String) redisTemplate.opsForValue().get("infzhan"+infId);

        return zhanCount;
    }
    @GetMapping("queryshou")
    public String queryshou(String heartId){

        String shouCount = (String) redisTemplate.opsForValue().get("infzhan"+heartId);

        return shouCount;
    }
}
