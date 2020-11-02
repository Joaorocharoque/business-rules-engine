package com.company.businessrulesengine.application;

import com.company.businessrulesengine.model.Product;
import com.company.businessrulesengine.model.ProductRepository;
import com.company.businessrulesengine.spel.RuleExecutionResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private RuleService ruleService;

    @Autowired
    private ProductRepository productRepository;

    public Collection<RuleExecutionResponse> save(Product product){
        Collection<RuleExecutionResponse> errors = ruleService.applyRules(product);
        if(CollectionUtils.isEmpty(errors)){
            productRepository.save(product);
        }
        return errors;
    }
}
