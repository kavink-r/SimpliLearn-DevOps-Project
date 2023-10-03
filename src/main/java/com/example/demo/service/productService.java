package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.product;
import com.example.demo.repo.productRepo;

@Service
public class productService {
	@Autowired
	productRepo repo;

	public product addProduct(product p) {
		return repo.save(p);
	}

	public List<product> getAllProduct() {
		return repo.findAll();
	}

	public product findById(int id) {
		return repo.findById(id).get();
	}

	public void deleteProduct(product p) {
		repo.delete(p);
	}
}
