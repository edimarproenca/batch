package com.learn.batch.job;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.learn.batch.model.FuelType;


@Service
public class MountObjectsService {

	private Map<String, FuelType> fuelType = new HashMap<String, FuelType>();
	
	public FuelType getFuelType(String fuelName) {
		FuelType result = null;
		if(fuelType.containsKey(fuelName)) {
			result = fuelType.get(fuelName);
		}else {
			fuelType.put(fuelName, new FuelType(fuelName));
			result = fuelType.get(fuelName);
		}
		return result;
	}
	
}
