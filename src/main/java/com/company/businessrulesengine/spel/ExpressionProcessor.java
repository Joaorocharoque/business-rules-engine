package com.company.businessrulesengine.spel;

public interface ExpressionProcessor {

    <T extends Object> T evaluate(Class<T> type);

}
