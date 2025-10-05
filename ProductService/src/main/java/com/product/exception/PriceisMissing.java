package com.product.exception;

public class PriceisMissing extends RuntimeException {
    public PriceisMissing(String priceIsMissing) {
        super(priceIsMissing);
    }
}
