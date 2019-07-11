package com.learn.batch.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "engine_type")
public class EngineType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private String model;
	private FuelType fuelType;
	private int horsePower;
	private int torque;
	private Boolean hibrid;

	public EngineType(Long id, String model, FuelType fuelType, int horsePower, int torque, Boolean hibrid) {
		super();
		this.id = id;
		this.model = model;
		this.fuelType = fuelType;
		this.horsePower = horsePower;
		this.torque = torque;
		this.hibrid = hibrid;
	}

	public EngineType() {
		super();
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

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public int getTorque() {
		return torque;
	}

	public void setTorque(int torque) {
		this.torque = torque;
	}

	public Boolean getHibrid() {
		return hibrid;
	}

	public void setHibrid(Boolean hibrid) {
		this.hibrid = hibrid;
	}

}
