package com.application.modul3.person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.modul3.car.CarRepository;



@Component
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	CarRepository carRepository;
	


	public Person createPerson(Person person) {
		return personRepository.saveAndFlush(person);
	}

	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

	public Person getPersonById(Integer id) {
		Optional<Person> personOpt = personRepository.findById(id);
		if (personOpt.isPresent()) {
			return personOpt.get();
		}
		return null;
	}
	
	public void deletePersonById(Integer id) {
		personRepository.deleteById(id);
	}
	
	
}
