package com.esprit.secondapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.esprit.secondapp.entities.Library;

public interface LibraryRepository extends MongoRepository<Library, String>{

}
