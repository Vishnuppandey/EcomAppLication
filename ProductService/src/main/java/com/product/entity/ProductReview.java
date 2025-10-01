package com.product.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name="product_review")
@Data
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="product_id")  // ADD THIS - missing product relationship
    private Product product;
    private String user_id;
    private Integer rating;
    private String comment;
    private Boolean isVerified_purchase;
    private LocalDateTime created_at;
}
