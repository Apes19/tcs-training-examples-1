package com.tcs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.beans.CustomResponse;
import com.tcs.beans.Product;
import com.tcs.exceptions.ProductNotFoundException;
import com.tcs.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductRest {

	@Autowired
	private ProductService service;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
		ResponseEntity<Object> response = 
				ResponseEntity.status(HttpStatus.CREATED).body(service.store(product));
		return response;
	}
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(service.fetchProducts());
	}
	// product/1, product/2, product/3
	@GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findProduct(@PathVariable("id") int productId) {
		ResponseEntity<Object> response = null;
		try {
			Product product = service.fetchProductById(productId);
			response = ResponseEntity.status(HttpStatus.OK).body(product);
		} catch(ProductNotFoundException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		return response;
	}
	// product/1/15000
	@PutMapping(path = "{id}/{price}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateProductPrice(@PathVariable("id") int id, @PathVariable("price") double price) {
		ResponseEntity<Object> response = null;
		try {
			Product product = service.updateProductPrice(id, price);
			response = ResponseEntity.status(HttpStatus.OK).body(product);
		} catch(ProductNotFoundException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		return response;
	}
	@DeleteMapping(path = "{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") int id) {
		ResponseEntity<Object> response = null;
		try {
			service.deleteProductById(id);
			CustomResponse data = new CustomResponse();
			data.setMsg("Product with an id "+id+" deleted");
			response = ResponseEntity.status(HttpStatus.OK).body(data);
		} catch(ProductNotFoundException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		return response;
	}
}
