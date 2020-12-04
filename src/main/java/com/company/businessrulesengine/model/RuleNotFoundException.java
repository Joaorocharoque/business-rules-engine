package com.company.businessrulesengine.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuleNotFoundException extends RuntimeException {

    private static final Logger log = LoggerFactory.getLogger(RuleNotFoundException.class);

    public RuleNotFoundException(Long id) {
        log.info("Rule with id {} not found", id);
    }
}
