package com.learn.batch.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.batch.model.Car;
import com.learn.batch.repositories.CarRepository;

@RestController
public class CarController {

	@Autowired
	private CarRepository carRepository;
	
	 @RequestMapping(path = "car/findAll", produces = "application/json; charset=UTF-8")
	 @ResponseBody
	public  ResponseEntity<List<Car>> getAll(){
		return new ResponseEntity<List<Car>>(carRepository.findAll(), HttpStatus.OK);
	}
	
}
