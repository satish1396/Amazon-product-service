package com.example.amazon.product_service.service;

import com.example.amazon.product_service.request.OnboardSellerDto;
import com.example.amazon.product_service.response.ApiResponse;

public interface SellerService {
    String onboardSeller(OnboardSellerDto requestDto);
}
