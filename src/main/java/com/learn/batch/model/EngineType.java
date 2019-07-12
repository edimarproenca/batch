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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fuelType == null) ? 0 : fuelType.hashCode());
		result = prime * result + ((hibrid == null) ? 0 : hibrid.hashCode());
		result = prime * result + horsePower;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + torque;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EngineType other = (EngineType) obj;
		if (fuelType == null) {
			if (other.fuelType != null)
				return false;
		} else if (!fuelType.equals(other.fuelType))
			return false;
		if (hibrid == null) {
			if (other.hibrid != null)
				return false;
		} else if (!hibrid.equals(other.hibrid))
			return false;
		if (horsePower != other.horsePower)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (torque != other.torque)
			return false;
		return true;
	}
	
	

}
