package com.mitocode.mitobooks.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.mitobooks.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {
	
	//Book getBookById(int id);
}
