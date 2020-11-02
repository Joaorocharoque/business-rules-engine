package com.company.businessrulesengine.spel;

import com.company.businessrulesengine.model.Product;
import com.company.businessrulesengine.model.Rule;
import org.springframework.expression.spel.SpelParseException;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class SpelRuleEvaluatorStrategy implements RuleEvaluatorStrategy {

    @Override
    public void validate(Rule rule) {
        try {
            new SpelExpressionParser().parseExpression(getCompleteExpression(rule));

        } catch(SpelParseException exception) {
            throw new InvalidExpressionException(exception.getSimpleMessage());

        } catch(IllegalStateException exception) {
            throw new InvalidExpressionException(exception.getMessage());
        }
    }

    private String getCompleteExpression(Rule rule) {
        return rule.getRule() + " ? true : false";
    }

    @Override
    public RuleExecutionResponse evaluate(@Valid Rule rule, Product product) {
        SpelExpressionProcessor processor = SpelExpressionProcessor.builder(product)
                .expression(getCompleteExpression(rule))
                .build();

        Object evaluateResult = processor.evaluate(Object.class);
        return new RuleExecutionResponse(rule, evaluateResult);
    }

}
