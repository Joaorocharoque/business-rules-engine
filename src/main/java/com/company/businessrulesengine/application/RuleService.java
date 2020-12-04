package com.company.businessrulesengine.application;

import com.company.businessrulesengine.model.RuleNotFoundException;
import com.company.businessrulesengine.model.Product;
import com.company.businessrulesengine.model.Rule;
import com.company.businessrulesengine.model.RuleRepository;
import com.company.businessrulesengine.spel.RuleExecutionResponse;
import com.company.businessrulesengine.spel.RuleEvaluatorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RuleService {

    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private RuleEvaluatorStrategy ruleEvaluatorStrategy;

    public List<RuleExecutionResponse> applyRules(Product product){
        Collection<Rule> rules = ruleRepository.findAll();

        List<RuleExecutionResponse> rejectedRules = rules.stream()
                .map(rule -> ruleEvaluatorStrategy.evaluate(rule, product))
                .filter(rule -> Objects.equals(rule.getResult(), Boolean.FALSE))
                .collect(Collectors.toList());

        return rejectedRules;
    }

    public Rule save(Rule rule){
        ruleEvaluatorStrategy.validate(rule);
        return ruleRepository.save(rule);
    }

    public void delete(Long id){
        ruleRepository.deleteById(id);
    }

    public Rule findById(Long id) {
        return ruleRepository.findById(id)
                .orElseThrow(() -> new RuleNotFoundException(id));
    }

    public Collection<Rule> findAll() {
        return ruleRepository.findAll();
    }
}
