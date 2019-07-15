package com.jk.service;

import com.jk.pojo.Img;
import com.jk.pojo.MenuTree;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface HomePageServiceApi {
    @RequestMapping("/queryImg")
     public   List<Img> queryImg();
    @RequestMapping("/queryTree")
    public List<MenuTree> queryTree();
}
