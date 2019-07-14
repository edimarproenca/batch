package com.learn.batch.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "car")
public class Car implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String model;
	
	@OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
	private FuelType fuelType;
	
	private String engineType;
	
	private String year;

	public Car() {
	}
	
	public Car(String model, FuelType fuelType, String engineType, String year) {
		super();
		this.model = model;
		this.fuelType = fuelType;
		this.engineType = engineType;
		this.year = year;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public FuelType getFuelType() {
		return fuelType;
	}


	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}


	public String getEngineType() {
		return engineType;
	}


	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	@Override
	public String toString() {
		return new ToStringCreator(this)
					.append("id", this.id)
					.append("model", this.model)
					.append("fuelType", this.fuelType)
					.append("year", this.year)
					.toString();
	}
}
