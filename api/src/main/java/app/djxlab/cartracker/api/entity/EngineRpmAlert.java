/**
 * EngineRpmAlert.java
 * app.djxlab.cartracker.api.entity 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.entity;

import app.djxlab.cartracker.api.constant.Constants;

public class EngineRpmAlert extends Alert {

	
	  private int engineRpm;
	    
	  private int redlineRpm;
	  
	  public EngineRpmAlert(int engineRpm, int redlineRpm, String vin, String make, String model) {
		super(Constants.PRIORITY_HIGH, vin, make, model, "ALERT: Engine_RPM: " + engineRpm + " > " + "Redline_RPM: " + redlineRpm);
		this.engineRpm = engineRpm;
		this.redlineRpm = redlineRpm;
		this.setCategory(Constants.ALERT_ENGINE_RPM);
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
}
