package com.application.modul3.book;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.author.Author;
import com.application.modul3.author.AuthorService;
import com.application.modul3.exception.ResourceNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorService authorService;

	// cream o carte si o salvam
	public Book createBook(Book book) {
		return bookRepository.saveAndFlush(book);
	}

	public Book createBook(Book book, Set<Integer> authorIds) {
		Set<Author> authors = authorService.getAuthors(authorIds);
		for (Author author : authors) {
			book.addAuthor(author);
		}
		return bookRepository.save(book);
	}

	// obtinem toate cartile din db
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	// obtinem o carte dupa id
	public Book getBookById(Integer id) {
		return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
	}

	// stergerea unei carti
	public void deleteBookById(Integer id) {
		bookRepository.deleteById(id);
	}

	/*
	 * // update-DE SCHIMBAT CU DTO public Book updateBook(Book book, Integer id) {
	 * Book bookUpdate = getBookById(id);
	 * bookUpdate.setTitleBook(book.getTitleBook());
	 * bookUpdate.setYearBook(book.getYearBook());
	 * bookUpdate.setIsbnBook(book.getIsbnBook()); bookRepository.flush(); return
	 * bookUpdate; }
	 * 
	 * // testata doar de Camelia! public List<Book> findByTitle(String title) {
	 * return bookRepository.findByTitle(title); }
	 */

}