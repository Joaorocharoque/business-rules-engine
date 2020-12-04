package com.company.businessrulesengine.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductNotFoundException extends RuntimeException {

    private static final Logger log = LoggerFactory.getLogger(ProductNotFoundException.class);

    public ProductNotFoundException(Long id) {
        log.info("Product with id {} not found", id);
    }
}
