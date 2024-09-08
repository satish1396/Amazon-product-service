package com.example.amazon.product_service.entitys;

import com.example.amazon.product_service.enums.ImageSide;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ProductImages extends AuditTable{

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductDetails productId;

    @Column(name = "image_side")
    private ImageSide imageSide;

    @Column(name = "image_url")
    private String imageUrl;


}
