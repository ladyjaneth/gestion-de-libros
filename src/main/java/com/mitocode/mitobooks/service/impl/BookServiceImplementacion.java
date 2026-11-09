package com.mitocode.mitobooks.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mitocode.mitobooks.model.Book;
import com.mitocode.mitobooks.model.Category;
import com.mitocode.mitobooks.repository.BookRepo;
import com.mitocode.mitobooks.service.BookService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImplementacion implements BookService {

	private final BookRepo repositorio;   //instancia por inyección de dependencias 

	@Override
	public Book save(Book book) {
		return repositorio.save(book);
	}

	@Override
	public Book update(Integer id, Book book) {   
		//aqui no tenemos un update como tal si no que vamos a utilizar el save(booK)
		//solo que se va a comportar un poco diferente
		//cuando la llave primaria de un objeto NO exista se interpretara como una INSERCIÓN
		//cuando la llave primera de un objeto YA exista se interpretara como un UPDATE
		//aqui vamos a setear el id que viene por la URL a la entidad de libro que estamos recibiendo 
		
		book.setIdBook(id);	
		return repositorio.save(book);
	}

	@Override
	public List<Book> findAll() {
		return repositorio.findAll();
	}

	@Override
	public Book findById(Integer id) { 
		//el findById me devuelve un tipo de dato optional
		//como sabes desde java 8 en el 2014 se introdujo este tipo de dato para mitigar los posibles 
		//NullPointerException (colocar un valor por defecto)en el caso que llegase a ser null entonces 
		//mi valor por defecto sera un libro en blanco 
		return repositorio.findById(id).orElse(new Book(999, "DEFAUL", new Category(999, "no category"),  false));
	}

	@Override
	public void delete(Integer id) {
		repositorio.deleteById(id);

	}

	
	
	
	
	
	
	
	
	//@Override
	//public Book validandReturn(int id) {
		//if (id > 0) {
			//return repositorio.getBookById(id);
		//} else {
			//return new Book(0, "NO TITLE", false);
		//}
	//}

}
