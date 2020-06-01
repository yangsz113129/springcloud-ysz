package com.ysz.controller;

import com.ysz.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class ShopController {

    @Autowired
    private TreeService treeService;

    @RequestMapping("/shopSelect")
    @ResponseBody
    public HashMap<String,Object> shopSelect(Integer page,Integer rows){
        return treeService.shopSelect(page,rows);
    }

    /*@RequestMapping("/shopSelect")
    @ResponseBody
    public List<Shop> shopSelect(){
        return treeService.shopSelect();
    }*/
}
