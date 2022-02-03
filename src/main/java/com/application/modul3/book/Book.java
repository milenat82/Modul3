package com.application.modul3.book;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.application.modul3.exemplary.Exemplary;


@Entity
@Table(name = "book", schema = "administration")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "year")
	private LocalDate yearBook; // LocalDate ->"yyyy-mm-dd"

	@Column(name = "isbn")
	private String isbn;

	@OneToMany(mappedBy = "book", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, orphanRemoval = true)
	private Set<Exemplary> exemplaries;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitleBook() {
		return title;
	}

	public void setTitleBook(String titleBook) {
		this.title = titleBook;
	}

	public LocalDate getYearBook() {
		return yearBook;
	}

	
	public void setYearBook(LocalDate yearBook) {
		this.yearBook = yearBook;
	}

	public String getIsbnBook() {
		return isbn;
	}

	public void setIsbnBook(String isbn) {
		this.isbn = isbn;
	}

	public void addExemplary(Exemplary exemplary) {
		this.exemplaries.add(exemplary);
		exemplary.setBook(this);
	}

	public void removeExemplary(Exemplary exemplary) {
		this.exemplaries.remove(exemplary);
		exemplary.setBook(null);
	}

	public Set<Exemplary> getExemplaries() {
		return exemplaries;
	}

	public void setExemplaries(Set<Exemplary> exemplaries) {
		this.exemplaries = exemplaries;
	}

}