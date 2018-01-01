/**
 * FuelVolumeAlert.java
 * app.djxlab.cartracker.api.entity 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.entity;

import app.djxlab.cartracker.api.constant.Constants;

public class FuelVolumeAlert extends Alert {
	
	private double fuelVolume;
    
	private double maxFuelVolume;
		
	public FuelVolumeAlert(double fuelVolume, double maxFuelVolume, String vin, String make, String model) {
		super(Constants.PRIORITY_MEDIUM, vin, make, model, "ALERT: Fuel_Volume: " + fuelVolume + "  <  " + (Constants.FUEL_THRESHOLD_PERCENT * 100) + "%" + " of the Max_Fuel_Volume: " + maxFuelVolume);
		this.fuelVolume = fuelVolume;
		this.maxFuelVolume = maxFuelVolume;
		this.setCategory(Constants.ALERT_FUEL_VOLUME);
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
}
