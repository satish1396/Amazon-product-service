package com.example.amazon.product_service.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
public class OnboardSellerDto {
    @NotBlank(message = "Seller Name is mandatory")
    private String sellerName;
    @NotBlank(message = "Company name is mandatory")
    private String companyName;
    private String shopAddress;
    @NotBlank(message = "Company name is mandatory")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email id")
    private String emailId;

    @NotBlank(message = "mobile no is mandatory.")
    @Pattern(regexp = "[0-9]{1,}",message = "Alphabets and special characters are not allowed in mobile number")
    private String mobile;
}
