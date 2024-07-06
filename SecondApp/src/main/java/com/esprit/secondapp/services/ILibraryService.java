package com.esprit.secondapp.services;

import java.util.List;
import java.util.Map;

import com.esprit.secondapp.entities.Library;

public interface ILibraryService {

	Library addLibrary(Library library);

	Library updateLibrary(String id, Map<String, Object> stock);

	List<Library> getAllLibrary();

	Library getLibraryById(String id);

	void deleteLibraryById(String id);

}
