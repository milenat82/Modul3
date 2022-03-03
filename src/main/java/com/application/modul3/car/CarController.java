package com.application.modul3.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.application.modul3.car.dto.CarCreateDto;
import com.application.modul3.car.dto.CarDto;
import com.application.modul3.car.mapper.CarMapper;

public class CarController {
	@Autowired
	CarService carService;
	@Autowired
	CarMapper carMapper;

	// cars - POST (primeste un CarCreateDTO, va returna un CarDTO) -> acest
	// endpoint NU va adauga o masina la o persoana
	@PostMapping("/add")
	public CarDto createCar(CarCreateDto carCreateDto) {
		Car carCreated = carService.createCar(carMapper.CarCreateDtoToCar(carCreateDto));
		return carMapper.CarToCarDto(carCreated);

	}

	// cars/{personId} - POST (primeste un CarCreateDTO, va returna un CarDTO) ->
	// aceste endpoint VA ADAUGA o masina la o persoana
	@PostMapping("/add/{personId}")
	public ResponseEntity<Object> createCarWithPerson(@PathVariable Integer personId,
			@RequestBody CarCreateDto carCreateDto) {
		Car carCreated = carService.createCarWithPerson(personId, carMapper.CarCreateDtoToCar(carCreateDto));
		return ResponseEntity.ok(carMapper.CarToCarDto(carCreated));

	}
}
