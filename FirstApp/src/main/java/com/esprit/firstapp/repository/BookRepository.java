package com.esprit.firstapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.firstapp.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
