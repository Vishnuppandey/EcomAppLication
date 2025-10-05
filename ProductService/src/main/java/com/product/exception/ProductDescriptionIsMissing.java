package com.product.exception;

public class ProductDescriptionIsMissing extends RuntimeException{
    public ProductDescriptionIsMissing(String productDescriptionIsMissing) {
    super(productDescriptionIsMissing);
    }
}
