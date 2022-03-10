package com.application.modul3.exemplary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.book.Book;
import com.application.modul3.book.BookService;
import com.application.modul3.publisher.Publisher;
import com.application.modul3.publisher.PublisherService;

@Service
public class ExemplaryService {

	@Autowired
	private ExemplaryRepository exemplaryRepository;
	@Autowired
	private PublisherService publisherService;
	@Autowired
	private BookService bookService;//postasul care nu poate intra in casa mea si sa deschida dulapurile

	public Exemplary createExemplary(Integer bookId, Integer publisherId, Exemplary exemplary) throws Exception {
		Book book = bookService.getBookById(bookId);
		if (book == null) {
			throw new Exception("Book with id " + bookId + " was not found");
		}
		Publisher publisher = publisherService.getPublisherById(publisherId);

		// one to many + many to one (bidirectional)
		book.addExemplary(exemplary);
		// doar many to one
		exemplary.setPublisher(publisher);

		return exemplaryRepository.saveAndFlush(exemplary);
	}

	public void deleteExemplary(Integer exemplaryId) {
		exemplaryRepository.deleteById(exemplaryId);
	}

	public List<Exemplary> findExemplariesByBookId(Integer bookId) {
		return exemplaryRepository.findByBookId(bookId);
		/*
		 * SELECT exemplary.id, exemplary.date, exemplary.code FROM
		 * administartion.exemplary INNER JOIN administration.book ON exemplary.book_id
		 * = book.id WHERE book.id = :bookId
		 */
	}
}