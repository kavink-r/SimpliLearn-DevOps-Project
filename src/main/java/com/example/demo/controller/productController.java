package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.product;
import com.example.demo.service.productService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(allowedHeaders = "*")
public class productController {
@Autowired
productService service;
	@GetMapping("/")
	public String handshake() {
		return "Hello";
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<product>> getAllProducts(){
		return ResponseEntity.ok(service.getAllProduct());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<product> getById(@PathVariable(name="id")int id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping("/add")
	public ResponseEntity<product> addProduct(@RequestBody product p){
		return ResponseEntity.ok(service.addProduct(p));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct (@PathVariable(name="id")int id){
		product pr = service.findById(id);
		service.deleteProduct(pr);
		return ResponseEntity.ok("Deleted id="+pr.getId());
	}
}
