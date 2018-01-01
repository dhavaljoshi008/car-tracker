/**
 * CheckEngineLightOnAlert.java
 * app.djxlab.cartracker.api.entity 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.entity;

import app.djxlab.cartracker.api.constant.Constants;

public class CheckEngineLightOnAlert extends Alert {
	
	private boolean checkEngineLightOn;
	
	public CheckEngineLightOnAlert(boolean checkEngineLightOn, String vin, String make, String model) {
		super(Constants.PRIORITY_LOW, vin, make, model, "ALERT: Check_Engine_Light is on");
		this.checkEngineLightOn = checkEngineLightOn;
		this.setCategory(Constants.ALERT_CHECK_ENGINE_LIGHT_ON);
	}

	public boolean isCheckEngineLightOn() {
		return checkEngineLightOn;
	}

	public void setCheckEngineLightOn(boolean checkEngineLightOn) {
		this.checkEngineLightOn = checkEngineLightOn;
	}
}
