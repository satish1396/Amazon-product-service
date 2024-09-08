package com.example.amazon.product_service.controller;

import com.example.amazon.product_service.request.AddProduct;
import com.example.amazon.product_service.response.ApiResponse;
import com.example.amazon.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    public ProductService productService;

    @Autowired
    ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping(value = "/add",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse addProduct(@ModelAttribute AddProduct addProduct){
        return ApiResponse.builder()
                .message(productService.addProduct(addProduct))
                .status(HttpStatus.OK)
                .code(HttpStatus.OK.name())
                .build();
    }

}
