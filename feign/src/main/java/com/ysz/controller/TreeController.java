package com.ysz.controller;

import com.ysz.model.Tree;
import com.ysz.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TreeController {

    @Autowired
    private TreeService treeService;

    @RequestMapping("/")
    @ResponseBody
    public ModelAndView mian(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("main");
        return mav;
    }

    @RequestMapping("/selectTree")
    @ResponseBody
    public List<Tree> selectTree(){
        return treeService.selectTree();
    }
}
