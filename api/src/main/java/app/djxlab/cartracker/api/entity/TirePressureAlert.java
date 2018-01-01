/**
 * TirePressureAlert.java
 * app.djxlab.cartracker.api.entity 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.entity;

import app.djxlab.cartracker.api.constant.Constants;

public class TirePressureAlert extends Alert {
	
	private Tires tires;

	public TirePressureAlert(Tires tires, String vin, String make, String model) {
		super(Constants.PRIORITY_LOW, vin, make, model, "ALERT: Tire_Pressure < " + Constants.TIRE_PRESSURE_LOW_THRESHOLD + " psi || > " + Constants.TIRE_PRESSURE_HIGH_THRESHOLD + " psi in one or more tires");
		this.tires = tires;
		this.setCategory(Constants.ALERT_TIRE_PRESSURE);
	}

	public Tires getTires() {
		return tires;
	}

	public void setTires(Tires tires) {
		this.tires = tires;
	}
}