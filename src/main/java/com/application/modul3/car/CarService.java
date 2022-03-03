package com.application.modul3.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.modul3.person.Person;
import com.application.modul3.person.PersonService;

@Component
public class CarService {

	@Autowired
	CarRepository carRepository;
	@Autowired
	PersonService personService;

	public Car createCarWithPerson(Integer personId, Car car) {
		Person person = personService.getPersonById(personId);
		person.addCar(car);
		return carRepository.saveAndFlush(car);
	}
	
	public Car createCar(Car car) {
		return carRepository.saveAndFlush(car);
	}
}
