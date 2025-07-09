/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pap.controllers;

import com.pap.services.CategoryService;
import com.pap.services.ProductService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */
@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private CategoryService c;
    @Autowired
    private ProductService p;
    
    
    @ModelAttribute
    public void commonResponses(Model model) {
        model.addAttribute("cates", this.c.getCates());
    }
    
    @RequestMapping("/")
    @Transactional
    public String index(Model model,@RequestParam Map<String, String> params){
        model.addAttribute("prod", p.getProducts(params));
        return "index";
    }
}
