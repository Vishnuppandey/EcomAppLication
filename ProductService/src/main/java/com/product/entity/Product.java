package com.product.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Entity(name="products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;

    @Column(unique = true)
    private String sku;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    
    private String brand;
    private Blob image;
    private Map<String,String> specifications;
    private String status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
