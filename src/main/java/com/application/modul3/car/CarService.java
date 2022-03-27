package com.application.modul3.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.exception.ResourceNotFoundException;
import com.application.modul3.person.Person;
import com.application.modul3.person.PersonService;

@Service
public class CarService {
	@Autowired
	CarRepository carRepository;
	@Autowired
	PersonService personService;

	public Car createCar(Car car) {
		return carRepository.saveAndFlush(car);
	}

	public Car createCarAdd(Car car, Integer personId) {
		Person person = personService.getPersonById(personId);
		person.addCar(car);
		return carRepository.saveAndFlush(car);
	}

	public Car getCarById(Integer carId) {
//		Optional<Car> optCar = carRepository.findById(carId);
//		if (optCar.isPresent()) {
//			return optCar.get();
//		}
//		return null;
		return carRepository.findById(carId)
				.orElseThrow(()-> new ResourceNotFoundException("Car not fount with id " + carId));
	}
	
	public void deleteCarId(Integer carId) {
		carRepository.deleteById(carId);
	}
	

}