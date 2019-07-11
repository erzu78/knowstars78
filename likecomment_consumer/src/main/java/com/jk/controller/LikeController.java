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
/**
     * @Description: 初始化自增长值
     * @param key key
     * @param liveTime 当前值
    */
    @RequestMapping("zeng")
    public void setIncr(String infId, long liveTime) {
              RedisAtomicLong counter = new RedisAtomicLong("infzhan"+infId, redisTemplate.getConnectionFactory());
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

    @PostMapping("like/{ziid}")
    public void addUp(@PathVariable("ziid") String ziid){
        String userId = "123";
        RedisConnection redis = redisTemplate.getConnectionFactory().getConnection();
        //根据key值获取value
        byte[] bytes = redis.get(ziid.getBytes());
        String s = new String(bytes);
        //判断当前评论是否有点赞内容
        if("".equals(s)){
            Map<String, String> upMap = new HashMap<String, String>();
            upMap.put(userId,"1");
            //把点赞map集合转成json字符串存入redis
            String json = JSON.toJSONString(upMap);
            redis.set(ziid.getBytes(),json.getBytes());
        }else{
            Map<String,String> map = JSON.parseObject(s, Map.class);
            //在map集合中判断当前用户是否已经点赞
            String userVal = map.get(userId);
            if(userVal != null){
                map.remove(userId);
            }else{
                map.put(userId,"1");
            }
            String json = JSON.toJSONString(map);
            redis.set(ziid.getBytes(),json.getBytes());
        }
    }

    public Integer getUpCount(Integer ziid){
        RedisConnection redis = redisTemplate.getConnectionFactory().getConnection();
        byte[] bytes = redis.get(ziid.toString().getBytes());
        String s = new String(bytes);
        //判断当前评论有没有点过赞
        if("".equals(s)){
            return 0;
        }else{
            //如果当前redis获取的值不为空 则证明当前评论被点过赞
            Map<String,String> map = JSON.parseObject(s, Map.class);
            return map.size();
        }
    }


    @GetMapping("queryZhan")
    public String queryZhan(String infId){

        String zhanCount = (String) redisTemplate.opsForValue().get("infzhan"+infId);

        return zhanCount;
    }



}
