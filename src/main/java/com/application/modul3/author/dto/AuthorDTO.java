package com.application.modul3.author.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.application.modul3.gender.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AuthorDTO {
	private Integer id;
	private String name;
	private LocalDate birthDate;
	private Gender gender;
	private LocalDate deathDate;
	//private String nationality;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	public LocalDate getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(LocalDate deathDate) {
		this.deathDate = deathDate;
	}

	/*
	 * public String getNationality() { return nationality; }
	 */

	/*
	 * public void setNationality(String nationality) { this.nationality =
	 * nationality; }
	 */

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}