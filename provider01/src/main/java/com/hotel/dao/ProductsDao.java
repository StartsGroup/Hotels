package com.hotel.dao;

import com.hotel.pojo.Products;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductsDao {
    //查询所有
    @Select("select * from products,protype where products.ptid=protype.ptid")
    List<Products> getAllProducts();
    //查询所有类别
    @Select("select * from protype ")
    List<Products> getAll3Products();
    //查询所有2
    @Select("select * from products,protype where products.ptid=protype.ptid")
    List<Products> getAll2Products();
    //添加
    @Insert("insert into products values(null,#{ptid},#{pname},#{price},#{num},status='可点')")
    int saveProducts(Products pro);
    //按类别查询
    @Select("select * from products,protype where products.ptid=protype.ptid and products.ptid=#{products.ptid}")
    List<Products> getProductsByPtid(int ptid);
    //按ID查询
    @Select("select * from products,protype where products.ptid=protype.ptid and pid=#{pid}")
    Products getProductsByPid(int pid);
    //修改信息
    @Update("update products set ptid=#{ptid},pname=#{pname},price=#{price},num=#{num},status=#{status} where pid=#{pid}")
    int updateProducts(Products pro);
    //下架商品
    @Delete("delete from products where pid=#{pid}")
    int deleteProductsByPid(int pid);
}
