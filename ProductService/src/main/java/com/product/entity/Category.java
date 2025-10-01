package com.product.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name="categories")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @Column(name="parent_category_id")
    private Category parentCategory;


    @OneToMany(mappedBy="category")
    public List<Product> products;
    private String image_url;
    private boolean is_active;

    private LocalDateTime created_at;
}
