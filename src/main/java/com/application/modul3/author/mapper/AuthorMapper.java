package com.application.modul3.author.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.application.modul3.author.Author;
import com.application.modul3.author.dto.AuthorDTO;

@Component
public class AuthorMapper {

	public AuthorDTO author2AuthorDTO(Author author) {
		AuthorDTO authorDTO = new AuthorDTO();
		authorDTO.setId(author.getId());
		authorDTO.setName(author.getName());
		authorDTO.setBirthDate(author.getBirthDate());
		authorDTO.setDeathDate(author.getDeathDate());
		authorDTO.setGender(author.getGender());
		return authorDTO;
	}

	public Author authorDTO2Author(AuthorDTO authorDTO) {
		Author author = new Author();
		author.setName(authorDTO.getName());
		author.setBirthDate(authorDTO.getBirthDate());
		author.setDeathDate(authorDTO.getDeathDate());
		author.setGender(authorDTO.getGender());
		return author;
	}

	public List<AuthorDTO> authorList2AuthorListDTO(List<Author> list) {
		return list.stream().map(author -> author2AuthorDTO(author)).collect(Collectors.toList());
	}

	public List<Author> authorListDTO2AuthorList(List<AuthorDTO> authorListDTO) {
		return authorListDTO.stream().map(authorDTO -> authorDTO2Author(authorDTO)).collect(Collectors.toList());
	}

}