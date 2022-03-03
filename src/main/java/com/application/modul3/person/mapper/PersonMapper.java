package com.application.modul3.person.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.application.modul3.person.Person;
import com.application.modul3.person.dto.PersonDto;
import com.application.modul3.person.dto.PersonCreateDto;

@Component
public class PersonMapper {

	public PersonDto personToPersonDto(Person person) {
		PersonDto personDto=new PersonDto();
		personDto.setId(person.getId());
		personDto.setName(person.getName());
		personDto.setSurname(person.getSurname());
		personDto.setAge(person.getAge());
		return personDto;
	}
	
	public List<PersonDto>personListToPersonDtoList(List<Person>personList){
		return personList.stream().map(person->personToPersonDto(person)).collect(Collectors.toList());
	}
	
	public Person personDtoToPerson(PersonDto personDto) {
		Person person=new Person();
		person.setId(personDto.getId());
		person.setName(personDto.getName());
		person.setSurname(personDto.getSurname());
		person.setAge(personDto.getAge());
		return person;
	}
	public List<Person>personListDtoToPersonList(List<PersonDto>personDtoList){
		return personDtoList.stream().map(personDto->personDtoToPerson(personDto)).collect(Collectors.toList());
	}
	
	public Person personCreatedToPerson(PersonCreateDto personCreateDto) {
		Person person=new Person();
		//person.setId(personCreateDto.getId());
		person.setName(personCreateDto.getName());
		person.setSurname(personCreateDto.getSurname());
		return person;
	}
	
	
}
