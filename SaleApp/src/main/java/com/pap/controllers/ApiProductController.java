package com.pap.controllers;

import com.pap.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiProductController {
    @Autowired
    private ProductService productService;

    @DeleteMapping("/products/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable(value="productId") int id) {
        this.productService.deleteProduct(id);
    }
}
