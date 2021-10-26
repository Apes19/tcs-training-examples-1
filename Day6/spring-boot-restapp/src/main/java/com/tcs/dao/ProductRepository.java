package com.tcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.beans.Product;
/*
 * You can call methods like save(object), findAll(), findById()
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
