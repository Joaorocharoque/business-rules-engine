package com.company.businessrulesengine.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rule {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String rule;

	private String errorDescription;

	public Rule() {
	}

	public Rule(Long id, String rule, String errorDescription) {
		this.id = id;
		this.rule = rule;
		this.errorDescription = errorDescription;
	}

	public Long getId() {
		return id;
	}

	public String getRule() {
		return rule;
	}

	public String getErrorDescription() {
		return errorDescription;
	}
}
