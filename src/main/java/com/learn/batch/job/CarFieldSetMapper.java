package com.learn.batch.job;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.learn.batch.model.Car;
import com.learn.batch.model.FuelType;

class CarFieldSetMapper implements FieldSetMapper<Car>{

	private Map<String, FuelType> fuelType = new HashMap<String, FuelType>();
	
	@Override
	public Car mapFieldSet(FieldSet fieldSet) throws BindException {
		FuelType fuel = this.getFuelType(fieldSet.readString(4));
		return new Car(fieldSet.readString(9),fuel,fieldSet.readString(3),fieldSet.readString(17));
	}
	
	public FuelType getFuelType(String fuelName) {
		FuelType result = null;
		if(fuelType.containsKey(fuelName)) {
			result = fuelType.get(fuelName);
		}else {
			fuelType.put(fuelName, new FuelType(fuelName));
			result = fuelType.get(fuelName);
		}
		return result;
	}

}
