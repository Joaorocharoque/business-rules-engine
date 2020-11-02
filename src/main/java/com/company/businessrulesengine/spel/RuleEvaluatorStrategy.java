package com.company.businessrulesengine.spel;

import com.company.businessrulesengine.model.Product;
import com.company.businessrulesengine.model.Rule;

import javax.validation.Valid;

public interface RuleEvaluatorStrategy {

    void validate(Rule rule);

    RuleExecutionResponse evaluate(@Valid Rule rule, Product product);
}
