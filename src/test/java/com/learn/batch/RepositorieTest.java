package com.learn.batch;

import org.junit.Assert;
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
		FuelType fuelType = new FuelType("Gasolina");
		log.info(fuelType.toString());
		FuelType saved = fuelTypeRepository.save(fuelType);
		log.info(saved.toString());
		Assert.assertTrue(fuelType.equals(saved) && saved.getId() != null );
	}
	
}
