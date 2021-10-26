package com.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.beans.Product;
import com.tcs.dao.ProductRepository;
import com.tcs.exceptions.ProductNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository dao;
	
	@Override
	@Transactional
	public Product store(Product product) {
		// save method return type changes according to the Entity name you have mapped
		return dao.save(product);
	}

	@Override
	public Product fetchProductById(int productId) throws ProductNotFoundException {
		Product p = dao.findById(productId).orElse(null);
		if(p == null) {
			throw new ProductNotFoundException("Product with an id "+productId+" not found");
		}
		return p;
	}

	@Override
	@Transactional
	public void deleteProductById(int productId) throws ProductNotFoundException {
		Product p = fetchProductById(productId);
		dao.delete(p);
	}

	@Override
	@Transactional
	public Product updateProductPrice(int productId, double price) throws ProductNotFoundException {
		Product p = fetchProductById(productId);
		p.setPrice(price);
		return p;
	}

	@Override
	public List<Product> fetchProducts() {
		return dao.findAll();
	}

}
