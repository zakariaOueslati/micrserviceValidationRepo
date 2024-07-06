package com.esprit.firstapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

@Entity
@Builder
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private int size;
	private String id_library;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getId_library() {
		return id_library;
	}
	public void setId_library(String id_library) {
		this.id_library = id_library;
	}
	public Book(Long id, String name, int size, String id_library) {
		this.id = id;
		this.name = name;
		this.size = size;
		this.id_library = id_library;
	}
	public Book() {
	}
	
	

}
