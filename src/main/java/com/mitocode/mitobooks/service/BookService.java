package com.mitocode.mitobooks.service;

import java.util.List;

import com.mitocode.mitobooks.model.Book;

public interface BookService {
	
	Book save(Book book);
	Book update(Integer id, Book book);
	List<Book>findAll();
	Book findById(Integer id);
	void delete(Integer id);
	
	
	
	//Book validandReturn(int id);
}
