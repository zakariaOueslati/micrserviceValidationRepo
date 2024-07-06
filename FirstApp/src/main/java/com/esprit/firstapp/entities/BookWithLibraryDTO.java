package com.esprit.firstapp.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class BookWithLibraryDTO {
	private Long id;
	private String name;
	private int size;
	private String id_library;
	private LibraryDTO librarydto;
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
	public LibraryDTO getLibrarydto() {
		return librarydto;
	}
	public void setLibrarydto(LibraryDTO librarydto) {
		this.librarydto = librarydto;
	}
	public BookWithLibraryDTO() {
		super();
	}

	
	

}
