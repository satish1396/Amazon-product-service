package com.example.amazon.product_service.enums;

import com.example.amazon.product_service.exception.ValidationException;

public enum ProductTypes {
    ELECTRONICS,
    CLOTHS,
    FOOTWEAR,
    TOYS,
    BOOKS;

    public static ProductTypes fromValue(final String value){
        for (final ProductTypes status:values()){
            if(status.name().equalsIgnoreCase(value)){
                return status;
            }
        }
        throw new ValidationException("Invalid status");
    }

}
