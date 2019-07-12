package com.learn.batch;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.learn.batch.model.FuelType;
import com.learn.batch.repositories.CarRepository;
import com.learn.batch.repositories.EngineTypeRepository;
import com.learn.batch.repositories.FuelTypeRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@DataJpaTest
@Slf4j
public class RepositorieTest {

	@Autowired 
	private CarRepository carRepository;
	
	@Autowired
	private EngineTypeRepository engineTypeRepository;
	
	@Autowired
	private FuelTypeRepository fuelTypeRepository;
	
	@Test
	public void runTest() {
		log.info("Initializing Test");
		List<FuelType> fuelTypeList = new ArrayList<FuelType>();
		fuelTypeList.add(new FuelType("Gasolina"));
		fuelTypeList.add(new FuelType("Etanol"));
		fuelTypeList.add(new FuelType("Diesel"));
		this.printList(fuelTypeList);
		fuelTypeRepository.saveAll(fuelTypeList);
		List<FuelType> savedList = fuelTypeRepository.findAll();
		this.printList(savedList);
	}
	
	private void printList(List<FuelType> fuelList) {
		fuelList.stream().forEach(fuel -> log.info(fuel.toString()));		
	}
	
}
