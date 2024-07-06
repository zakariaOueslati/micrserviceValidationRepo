package com.esprit.secondapp.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.secondapp.entities.Library;
import com.esprit.secondapp.repository.LibraryRepository;

@Service
public class LibraryService implements ILibraryService {

	@Autowired
	private LibraryRepository libraryRepository;

	@Override
	public Library addLibrary(Library library) {
		libraryRepository.save(library);
		return library;
	}

	@Override
	public Library updateLibrary(String id, Map<String, Object> library) {
		Library existingLibrary = libraryRepository.findById(id).get();

		if (existingLibrary == null) {

			return null;
		}

		for (Map.Entry<String, Object> entry : library.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			try {
				Field field = existingLibrary.getClass().getDeclaredField(key);
				field.setAccessible(true);
				field.set(existingLibrary, value);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return libraryRepository.save(existingLibrary);
		 

	}

	@Override
	public List<Library> getAllLibrary() {
		return libraryRepository.findAll();
	}

	@Override
	public Library getLibraryById(String id) {
		return libraryRepository.findById(id).get();
	}

	@Override
	public void deleteLibraryById(String id) {
		libraryRepository.deleteById(id);

	}

}
