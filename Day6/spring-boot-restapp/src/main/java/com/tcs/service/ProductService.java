package com.tcs.service;

import java.util.List;

import com.tcs.beans.Product;
import com.tcs.exceptions.ProductNotFoundException;

public interface ProductService {
	public Product store(Product product);
	public Product fetchProductById(int productId) throws ProductNotFoundException;
	public void deleteProductById(int productId) throws ProductNotFoundException;
	public Product updateProductPrice(int productId, double price)  throws ProductNotFoundException;
	public List<Product> fetchProducts();
}
