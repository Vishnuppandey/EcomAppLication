package com.product.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String sku;
    private String categoryName;
    private String brand;
    private Map<String,String> specifications;
    private String status;
}
