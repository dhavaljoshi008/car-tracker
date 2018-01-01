/**
 * AlertFactory.java
 * app.djxlab.cartracker.api.entity 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.entity;

import app.djxlab.cartracker.api.constant.Constants;
import app.djxlab.cartracker.api.model.AlertDTO;

public class AlertFactory {
	public static Alert build(String type, AlertDTO alertDTO) {
		switch (type) {
			case Constants.ALERT_ENGINE_RPM:
				return new EngineRpmAlert(alertDTO.getEngineRpm(), alertDTO.getRedlineRpm(), alertDTO.getVin(), alertDTO.getMake(), alertDTO.getModel());
			
			case Constants.ALERT_FUEL_VOLUME:
				return new FuelVolumeAlert(alertDTO.getFuelVolume(), alertDTO.getMaxFuelVolume(), alertDTO.getVin(), alertDTO.getMake(), alertDTO.getModel());
			
			case Constants.ALERT_TIRE_PRESSURE:
				return new TirePressureAlert(alertDTO.getTires(), alertDTO.getVin(), alertDTO.getMake(), alertDTO.getModel());
			
			case Constants.ALERT_ENGINE_COOLANT_LOW:
				return new EngineCoolantLowAlert(alertDTO.isEngineCoolantLow(), alertDTO.getVin(), alertDTO.getMake(), alertDTO.getModel());
			
			case Constants.ALERT_CHECK_ENGINE_LIGHT_ON:
				return new CheckEngineLightOnAlert(alertDTO.isCheckEngineLightOn(), alertDTO.getVin(), alertDTO.getMake(), alertDTO.getModel());
			default:
				return new Alert("","", "", "", "");
		}
	}
}
