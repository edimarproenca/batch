package com.learn.batch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.batch.model.EngineType;

@Repository
public interface EngineTypeRepository extends JpaRepository<EngineType, Long> {

}
