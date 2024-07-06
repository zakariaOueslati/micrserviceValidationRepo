package com.esprit.firstapp.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.esprit.firstapp.entities.LibraryDTO;

@FeignClient(name = "library", url = "http://localhost:8090")
public interface LibraryClient {
	
	 @GetMapping("/library/getbyid/{id}")
	 LibraryDTO getById(@PathVariable("id") String id);
	 
	 

}
