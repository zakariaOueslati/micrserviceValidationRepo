package com.esprit.firstapp.services;

import java.util.List;
import java.util.Map;

import com.esprit.firstapp.entities.Book;
import com.esprit.firstapp.entities.BookWithLibraryDTO;

public interface IBookService {
	
	BookWithLibraryDTO addBook(BookWithLibraryDTO article);

	Book updateBook(Long id, Map<String, Object> article);

	List<BookWithLibraryDTO> getAllBook();

	BookWithLibraryDTO getBookById(Long id);

	void deleteBookById(Long id);

}
