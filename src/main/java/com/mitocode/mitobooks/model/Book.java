package com.mitocode.mitobooks.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Book {

	@Id
	private int idBook;
	
	@Column(name = "book_title", length = 50, nullable = false)
	private String title;
	
	@ManyToOne
	@JoinColumn(name="id_category", nullable=false)
	private Category category;
	
	@Column(nullable = false)
	private boolean enabled;
	
	
	
}
