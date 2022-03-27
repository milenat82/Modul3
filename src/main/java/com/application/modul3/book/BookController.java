package com.application.modul3.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.book.dto.BookAuthorDTO;
import com.application.modul3.book.dto.BookCreateDTO;
import com.application.modul3.book.dto.BookDTO;
import com.application.modul3.book.mapper.BookMapper;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private BookMapper bookMapper;

	//parametru e de tip BookCreateDTO
	@PostMapping
	public BookDTO createBook(@RequestBody BookCreateDTO bookCreateDTO) {
		Book createBook = bookService.createBook(bookMapper.bookCreateDTO2Book(bookCreateDTO));
		return bookMapper.book2BookDTO(createBook);
	}

	@PostMapping("/with-authors")
	public BookDTO createBookWithAuthor(@RequestBody BookCreateDTO bookCreateDTO) {
		Book createBook = bookService.createBook(bookMapper.bookCreateDTO2Book(bookCreateDTO),
				bookCreateDTO.getAuthorIds());
		return bookMapper.book2BookDTO(createBook);
	}

	@GetMapping("/list")
	public List<BookDTO> getAllBook() {
		return bookMapper.bookList2BookListDTO(bookService.getAllBooks());
	}

	@GetMapping("/{id}")
	public BookDTO getBookById(@PathVariable Integer id) {
		return bookMapper.book2BookDTO(bookService.getBookById(id));
	}

	@DeleteMapping("/{id}")
	public void deleteBookById(@PathVariable Integer id) {
		bookService.deleteBookById(id);
	}

	//bookDTO
	@PutMapping("/{id}")
	public BookDTO updateBook(@RequestBody BookDTO bookDTO, @PathVariable Integer id) {	
		return bookMapper.book2BookDTO(bookService.updateBook(bookMapper.bookDTO2Book(bookDTO), id));
	}

	@GetMapping("/title/name")
	public List<BookDTO> getBookByTitle(@RequestParam String title) {
		return bookMapper.bookList2BookListDTO(bookService.getBookByTitle(title));
	}

	@GetMapping("/book-authorsId/{bookId}")
	public BookCreateDTO findBookWithAuthorsID(@PathVariable Integer bookId) {

		return bookMapper.book2BookCreateDTO(bookService.findBookWithAuthorsID(bookId));
	}

	@GetMapping("/bookWithAuthors/{bookId}")
	public BookAuthorDTO findBookWithAuthors(@PathVariable Integer bookId) {

		return bookMapper.book2BookAuthorsDTO(bookService.findBookWithAuthorsID(bookId));
	}
}