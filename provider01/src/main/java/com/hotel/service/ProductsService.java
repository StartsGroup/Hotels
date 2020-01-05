package com.hotel.service;

import com.hotel.pojo.Products;

import java.util.List;

public interface ProductsService {

    List<Products> getAllProducts();

    boolean saveProducts(Products pro);

    List<Products> getProductsByPtid(int ptid);

    Products getProductsByPid(int pid);

    List<Products> getAll2Products();

    boolean updateProducts(Products pro);

    boolean deleteProductsByPid(int pid);

    List<Products> getAllTypes();

    List<Products> getAll3Products();

    boolean updateNum(Products pro);

    boolean saveProductsType(Products pro);

    boolean updateProductsType(Products pro);
}
