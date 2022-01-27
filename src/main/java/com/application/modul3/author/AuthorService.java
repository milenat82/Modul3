package com.application.modul3.author;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	
	public Author createAuthor(Author author) {
		return authorRepository.saveAndFlush(author);
	}
	
	public List<Author>getAllAuthors(){
		return authorRepository.findAll();
	}
	
	public Author getAuthorById(Integer id) {
		Optional <Author>authorOpt=authorRepository.findById(id);////????
		return authorOpt.get();
	}
	public void deleteAuthorById(Integer id) {
		authorRepository.deleteById(id);
	}


}
