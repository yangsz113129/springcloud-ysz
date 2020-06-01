package com.ysz.model;

import lombok.Data;

import java.util.List;

@Data
public class Tree {

    private Integer id;//	int(10)	主键id
    private String text;//	varchar(50)	菜单名称
    private String href;//	varchar(50)	  链接地址
    private Integer pid;// int(10)	  父级id
    private List<Tree> nodes;
    private Boolean selectable;

}
