/**
 * Vehicle.java
 * app.djxlab.cartracker.api.entity 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import app.djxlab.cartracker.api.constant.Constants;

@Document(collection = "dataCollection")
public class Vehicle {
	
	@Id
	private String id;
	
	private String vin;
	
    private String make;
    
    private String model;
    
    private int year;
    
    private int redlineRpm;
    
    private double maxFuelVolume;
    
    private Date lastServiceDate;
    
    private final String type = Constants.TYPE_VEHICLE;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRedlineRpm() {
		return redlineRpm;
	}

	public void setRedlineRpm(int redlineRpm) {
		this.redlineRpm = redlineRpm;
	}

	public double getMaxFuelVolume() {
		return maxFuelVolume;
	}

	public void setMaxFuelVolume(double maxFuelVolume) {
		this.maxFuelVolume = maxFuelVolume;
	}

	public Date getLastServiceDate() {
		return lastServiceDate;
	}

	public void setLastServiceDate(Date lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}
}
