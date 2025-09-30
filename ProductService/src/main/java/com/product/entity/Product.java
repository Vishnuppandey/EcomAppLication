package com.product.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

@Entity(name="products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String UUID;

    private String name;
    private String description;
    private BigDecimal price;

    @Column(unique = true)
    private String sku;

    @ManyToOne
    @Column(name="category_id")
    private Category category;
    
    private String brand;
    private Blob image;
    private HashMap<String,String> specifications;
    private String status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
