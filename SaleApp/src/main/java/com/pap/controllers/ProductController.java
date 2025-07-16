/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pap.controllers;

import com.pap.pojo.Product;
import com.pap.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author admin
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService ps;

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("product", new Product());
        return "products";
    }
    
    @PostMapping("/products")
    public String addProduct(@ModelAttribute (value = "product") Product p){
        this.ps.addOrUpdateProduct(p);
        return "redirect:/";
    }
    
    @GetMapping("/products/{productId}")
    public String updateProduct(Model model, @PathVariable (value = "productId") int id){
        model.addAttribute("product", this.ps.getProductById(id));
        return "products";
    }
}
