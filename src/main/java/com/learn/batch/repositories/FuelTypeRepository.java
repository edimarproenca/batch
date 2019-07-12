package com.learn.batch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.batch.model.FuelType;

@Repository
public interface FuelTypeRepository extends JpaRepository<FuelType, Long> {

}
