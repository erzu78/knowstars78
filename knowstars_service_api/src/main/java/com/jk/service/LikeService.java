package com.jk.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface LikeService {
    @RequestMapping("opShou")
    void addInfuser(@RequestParam("infId") String infId, @RequestParam("userId") Integer userId);
    @RequestMapping("delInfuser")
    void delInfuser(@RequestParam("infId") String infId, @RequestParam("userId") Integer userId);
}
