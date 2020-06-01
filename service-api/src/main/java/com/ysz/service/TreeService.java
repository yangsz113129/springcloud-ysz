package com.ysz.service;


import com.ysz.model.Shop;
import com.ysz.model.Tree;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@FeignClient("provider")
public interface TreeService {
    @RequestMapping("/selectTree")
    List<Tree> selectTree();

    /*@RequestMapping("/shopSelect")
    List<Shop> shopSelect();*/

    @RequestMapping("/shopSelect")
    HashMap<String, Object> shopSelect(Integer page, Integer rows);
}

