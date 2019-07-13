package com.learn.batch.job;


import org.springframework.batch.item.ItemProcessor;

import com.learn.batch.model.Car;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CarProcessor implements ItemProcessor<Car, Car>{

	@Override
	public Car process(Car item) throws Exception {
		log.info("Reading Car");
		log.info(item.toString());
		return item;
	}

	

}
