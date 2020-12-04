package com.company.businessrulesengine.infrastructure.rest;

import com.company.businessrulesengine.application.RuleService;
import com.company.businessrulesengine.model.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rule")
public class RuleApi {
	
	@Autowired
	private RuleService ruleService;
	
	@PostMapping
	public ResponseEntity<Rule> create(@RequestBody Rule rule) {
		Rule savedRule = ruleService.save(rule);
		return ResponseEntity.ok(savedRule);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		ruleService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity findById(@PathVariable Long id) {
		return ResponseEntity.ok(ruleService.findById(id));
	}

	@GetMapping
	public ResponseEntity<Collection<Rule>> findById() {
		return ResponseEntity.ok(ruleService.findAll());
	}

	@PutMapping("/{id}")
	public ResponseEntity update(@RequestBody Rule newRule, @PathVariable Long id) {
		ruleService.update(newRule, id);
		return ResponseEntity.noContent().build();
	}

}
