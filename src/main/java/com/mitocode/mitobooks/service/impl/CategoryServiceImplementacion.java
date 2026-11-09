package com.mitocode.mitobooks.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mitocode.mitobooks.model.Category;
import com.mitocode.mitobooks.repository.CategoryRepo;
import com.mitocode.mitobooks.service.CategoryService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor

public class CategoryServiceImplementacion implements CategoryService {

	private final CategoryRepo repositorio;
		
	@Override
	public Category save(Category category) {
		return  repositorio.save(category) ;
	}

	@Override
	public Category update(Integer id, Category category) {
		category.setIdCategory(id);
		return repositorio.save(category);
	}

	@Override
	public List<Category> findAll() {
		return repositorio.findAll();
	}

	@Override
	public Category findByid(Integer id) {
		return repositorio.findById(id).orElse(new Category(999, "NO CATEGORY"));
	}

	@Override
	public void delete(Integer id) {
		repositorio.deleteById(id);
		
	}

}
