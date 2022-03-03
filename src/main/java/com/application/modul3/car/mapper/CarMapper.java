package com.application.modul3.car.mapper;

import org.springframework.stereotype.Component;

import com.application.modul3.car.Car;
import com.application.modul3.car.dto.CarCreateDto;
import com.application.modul3.car.dto.CarDto;

@Component
public class CarMapper {

	public Car CarDtoToCar(CarDto carDto) {
		Car car=new Car();
		car.setId(carDto.getId());
		car.setBrand(carDto.getBrand());
		car.setModel(carDto.getModel());
		car.setManufactureDate(carDto.getManufactureDate());
		car.setHorsePower(carDto.getHorsePower());
		return car;
		}
	
	public CarDto CarToCarDto(Car car) {
		CarDto carDto=new CarDto();
		carDto.setId(car.getId());
		carDto.setBrand(car.getBrand());
		carDto.setModel(car.getModel());
		carDto.setManufactureDate(car.getManufactureDate());
		carDto.setHorsePower(car.getHorsePower());
		return carDto;
		}
	public Car CarCreateDtoToCar(CarCreateDto carCreateDto) {
		Car car=new Car();
		car.setId(carCreateDto.getId());
		car.setBrand(carCreateDto.getBrand());
		car.setModel(carCreateDto.getModel());
		car.setManufactureDate(carCreateDto.getManufactureDate());
		car.setHorsePower(carCreateDto.getHorsePower());
		return car;
		}
	
	public CarCreateDto CarToCarCreateDto(Car car) {
		CarCreateDto carCreateDto=new CarCreateDto();
		carCreateDto.setId(car.getId());
		carCreateDto.setBrand(car.getBrand());
		carCreateDto.setModel(car.getModel());
		carCreateDto.setManufactureDate(car.getManufactureDate());
		carCreateDto.setHorsePower(car.getHorsePower());
		return carCreateDto;
		}
	
}
