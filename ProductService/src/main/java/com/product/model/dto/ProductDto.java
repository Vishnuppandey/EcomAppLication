package com.product.model.dto;

import com.product.entity.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
public class ProductDto {
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotBlank
    private String sku;

    @NotNull
    private Long categoryId;

    @NotBlank
    private String brand;

    private Map<String,String> specifications;

}
