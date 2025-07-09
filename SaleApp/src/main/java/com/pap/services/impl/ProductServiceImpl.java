/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pap.services.impl;

import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.pap.pojo.Product;
import com.pap.pojo.User;
import com.pap.respositories.ProductRespository;
import com.pap.services.ProductService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author admin
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRespository pr;

    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    @Transactional
    public List<Product> getProducts(Map<String, String> params) {
        return this.pr.getProducts(params);
    }

    @Override
    public void addOrUpdateProduct(Product p) {
        if (!p.getFile().isEmpty()) {
            try {
                Map res = cloudinary.uploader().upload(p.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                p.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.pr.addOrUpdateProduct(p);
    }
    
    @Override
    public Product getProductById(int id) {
        return this.pr.getProductById(id);
    }
    
     @Override
    public void deleteProduct(int id) {
        this.pr.deleteProduct(id);
    }
}
