package com.example.amazon.product_service.service;

import com.example.amazon.product_service.request.AddProduct;

public interface ProductService {
    String addProduct(AddProduct requestDto);
}
