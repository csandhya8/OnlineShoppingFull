package com.tech.cadt.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tech.cadt.product.entity.Product;


@Transactional
public interface ProductRepository extends MongoRepository<Product, String> {
	
	public Product findById(Integer itemName);
	//public Product findAll();

}

