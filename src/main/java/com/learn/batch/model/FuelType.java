package com.learn.batch.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fuel_type")
public class FuelType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private String fuelName;

	public FuelType() {
		super();
	}

	public FuelType(String fuelName) {
		super();
		this.fuelName = fuelName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFuelName() {
		return fuelName;
	}

	public void setFuelName(String fuelName) {
		this.fuelName = fuelName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fuelName == null) ? 0 : fuelName.hashCode());
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
		FuelType other = (FuelType) obj;
		if (fuelName == null) {
			if (other.fuelName != null)
				return false;
		} else if (!fuelName.equals(other.fuelName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FuelType [id=" + id + ", fuelName=" + fuelName + "]";
	}

}
