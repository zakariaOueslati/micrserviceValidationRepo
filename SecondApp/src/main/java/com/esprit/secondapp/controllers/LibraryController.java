package com.esprit.secondapp.controllers;

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

import com.esprit.secondapp.entities.Library;
import com.esprit.secondapp.services.ILibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {
	@Autowired
	private ILibraryService iLibraryService;
	
	 @GetMapping("/getAll")
	  public List<Library> getAllTutorials() {
		 return iLibraryService.getAllLibrary();
	    
	  }
	 
	 
	 @PostMapping("/save")
	 public Library save(@RequestBody Library library) {
		 return iLibraryService.addLibrary(library);
		 
	    
	  }
	 @DeleteMapping("/delete/{id}")
     public void supprimer(@PathVariable("id") String id){
		 iLibraryService.deleteLibraryById(id);

     }
     @GetMapping("/getbyid/{id}")
    public Library GetById(@PathVariable("id") String id){
        return iLibraryService.getLibraryById(id);
     }
     
     
     @PatchMapping("/update/{id}")
     public Library patchUpdateStock(@PathVariable String id, @RequestBody Map<String, Object> updates) {
         return iLibraryService.updateLibrary(id,  updates);

     }

}
