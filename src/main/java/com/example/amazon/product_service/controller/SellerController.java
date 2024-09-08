package com.example.amazon.product_service.controller;

import com.example.amazon.product_service.request.OnboardSellerDto;
import com.example.amazon.product_service.response.ApiResponse;
import com.example.amazon.product_service.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
 @RequestMapping("/api/v1/seller/")
public class SellerController {

    SellerService sellerService;

    @Autowired
    SellerController(SellerService sellerService){
        this.sellerService = sellerService;
    }
    @PostMapping("/onboard")
    public ApiResponse onboardSeller(@RequestBody OnboardSellerDto requestDto){
        log.info("Onboard seller process starts.....");
        return ApiResponse.builder().message(sellerService.onboardSeller(requestDto)).build();
    }
}
