package com.example.amazon.product_service.enums;

import com.example.amazon.product_service.exception.ValidationException;

public enum ImageSide {
    FRONT,
    BACK,
    LEFT,
    RIGHT,
    REMAINING;

    public static ImageSide fromValue(String value){
        for(ImageSide imageSide : values()){
            if(imageSide.name().equals(value)){
                return imageSide;
            }
        }
        return REMAINING;
    }

}
