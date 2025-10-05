package com.product.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class ProductUpdateDto {
    private String name;
    private String description;
    private BigDecimal price;
    private String brand;
    private Map<String,String> specifications;
}
