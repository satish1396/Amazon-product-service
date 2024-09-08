package com.example.amazon.product_service.enums;

import com.example.amazon.product_service.exception.ValidationException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

public enum ProductBrand {
    BOAT,
    NIKE,
    PUMA,
    SAMSUNG,
    MOTOROLA,
    MI;

    public static ProductBrand fromValue(String value){
        for(ProductBrand productBrand : values()){
            if(productBrand.name().equals(value)){
                return productBrand;
            }
        }
        throw new ValidationException("No brand found");
    }
}
