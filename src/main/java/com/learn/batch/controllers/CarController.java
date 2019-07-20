package com.learn.batch.controllers;

import java.awt.PageAttributes.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.batch.model.Car;
import com.learn.batch.model.FuelType;
import com.learn.batch.repositories.CarRepository;
import com.learn.batch.repositories.FuelTypeRepository;

@RestController
@RequestMapping("/cars/")
public class CarController {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private FuelTypeRepository fuelTypeRepository;

	@RequestMapping(path = "findAll",method = RequestMethod.GET ,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Car> getAll() {
		return carRepository.findAll();
	}
	
	@RequestMapping(path = "findAllFuels", produces = "application/json; charset=UTF8")
	public List<FuelType> getAllFuel(){
		return fuelTypeRepository.findAll();
	}

	@GetMapping("loadDataBase")
	@ResponseBody
	public ResponseEntity<BatchStatus> load() throws JobParametersInvalidException, JobExecutionAlreadyRunningException,
			JobRestartException, JobInstanceAlreadyCompleteException {
		Map<String, JobParameter> maps = new HashMap<>();
		maps.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters parameters = new JobParameters(maps);
		JobExecution jobExecution = jobLauncher.run(job, parameters);
		System.out.println("JobExecution: " + jobExecution.getStatus());
		System.out.println("Batch is Running...");
		while (jobExecution.isRunning()) {
			System.out.println("...");
		}
		return new ResponseEntity<BatchStatus>(jobExecution.getStatus(), HttpStatus.OK);
	}

}
