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
	public ResponseEntity<Collection<RuleExecutionResponse>> create(@RequestBody Product product) {
		Collection<RuleExecutionResponse> errors = productService.save(product);

		return ResponseEntity.ok(errors);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Product> delete(@PathVariable Long id) {
		productService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		return ResponseEntity.ok(productService.findById(id));
	}

	@GetMapping
	public ResponseEntity<Collection<Product>> findById() {
		return ResponseEntity.ok(productService.findAll());
	}

}
