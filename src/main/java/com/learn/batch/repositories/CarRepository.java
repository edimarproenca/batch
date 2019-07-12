package com.learn.batch.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.batch.model.Car;
import com.learn.batch.model.EngineType;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

	public List<Car> findAllByEngineTypeEquals(EngineType engineType);
	
	
}
