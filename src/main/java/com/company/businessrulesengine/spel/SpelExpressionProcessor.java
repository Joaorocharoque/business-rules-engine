package com.company.businessrulesengine.spel;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParseException;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpelExpressionProcessor implements ExpressionProcessor {

    protected static final String TEXT_UTILS = "text";
    protected static final String DATE_VAR = "date";

    private String expression;
    private ExpressionParser parser;
    private StandardEvaluationContext context;

    private SpelExpressionProcessor(Object rootObject) {
        parser = new SpelExpressionParser();
        context = new StandardEvaluationContext(rootObject);

        context.addPropertyAccessor(new MapAccessor());

        context.setVariable(TEXT_UTILS, new TextUtils());
        context.setVariable(DATE_VAR, new DateUtils());
    }

    @Override
    public <T extends Object> T evaluate(Class<T> type) {
        if (StringUtils.isBlank(expression)) {
            return null;
        }

        try {
            Expression exp = parser.parseExpression(expression);
            return exp.getValue(context, type);

        } catch(SpelParseException exception) {
            throw new InvalidExpressionException(exception.getSimpleMessage());
        }
    }

    public static DefaultExpressionProcessorBuilder builder(Object rootObject) {
        return new DefaultExpressionProcessorBuilder(rootObject);
    }

    public static class DefaultExpressionProcessorBuilder {

        private SpelExpressionProcessor processor;

        public DefaultExpressionProcessorBuilder(Object rootObject) {
            processor = new SpelExpressionProcessor(rootObject);
        }

        public DefaultExpressionProcessorBuilder expression(String expression) {
            processor.expression = expression;
            return this;
        }

        public SpelExpressionProcessor build() {
            return processor;
        }
    }
}