package com.jk.controller;

import com.jk.dao.ImgMapper;
import com.jk.dao.TreeMapper;
import com.jk.pojo.Img;
import com.jk.pojo.MenuTree;
import com.jk.pojo.Tree;
import com.jk.service.HomePageServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;
import java.util.List;
@RestController
public class HomePageController2 implements HomePageServiceApi {
    @Autowired
    private ImgMapper imgMapper;
    @Autowired
    private TreeMapper treeMapper;
    @RequestMapping("/queryImg")
    public List<Img> queryImg() {
        List<Img> gg = imgMapper.queryImg();
        return gg;
    }

    @Override
    @RequestMapping("queryTree")
    public List<MenuTree> queryTree() {
        return treeMapper.queryTree();
    }


}
