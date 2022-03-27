package com.application.modul3.book.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.application.modul3.book.Book;
import com.application.modul3.book.dto.BookDTO;
import com.application.modul3.book.dto.BookCreateDTO;

@Component
public class BookMapper {
	//@Autowired ExemplaryMapper exemplaryMapper;
	
	public BookDTO book2BookDTO(Book book) {
		BookDTO bookDTO = new BookDTO();
		//bookDTO.setId(book.getId());
		bookDTO.setTitle(book.getTitleBook());
		bookDTO.setIsbn(book.getIsbnBook());
		bookDTO.setYear(book.getYearBook());
		//bookDTO.setExemplaryListDTO(exemplaryMapper.exemplaryList2ExemplaryListDTO(book.getExemplaryList()));
		return bookDTO;
	}
	
	public Book bookDTO2Book(BookDTO bookDTO) {
		Book book = new Book();
		book.setTitleBook(bookDTO.getTitle());
		book.setYearBook(bookDTO.getYear());
		book.setIsbnBook(bookDTO.getIsbn());
		return book;
	}

	public List<BookDTO> bookList2BookListDTO(List<Book> books) {
		return books.stream().map(book -> book2BookDTO(book)).collect(Collectors.toList());
//		List<BookDTO> bookListDTO = new ArrayList<>();//alternativa pt stream
//		for(Book book : books) {
//			bookListDTO.add(book2BookDTO(book));
//		}
//		return bookListDTO;
	}
	
	public BookCreateDTO book2BookCreateDTO(Book book) {
		BookCreateDTO bookCreateDTO = new BookCreateDTO();
	//	bookCreateDTO.setId(book.getId());
		bookCreateDTO.setTitle(book.getTitleBook());
		bookCreateDTO.setIsbn(book.getIsbnBook());
		bookCreateDTO.setYear(book.getYearBook());
		//bookDTO.setExemplaryListDTO(exemplaryMapper.exemplaryList2ExemplaryListDTO(book.getExemplaryList()));
		return bookCreateDTO;
	}
	
	public Book bookCreateDTO2Book(BookCreateDTO bookCreateDTO) {
		Book book = new Book();
		book.setTitleBook(bookCreateDTO.getTitle());
		book.setYearBook(bookCreateDTO.getYear());
		book.setIsbnBook(bookCreateDTO.getIsbn());
		return book;
	}
	
}