package com.hotel.controller;

import com.hotel.pojo.Products;
import com.hotel.service.ProductsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/pro")
@RestController
public class ProductsController {
    @Resource
    private ProductsService productsService;

    @GetMapping("/all")
    public List<Products> getAllProducts(){
        return productsService.getAllProducts();
    }
    @PostMapping("/save")
    public String saveProducts(@RequestBody Products pro){
        boolean flag=productsService.saveProducts(pro);
        String result=(flag ? "success":"fail");
        return result;
    }
    @GetMapping("/all/{ptid}")
    public List<Products> getProductsByPtid(@PathVariable int ptid){
        return productsService.getProductsByPtid(ptid);
    }
    @GetMapping("/all2")
    public List<Products> getAll2Products(){
        return productsService.getAll2Products();
    }
    @GetMapping("/all2/{pid}")
    public Products getProductsByPid(@PathVariable int pid) {
        return productsService.getProductsByPid(pid);
    }
    @PostMapping("/update")
    public String updateProducts(@RequestBody Products pro) {
        boolean flag=productsService.updateProducts(pro);
        String result=(flag ? "success":"fail");
        return result;
    }
    @GetMapping("/delete/{pid}")
    public String deleteProductsByPid(@PathVariable int pid) {
        boolean flag=productsService.deleteProductsByPid(pid);
        String result=(flag ? "success":"fail");
        return result;
    }
    @GetMapping("/alltypes")
    public List<Products> getAllTypes(){
        return productsService.getAllTypes();
    }
}
