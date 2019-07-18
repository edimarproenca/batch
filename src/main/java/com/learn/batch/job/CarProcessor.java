package com.learn.batch.job;


import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.learn.batch.model.Car;
import com.learn.batch.model.FuelType;
import com.learn.batch.repositories.FuelTypeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CarProcessor implements ItemProcessor<Car, Car>{

	
	@Autowired
	private FuelTypeRepository fuelTypeRepository;
	
	private Map<String, FuelType> fuelMap;
	
	public CarProcessor() {
		fuelMap = new HashMap<String, FuelType>();
	}
	
	private FuelType resolveFuel(String fuelName) {
		FuelType result = null;
		if(this.fuelMap.containsKey(fuelName)) {
			result = fuelMap.get(fuelName);
		}else {
			result = fuelTypeRepository.save(new FuelType(fuelName));
			this.fuelMap.put(fuelName, result);
		}
		return result;
	}
	
	@Override
	public Car process(Car item) throws Exception {
		item.setFuelType(this.resolveFuel(item.getFuelType().getFuelName()));
		return item;
	}

	

}
