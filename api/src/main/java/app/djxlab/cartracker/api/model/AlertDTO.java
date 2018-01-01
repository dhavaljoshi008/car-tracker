/**
 * AlertDTO.java
 * app.djxlab.cartracker.api.model 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.model;

import app.djxlab.cartracker.api.entity.Tires;

public class AlertDTO {
	
	private String vin;
	
	private String make;
	
	private String model;
	
	private int engineRpm;
	
	private int redlineRpm;
	
	private double fuelVolume;
	
	private double maxFuelVolume;
	
	private Tires tires;
	
	private boolean engineCoolantLow;
	
	private boolean checkEngineLightOn;

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

	public int getEngineRpm() {
		return engineRpm;
	}

	public void setEngineRpm(int engineRpm) {
		this.engineRpm = engineRpm;
	}

	public int getRedlineRpm() {
		return redlineRpm;
	}

	public void setRedlineRpm(int redlineRpm) {
		this.redlineRpm = redlineRpm;
	}

	public double getFuelVolume() {
		return fuelVolume;
	}

	public void setFuelVolume(double fuelVolume) {
		this.fuelVolume = fuelVolume;
	}

	public double getMaxFuelVolume() {
		return maxFuelVolume;
	}

	public void setMaxFuelVolume(double maxFuelVolume) {
		this.maxFuelVolume = maxFuelVolume;
	}

	public Tires getTires() {
		return tires;
	}

	public void setTires(Tires tires) {
		this.tires = tires;
	}

	public boolean isEngineCoolantLow() {
		return engineCoolantLow;
	}

	public void setEngineCoolantLow(boolean engineCoolantLow) {
		this.engineCoolantLow = engineCoolantLow;
	}

	public boolean isCheckEngineLightOn() {
		return checkEngineLightOn;
	}

	public void setCheckEngineLightOn(boolean checkEngineLightOn) {
		this.checkEngineLightOn = checkEngineLightOn;
	}
}
