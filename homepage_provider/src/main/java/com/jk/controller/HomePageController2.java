package com.jk.controller;

import com.jk.dao.ImgMapper;
import com.jk.dao.InfotypeMapper;
import com.jk.dao.TreeMapper;
import com.jk.pojo.Img;
import com.jk.pojo.Infotype;
import com.jk.pojo.MenuTree;
import com.jk.service.HomePageServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class HomePageController2 implements HomePageServiceApi {
    @Autowired
    private ImgMapper imgMapper;
    @Autowired
    private InfotypeMapper infotypeMapper;
    @Autowired
    private TreeMapper treeMapper;

    @RequestMapping("queryImg")
    public List<Img> queryImg() {
        List<Img> gg = imgMapper.queryImg();
        return gg;
    }


    @Override
    @RequestMapping("queryTree")
    public List<MenuTree> queryTree() {
        return treeMapper.queryTree();
    }

    @Override
    @RequestMapping("/queryZiXun")
    public List<Infotype> queryZiXun() {
        System.out.println(999);
        System.out.println(infotypeMapper.queryZiXun());
        return infotypeMapper.queryZiXun();
    }


}
