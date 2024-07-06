package com.esprit.firstapp.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.esprit.firstapp.entities.Book;
import com.esprit.firstapp.entities.BookWithLibraryDTO;
import com.esprit.firstapp.entities.LibraryDTO;
import com.esprit.firstapp.mappers.BookMappers;
import com.esprit.firstapp.repository.BookRepository;

@Service
public class BookService implements IBookService {
	@Autowired
	private LibraryClient libraryClient;

	@Autowired
	private BookRepository bookRepository;

	@Override
	public BookWithLibraryDTO addBook(BookWithLibraryDTO articleDto) {
		 bookRepository.save(BookMappers.mapToEntity(articleDto));
		return articleDto;
		
	}

	@Override
	public List<BookWithLibraryDTO> getAllBook() {

		return bookRepository.findAll().stream().map(article -> BookMappers.mapToDto(article))
				.collect(Collectors.toList());
	}

	@Override
	public BookWithLibraryDTO getBookById(Long id) {
		Book book = bookRepository.findById(id).get();
		
		//OpenFeign
		LibraryDTO libraryDTO = libraryClient.getById(book.getId_library());
		
		//RestTemplate
		//StockDTO stockDTO =getById(article.getId_stock());
		return BookMappers.mapToDto(book, libraryDTO);
	}


	@Override
	public Book updateBook(Long id, Map<String, Object> article) {
		Book existingBook = bookRepository.findById(id).get();

		if (existingBook == null) {

			return null;
		}

		for (Map.Entry<String, Object> entry : article.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			try {
				Field field = existingBook.getClass().getDeclaredField(key);
				field.setAccessible(true);
				field.set(existingBook, value);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return bookRepository.save(existingBook);
	}

	@Override
	public void deleteBookById(Long id) {
		bookRepository.deleteById(id);

	}

	public LibraryDTO getById(String id) {
		String url = "http://localhost:8090/api/getbyid/" + id;
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, LibraryDTO.class);
	}

}
