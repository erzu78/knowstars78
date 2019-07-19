package com.jk.controller;

import com.jk.pojo.Ping;
import com.jk.pojo.User;
import com.jk.service.LikeServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class LikeController {
   @Autowired
    private LikeServiceFeign likeServiceFeign;


    @Autowired
    private RedisTemplate redisTemplate;



    /**
     * 操作点赞
     * @param infId
     * @return
     */
    @RequestMapping("zizi")
    public void incr(String infId) {

        Integer userId = 99;
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
     * 操作评论点赞
     * @param pingId
     * @return
     */
    @RequestMapping("pingLike")
    public void pingLike(String pingId) {

        Integer userId = 99;
        String piId = (String) redisTemplate.opsForValue().get("userpZhan"+userId+pingId);

        if(piId!=null){

            redisTemplate.boundValueOps("pingZhan"+pingId).increment(-1);

            redisTemplate.delete("userpZhan"+userId+pingId);

        } else{
            RedisAtomicLong entityIdCounter = new RedisAtomicLong("pingZhan"+pingId, redisTemplate.getConnectionFactory());
            entityIdCounter.getAndIncrement();
            redisTemplate.opsForValue().set("userpZhan"+userId+pingId,pingId);
        }

    }
    /**
     * 查询点赞
     * @param infId
     * @return
     */
    @GetMapping("queryZhan")
    public HashMap<String,String> queryZhan(String infId){

        Integer userId = 99;

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
    public void opShou(@RequestParam("infId") String infId) {

        Integer userId = 99;
        String inId = (String) redisTemplate.opsForValue().get("userShou"+userId+infId);

        if(inId!=null){

            redisTemplate.boundValueOps("infshou"+infId).increment(-1);

            redisTemplate.delete("userShou"+userId+infId);

            delInfuser(infId,userId);

        } else{
            RedisAtomicLong entityIdCounter = new RedisAtomicLong("infshou"+infId, redisTemplate.getConnectionFactory());
            entityIdCounter.getAndIncrement();
            redisTemplate.opsForValue().set("userShou"+userId+infId,infId);
            likeServiceFeign.addInfuser(infId,userId);
        }



    }
     @RequestMapping("delInfuser")
    public void delInfuser(@RequestParam("infId")String infId,@RequestParam("userId")Integer userId){
         likeServiceFeign.delInfuser(infId,userId);
    }


    /**
     * 查询收藏数量
     * @param infId
     * @return
     */
    @GetMapping("queryShou")
    public HashMap<String,String> queryShou(String infId){

        Integer userId = 99;

        String shouCount = (String) redisTemplate.opsForValue().get("infshou"+infId);
        String inId = (String) redisTemplate.opsForValue().get("userShou"+userId+infId);

        HashMap<String,String> map = new HashMap<>();
        map.put("shouCount",shouCount);
        map.put("inId",inId);

        return map;
    }




   /* *//**
     * 查询评论
     * @param infId
     * @return
     *//*
    @GetMapping("queryPing")
    public HashMap<String,String> queryPing(String infId){
        Integer userId = 99;
        String pingContent = (String) redisTemplate.opsForValue().get("ping"+userId+infId);
        HashMap<String,String> map = new HashMap<>();
        map.put("pingContent",pingContent);
        return map;
    }
    *//**
     * 操作点赞
     * @param infId
     * @return
     *//*
    @RequestMapping("addPing")
    public void addPing(String infId , String sp) {

        Integer userId = 99;
        String inId = (String) redisTemplate.opsForValue().get("ping"+userId+infId);

        if(inId!=null){

            redisTemplate.boundValueOps("ping"+userId+infId).getAndSet(sp);

            redisTemplate.delete("ping"+userId+infId);

        } else{
            RedisAtomicLong entityIdCounter = new RedisAtomicLong("ping"+userId+infId, redisTemplate.getConnectionFactory());
            entityIdCounter.getAndIncrement();
            redisTemplate.opsForValue().set("ping"+userId+infId,sp);
        }
    }
*/




    @GetMapping("queryComment")
    public List<HashMap<String, Object>> queryComment(String infId) {
        Integer userId = 99;
        List<Object> commentIds = redisTemplate.opsForList().range("ids"+infId,0,999999999);

        List<HashMap<String, Object>> commentList = new ArrayList<>();

        for (int i = 0; i < commentIds.size(); i++) {
            String str = (String) commentIds.get(i);
            HashMap<String,Object> map = (HashMap<String, Object>) redisTemplate.opsForHash().entries("comment"+infId+str);
            map.put("likeCount",redisTemplate.opsForValue().get("pingZhan"+map.get("pingId")));
            String piId = (String) redisTemplate.opsForValue().get("userpZhan"+userId+map.get("pingId"));
            map.put("piId",piId);
            commentList.add(map);
        }
        return commentList;
    }


    @GetMapping("addComment")
    public void addComment(String infId,String sp){
        Integer userId = 99;
        String userName = "赵大傻逼";
        String userImg = "http://gaokangle.oss-cn-beijing.aliyuncs.com/gaoakngle/1563163101336.png?Expires=1564344703&OSSAccessKeyId=LTAIVgOSeiYLY2E5&Signature=CxK6PYCRialzS1U%2Fh2jMqShKF7M%3D";

        HashMap<String,String> pingMap = new HashMap<>();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        pingMap.put("userId",userId.toString());
        pingMap.put("pingId",uuid);
        pingMap.put("pingInfo",sp);
        pingMap.put("userImg",userImg);
        pingMap.put("userName",userName);

        RedisAtomicLong entityIdCounter = new RedisAtomicLong("idsId", redisTemplate.getConnectionFactory());
        String idsId = String.valueOf(entityIdCounter.getAndIncrement());
        redisTemplate.opsForList().leftPush("ids"+infId,idsId);

        //HashMap<String, Ping> map = ping.getMap();

        redisTemplate.opsForHash().putAll("comment"+infId+idsId,pingMap);

    }



}
