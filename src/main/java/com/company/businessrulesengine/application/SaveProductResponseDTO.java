package com.company.businessrulesengine.application;

import com.company.businessrulesengine.spel.RuleExecutionResponse;

import java.util.Collection;

public class SaveProductResponseDTO {

    private Long id;
    private Collection<RuleExecutionResponse> errors;

    public SaveProductResponseDTO(Long id) {
        this.id = id;
    }

    public SaveProductResponseDTO(Collection<RuleExecutionResponse> errors) {
        this.errors = errors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<RuleExecutionResponse> getErrors() {
        return errors;
    }

    public void setErrors(Collection<RuleExecutionResponse> errors) {
        this.errors = errors;
    }
}
