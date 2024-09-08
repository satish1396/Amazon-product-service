package com.example.amazon.product_service.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductImagesDetails {
    public MultipartFile imageUrl;
    public String imageSide;
}
