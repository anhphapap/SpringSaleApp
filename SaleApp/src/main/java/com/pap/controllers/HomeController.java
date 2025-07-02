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
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author admin
 */
@Controller
public class HomeController {
    @Autowired
    private CategoryService c;
    @Autowired
    private ProductService p;
    @RequestMapping("/")
    @Transactional
    public String index(Model model,Map<String, String> params){
        model.addAttribute("msg", "Wellcome");
        model.addAttribute("cates", c.getCates());
        model.addAttribute("prod", p.getProducts(params));
        return "index";
    }
}
