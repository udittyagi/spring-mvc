package com.udit.controllers;

import com.udit.domain.Product;
import com.udit.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by udit on 19/9/17.
 */
@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/product/list")
    public String listProducts(Model model){

        model.addAttribute("products", productService.listAllProducts());

        return "products";
    }

    @RequestMapping("/product/{id}")
    public String getProduct(@PathVariable Integer id , Model model){
        model.addAttribute("product" , productService.getProductById(id));
        return "product";
    }

    @RequestMapping("/product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("product" , productService.getProductById(id));
        return "productform";
    }

    @RequestMapping("/product/new")
    public String newProduct(Model model){
         model.addAttribute("product", new Product());
         return "productform";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdate(Product product){
        Product savedProduct = productService.saveOrUpdate(product);
        return "redirect:/product/"+savedProduct.getId();
    }

    @RequestMapping("product/delete/{id}")
    public String remove(@PathVariable Integer id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
