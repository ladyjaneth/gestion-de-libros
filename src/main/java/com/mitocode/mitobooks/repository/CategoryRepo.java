package com.mitocode.mitobooks.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.mitobooks.model.Category;



public interface CategoryRepo extends JpaRepository<Category, Integer>{
	
}
