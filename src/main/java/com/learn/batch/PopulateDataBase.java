package com.learn.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learn.batch.repositories.FuelTypeRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PopulateDataBase implements CommandLineRunner {
	
	@Override
	public void run(String... args) throws Exception {
	}

}
