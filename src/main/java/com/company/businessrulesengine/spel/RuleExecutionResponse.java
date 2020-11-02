package com.company.businessrulesengine.spel;

import com.company.businessrulesengine.model.Rule;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class RuleExecutionResponse {

    private Rule rule;

    @JsonIgnore
    private Object result;

    public RuleExecutionResponse(Rule rule, Object result) {
        this.rule = rule;
        this.result = result;
    }

    public Rule getRule() {
        return rule;
    }

    public Object getResult() {
        return result;
    }
}
