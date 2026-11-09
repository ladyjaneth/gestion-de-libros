package com.mitocode.mitobooks.service;

import java.util.List;

import com.mitocode.mitobooks.model.Category;

public interface CategoryService {

	Category save(Category category);
	Category update(Integer id, Category category);
	List<Category>findAll();
	Category findByid(Integer id);
	void delete(Integer id);
	
	
}
