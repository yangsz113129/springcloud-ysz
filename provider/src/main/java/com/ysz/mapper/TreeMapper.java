package com.ysz.mapper;

import com.ysz.model.Shop;
import com.ysz.model.Tree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TreeMapper {
    @Select("select * from t_tree3 where pid =#{id}")
    List<Tree> selectNodesById(Integer id);

    /*@Select("select *from t_shop")
    List<Shop> shopSelect();*/

    @Select("select count(*) from t_shop")
    Long selectCount();

    @Select("select *from t_shop limit #{page},#{rows}")
    List<Shop> selectList(Integer page, Integer rows);
}
