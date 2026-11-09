package com.mitocode.mitobooks.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mitocode.mitobooks.model.Category;
import com.mitocode.mitobooks.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/categories")
@RequiredArgsConstructor

public class CategoryController {

	private final CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> getAllCategory(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Category>getCategory(@PathVariable Integer id){
		Category category = service.findByid(id);

		return ResponseEntity.ok(category);
	}
	
	
	@PostMapping
	public ResponseEntity<Category> saveCategory(@RequestBody Category category){
		Category newCategory = service.save(category);
		return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Category>updateCategory(@PathVariable Integer id, @RequestBody Category category){
		Category newCategory = service.update(id,category);
		return ResponseEntity.ok(newCategory);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Integer id){
		 service.delete(id);
	     return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	
}

