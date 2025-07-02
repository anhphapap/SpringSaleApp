/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pap.services.impl;

import com.pap.pojo.Product;
import com.pap.respositories.ProductRespository;
import com.pap.services.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRespository p;

    @Override
    @Transactional
    public List<Product> getProducts(Map<String, String> params) {
        return p.getProducts(params);
    }
    
}
