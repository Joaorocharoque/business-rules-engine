package com.company.businessrulesengine.infrastructure.rest;

import com.company.businessrulesengine.application.ProductService;
import com.company.businessrulesengine.application.SaveProductResponseDTO;
import com.company.businessrulesengine.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/product")
public class ProductApi {
	
	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<SaveProductResponseDTO> create(@RequestBody Product product) {
		SaveProductResponseDTO response = productService.save(product);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
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

	@PutMapping("/{id}")
	public ResponseEntity update(@RequestBody Product newProduct, @PathVariable Long id) {
		productService.update(newProduct, id);
		return ResponseEntity.noContent().build();
	}

}
