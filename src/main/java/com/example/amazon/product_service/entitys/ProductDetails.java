package com.example.amazon.product_service.entitys;

import com.example.amazon.product_service.enums.ProductBrand;
import com.example.amazon.product_service.enums.ProductTypes;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Entity
@Table(name = "product_details")
public class ProductDetails extends AuditTable{
    @Column(name = "product_name",nullable = false)
    private String productName;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ProductImages> productImages;

    @Column(name = "expiry_date")
    private String expiryDate;

    @Column(name = "manufacturing_date")
    private String manufacturingDate;

    @Column(name = "product_types")
    private ProductTypes productTypes;

    @Column(name="product_brand")
    private ProductBrand productBrand;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private long price;

    @Column(name = "discount")
    private long discount;

    @ManyToOne
    @JoinColumn(name = "Seller_id",referencedColumnName = "id")
    private SellersDetails sellerId;

}
