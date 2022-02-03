package com.application.modul3.exemplary;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.book.Book;
import com.application.modul3.book.BookService;

@Service
public class ExemplaryService {

	@Autowired
	private ExemplaryRepository exemplaryRepository;
	@Autowired
	private BookService bookService;

	public Exemplary createExemplary(Integer bookId, Exemplary exemplary) {
		Book book = bookService.getBookById(bookId);
		book.addExemplary(exemplary);
		return exemplaryRepository.saveAndFlush(exemplary);
	}

	public void deleteExemplary(Integer exemplaryId) {
		exemplaryRepository.deleteById(exemplaryId);
	}
	
	public List<Exemplary> findExemplariesByBookId(Integer bookId){
		return exemplaryRepository.findExemplariesByBookId(bookId);
		/*
		 * SELECT exemplary.id, exemplary.date, exemplary.code FROM administartion.exemplary 
		 * INNER JOIN administration.book ON exemplary.book_id = book.id WHERE book.id = :bookId
		 */
	}
}