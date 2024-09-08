package com.example.amazon.product_service.service.impl;

import com.example.amazon.product_service.entitys.SellersDetails;
import com.example.amazon.product_service.exception.ValidationException;
import com.example.amazon.product_service.repository.SellerDetailsRepository;
import com.example.amazon.product_service.request.OnboardSellerDto;
import com.example.amazon.product_service.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
public class SellerServiceImpl implements SellerService {

    public SellerDetailsRepository sellerDetailsRepository;

    @Autowired
    SellerServiceImpl(SellerDetailsRepository sellerDetailsRepository){
        this.sellerDetailsRepository = sellerDetailsRepository;
    }

    public String onboardSeller(OnboardSellerDto requestDto){
        log.info("Onboarding seller with name :{}", requestDto.getSellerName());
        SellersDetails sellersDetails = sellerDetailsRepository.findByEmailId(requestDto.getEmailId());
        if(Objects.nonNull(sellersDetails)){
            log.error("EmailId already exists");
            throw new ValidationException("EmailId already exists");
        }

        SellersDetails newSeller = SellersDetails.builder()
                .sellerName(requestDto.getSellerName())
                .sellerHashId(UUID.randomUUID().toString())
                .emailId(requestDto.getEmailId())
                .shopAddress(requestDto.getShopAddress())
                .companyName(requestDto.getCompanyName())
                .build();

        sellerDetailsRepository.save(newSeller);
        return "Seller onboarded successfully";
    }
}
