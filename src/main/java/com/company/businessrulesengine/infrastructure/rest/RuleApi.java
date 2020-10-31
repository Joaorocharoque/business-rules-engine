package com.company.businessrulesengine.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.businessrulesengine.model.Rule;
import com.company.businessrulesengine.model.RuleRepository;

@RestController
@RequestMapping("/rule")
public class RuleApi {
	
	@Autowired
	private RuleRepository ruleRepository;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Rule> create(@RequestBody RuleRequest request) {
		Rule rule = ruleRepository.save(new Rule(request.getRule()));
		return ResponseEntity.ok(rule);
	}

}
