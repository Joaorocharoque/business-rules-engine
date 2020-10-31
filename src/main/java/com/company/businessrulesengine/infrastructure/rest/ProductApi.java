package com.company.businessrulesengine.infrastructure.rest;

import com.company.businessrulesengine.model.Product;
import com.company.businessrulesengine.model.ProductRepository;
import com.company.businessrulesengine.model.Rule;
import com.company.businessrulesengine.model.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductApi {
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Product> create(@RequestBody Product product) {
		Product savedProduct = productRepository.save(product);
		return ResponseEntity.ok(savedProduct);
	}

}
