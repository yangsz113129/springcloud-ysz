package com.ysz.service;

import com.ysz.mapper.TreeMapper;
import com.ysz.model.Shop;
import com.ysz.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class TreeServiceImpl implements TreeService{

    @Autowired
    private TreeMapper treeMapper;

    private List<Tree> selectNodes(Integer id) {
        List<Tree> treeList=treeMapper.selectNodesById(id);
        for (Tree tree : treeList) {
            List<Tree> nodeList = selectNodes(tree.getId());
            if(nodeList!=null && !nodeList.isEmpty()){
                tree.setNodes(nodeList);
                tree.setSelectable(false);
            }else{
                tree.setSelectable(true);
            }
        }
        return treeList;
    }

    @RequestMapping("/selectTree")
    @Override
    public List<Tree> selectTree() {
        return selectNodes(-1);
    }


    @Override
    public HashMap<String, Object> shopSelect(@RequestParam Integer page, @RequestParam Integer rows) {
        Long total = treeMapper.selectCount();

        //查询列表
        List<Shop> newsList = treeMapper.selectList((page-1)*rows,rows);

        //将数据放入map集合
        HashMap<String, Object> Map = new HashMap();
        Map.put("total", total);
        Map.put("rows", newsList);
        return Map;
    }

    /*@Override
    public List<Shop> shopSelect() {
        return treeMapper.shopSelect();
    }*/
}
