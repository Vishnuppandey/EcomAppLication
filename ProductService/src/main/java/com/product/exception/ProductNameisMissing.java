package com.product.exception;

public class ProductNameisMissing extends RuntimeException {
    public ProductNameisMissing(String productIdIsMissing) {
        super(productIdIsMissing);
    }
}
