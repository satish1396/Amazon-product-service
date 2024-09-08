package com.example.amazon.product_service.request;

import com.example.amazon.product_service.enums.ProductBrand;
import com.example.amazon.product_service.enums.ProductTypes;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class AddProduct {
    @NotBlank(message = "Product name is mandatory")
    private String productName;

    private List<ProductImagesDetails> productImagesDetails;
    private String expiryDate;
    private String manufacturingDate;
    @NotBlank(message = "Product type is mandatory")
    private String productTypes;
    @NotBlank(message = "Product brand is mandatory")
    private ProductBrand productBrand;
    private String description;
    @NotBlank(message = "Product price is mandatory")
    private long price;
    private long discount;
    @NotBlank(message = "SellerHashId is mandatory")
    private String sellerHashId;
}
