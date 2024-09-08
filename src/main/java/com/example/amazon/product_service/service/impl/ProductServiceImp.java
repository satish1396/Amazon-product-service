package com.example.amazon.product_service.service.impl;

import com.example.amazon.product_service.entitys.ProductDetails;
import com.example.amazon.product_service.entitys.ProductImages;
import com.example.amazon.product_service.entitys.SellersDetails;
import com.example.amazon.product_service.enums.ImageSide;
import com.example.amazon.product_service.enums.ProductBrand;
import com.example.amazon.product_service.enums.ProductTypes;
import com.example.amazon.product_service.exception.ValidationException;
import com.example.amazon.product_service.repository.ProductDetailsRepository;
import com.example.amazon.product_service.repository.SellerDetailsRepository;
import com.example.amazon.product_service.request.AddProduct;
import com.example.amazon.product_service.request.ProductImagesDetails;
import com.example.amazon.product_service.response.ApiResponse;
import com.example.amazon.product_service.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class ProductServiceImp implements ProductService {

    public SellerDetailsRepository sellerDetailsRepository;

    public ProductDetailsRepository productDetailsRepository;

    @Autowired
    ProductServiceImp(final SellerDetailsRepository sellerDetailsRepository, final ProductDetailsRepository productDetailsRepository){
        this.sellerDetailsRepository = sellerDetailsRepository;
        this.productDetailsRepository = productDetailsRepository;

    }

    public String addProduct(AddProduct requestDto){
        log.info("Adding product with name :{} and seller hash Id :{}",requestDto.getProductName(),requestDto.getSellerHashId());
        SellersDetails sellersDetails = sellerDetailsRepository.findBySellerHashId(requestDto.getSellerHashId());
        if(Objects.isNull(sellersDetails)){
            log.error("Invalid seller hash id");
            throw new ValidationException("Invalid seller hash id");
        }
        initiateProductDetails(requestDto,sellersDetails);
        return "Prodcut added successfully!";
    }
    public void initiateProductDetails(AddProduct requsetDto,SellersDetails sellersDetails){
        log.info("Initiating product details");
        ProductDetails productDetails = ProductDetails.builder()
                .productName(requsetDto.getProductName())
                .expiryDate(requsetDto.getExpiryDate())
                .description(requsetDto.getDescription())
                .productTypes(ProductTypes.fromValue(requsetDto.getProductTypes()))
                .manufacturingDate(requsetDto.getManufacturingDate())
                .price(requsetDto.getPrice())
                .discount(requsetDto.getDiscount())
                .sellerId(sellersDetails)
                .productBrand(requsetDto.getProductBrand())
                .productImages(setProductImages(requsetDto.getProductImagesDetails()))
                .build();
        productDetailsRepository.save(productDetails);
    }
    public List<ProductImages> setProductImages(List<ProductImagesDetails> requestDto){
        List<ProductImages> productDetailsList = new ArrayList<>();
        for(ProductImagesDetails productImagesDetails:requestDto){
            ProductImages productImages = new ProductImages();
            productImages.setImageSide(ImageSide.fromValue(productImagesDetails.getImageSide()));
            productImages.setImageUrl(productImagesDetails.getImageUrl().getOriginalFilename());

            productDetailsList.add(productImages);
        }
        return productDetailsList;
    }
}
