package com.esprit.firstapp.mappers;

import com.esprit.firstapp.entities.Book;
import com.esprit.firstapp.entities.BookWithLibraryDTO;
import com.esprit.firstapp.entities.LibraryDTO;

public class BookMappers {

	public static BookWithLibraryDTO mapToDto(Book book) {

		BookWithLibraryDTO bookDTO = BookWithLibraryDTO.builder().id(book.getId()).name(book.getName())
				.size(book.getSize()).id_library(book.getId_library()).build();
		return bookDTO;
	}

	public static BookWithLibraryDTO mapToDto(Book book, LibraryDTO libraryDTO) {

		BookWithLibraryDTO bookDTO = BookWithLibraryDTO.builder().id(book.getId()).name(book.getName())
				.size(book.getSize()).id_library(book.getId_library()).librarydto(libraryDTO).build();

		return bookDTO;
	}

	public static Book mapToEntity(BookWithLibraryDTO bookDTO) {
		Book book = Book.builder().id(bookDTO.getId()).name(bookDTO.getName()).size(bookDTO.getSize())
				.id_library(bookDTO.getLibrarydto().getId()).build();
		return book;

	}

}
