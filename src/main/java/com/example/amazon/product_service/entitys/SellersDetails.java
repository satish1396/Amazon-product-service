package com.example.amazon.product_service.entitys;

import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "seller_details")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SellersDetails extends AuditTable{
    @Column(name = "seller_name",nullable = false)
    private String sellerName;
    @Column(name = "company_name")
    private String companyName;

    @Column(name = "seller_address")
    private String shopAddress;

    @Column(name = "seller_hash_id")
    private String sellerHashId;

    @Column(name = "email_id")
    private String emailId;

}
