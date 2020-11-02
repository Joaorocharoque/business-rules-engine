package com.company.businessrulesengine.infrastructure.rest;

import com.company.businessrulesengine.application.RuleService;
import com.company.businessrulesengine.model.Rule;
import com.company.businessrulesengine.model.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rule")
public class RuleApi {
	
	@Autowired
	private RuleService ruleService;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Rule> create(@RequestBody Rule rule) {
		Rule savedRule = ruleService.save(rule);
		return ResponseEntity.ok(savedRule);
	}

}
