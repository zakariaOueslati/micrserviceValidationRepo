package com.esprit.firstapp.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.firstapp.entities.Book;
import com.esprit.firstapp.entities.BookWithLibraryDTO;
import com.esprit.firstapp.services.IBookService;

@RestController
@RequestMapping("/api/Book")

public class BookController {

	@Autowired
	private IBookService articleService;

	@GetMapping("/books")
	public List<BookWithLibraryDTO> getAllTutorials() {
		return articleService.getAllBook();

	}

	@PostMapping("/save")
	public BookWithLibraryDTO save(@RequestBody BookWithLibraryDTO article) {
		return articleService.addBook(article);

	}

	@DeleteMapping("/delete/{id}")
	public void supprimer(@PathVariable("id") Long id) {
		articleService.deleteBookById(id);

	}

	@GetMapping("/getbyid/{id}")
	public BookWithLibraryDTO GetById(@PathVariable("id") Long id) {
		return articleService.getBookById(id);
	}

	@PatchMapping("/update/{id}")
	public Book patchUpdateStock(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
		return articleService.updateBook(id, updates);

	}

}
