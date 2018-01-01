/**
 * EngineCoolantLowAlert.java
 * app.djxlab.cartracker.api.entity 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.entity;

import app.djxlab.cartracker.api.constant.Constants;

public class EngineCoolantLowAlert extends Alert {

	private boolean engineCoolantLow;
	
	public EngineCoolantLowAlert(boolean engineCoolantLow, String vin, String make, String model) {
		super(Constants.PRIORITY_LOW, vin, make, model, "ALERT: Engine_Coolant is low");
		this.engineCoolantLow = engineCoolantLow;
		this.setCategory(Constants.ALERT_ENGINE_COOLANT_LOW);
	}

	public boolean isEngineCoolantLow() {
		return engineCoolantLow;
	}

	public void setEngineCoolantLow(boolean engineCoolantLow) {
		this.engineCoolantLow = engineCoolantLow;
	}
}
