package com.company.businessrulesengine.application;

public class SaveRuleResponseDTO {

    private Long id;

    public SaveRuleResponseDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
