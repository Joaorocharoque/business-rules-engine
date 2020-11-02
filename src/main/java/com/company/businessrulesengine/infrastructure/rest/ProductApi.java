package com.company.businessrulesengine.infrastructure.rest;

import com.company.businessrulesengine.application.ProductService;
import com.company.businessrulesengine.model.Product;
import com.company.businessrulesengine.spel.RuleExecutionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/product")
public class ProductApi {
	
	@Autowired
	private ProductService productService;

	@PostMapping
	@ResponseBody
	public ResponseEntity<Collection<RuleExecutionResponse>> create(@RequestBody Product product) {
		Collection<RuleExecutionResponse> errors = productService.save(product);

		return ResponseEntity.ok(errors);
	}

}
