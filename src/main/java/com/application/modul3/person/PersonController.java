package com.application.modul3.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.application.modul3.person.dto.PersonCreateDto;
import com.application.modul3.person.dto.PersonDto;
import com.application.modul3.person.mapper.PersonMapper;


@Component
public class PersonController {

	@Autowired
	PersonService personService;
	@Autowired
	PersonMapper personMapper;

	// person - POST (primeste un PersonCreateDTO cu campurile (introduceti voi...
	// Not sure? Scrie-mi!) si va returna un PersonDTO)
	@PostMapping
	public PersonDto createPerson(@RequestBody PersonCreateDto personCreateDto) {
		Person createdPerson = personService.createPerson(personMapper.personCreatedToPerson(personCreateDto));
		return personMapper.personToPersonDto(createdPerson);
	}

	// person/{id} - PUT (primeste un PersonDTO, va returna un PersonDTO)
	@PostMapping 
	PersonDto createPerson(@RequestBody PersonDto personDto) {
		Person createdPerson = personService.createPerson(personMapper.personDtoToPerson(personDto));
		return personMapper.personToPersonDto(createdPerson);
	}

	// person - GET (returneaza List<PersonDTO>)
	@GetMapping("/{listDto}")
    public List<PersonDto> getAllPersons(){
		return personMapper.personListToPersonDtoList(personService.getAllPersons());
	}

		
	// person/get/{id} - GET (returneaza o persoana dupa ID)
	@GetMapping("/{id}")
	public Person getPersonById(@PathVariable Integer id) {
		return personService.getPersonById(id);
	}

	// person/{id} - DELETE (sterge o persoana dupa ID)
	@DeleteMapping("person/{id}")
	public void deletePersonById(@PathVariable Integer id) {
		personService.deletePersonById(id);
	}

	//person/remove-from-user/{personId}/{carId} 
	//-> GET fara body -> in Service, asta se face prin acel remove bidirectional. Testati urmatorul lucru: daca orphanRemoval = true, verificati
	//daca a sters cu totul masina din baza de date. Daca orphanRemoval = false, verificati ca doar a pus FK pe null in tabela Masina
	@DeleteMapping("/{id}")
	public void deletePersonById1(@PathVariable Integer id) {
		personService.deletePersonById(id);
	}
}