package com.example.amazon.product_service.repository;

import com.example.amazon.product_service.entitys.SellersDetails;
import com.example.amazon.product_service.service.impl.SellerServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerDetailsRepository extends JpaRepository<SellersDetails,Long> {
    SellersDetails findBySellerHashId(String sellerHashId);

    SellersDetails findByEmailId(String emailId);
}
