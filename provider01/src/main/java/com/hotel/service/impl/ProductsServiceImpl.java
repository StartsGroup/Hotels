package com.hotel.service.impl;

import com.hotel.dao.ProductsDao;
import com.hotel.pojo.Products;
import com.hotel.service.ProductsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ProductsServiceImpl implements ProductsService {
    @Resource
    private ProductsDao productsDao;
    @Override
    public List<Products> getAllProducts() {
        return productsDao.getAllProducts();
    }

    @Override
    public boolean saveProducts(@RequestBody Products pro) {
        return productsDao.saveProducts(pro)>0;
    }

    @Override
    public List<Products> getProductsByPtid(int ptid) {
        return productsDao.getProductsByPtid(ptid);
    }

    @Override
    public Products getProductsByPid(int pid) {
        return productsDao.getProductsByPid(pid);
    }

    @Override
    public List<Products> getAll2Products() {
        return productsDao.getAll2Products();
    }

    @Override
    public boolean updateProducts(Products pro) {
        return productsDao.updateProducts(pro)>0;
    }

    @Override
    public boolean deleteProductsByPid(int pid) {
        return productsDao.deleteProductsByPid(pid)>0;
    }

    @Override
    public List<Products> getAllTypes() {
        return productsDao.getAllTypes();
    }
}
