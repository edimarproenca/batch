package com.learn.batch.job;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.learn.batch.model.Car;
import com.learn.batch.model.EngineType;
import com.learn.batch.model.FuelType;

class CarFieldSetMapper implements FieldSetMapper<Car>{

	@Override
	public Car mapFieldSet(FieldSet fieldSet) throws BindException {
		return new Car(fieldSet.readString(9), new EngineType(fieldSet.readString(3)), fieldSet.readString(17), new FuelType(fieldSet.readString(4)));
	}

}
