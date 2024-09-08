package com.example.amazon.product_service.repository;

import com.example.amazon.product_service.entitys.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails,Long> {

}
