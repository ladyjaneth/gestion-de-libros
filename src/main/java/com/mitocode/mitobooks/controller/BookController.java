package com.mitocode.mitobooks.controller;

import com.mitocode.mitobooks.model.Book;
import com.mitocode.mitobooks.service.BookService;
import lombok.RequiredArgsConstructor;

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


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/books")
public class BookController {

	private final BookService service;
     
	
	@GetMapping
	public ResponseEntity<List<Book>>getAllBooks(){
     List<Book>	list = service.findAll();
     return ResponseEntity.ok(list);    
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable Integer id){
     Book book = service.findById(id);
     return ResponseEntity.ok(book);    
	}
	
	@PostMapping
	public ResponseEntity<Book> saveBook(@RequestBody Book book){
		Book newBook = service.save(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(newBook);		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody Book book){
		Book newBook = service.update(id, book);
		return ResponseEntity.ok(newBook);
		
	}
	 
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Integer id){
     service.delete(id);
     return ResponseEntity.noContent().build();
	}
		
	
	
}




//private String text;

	//@GetMapping
	//public Book getBook() {
		//return service.validandReturn(0);
	//}
