/**
 * BusinessService.java
 * app.djxlab.cartracker.api.service 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.service;

import app.djxlab.cartracker.api.entity.Reading;

public interface BusinessService {
	
	public void analyzeEngineRpmFromReading(Reading reading);
	
	public void analyzeFuelVolumeFromReading(Reading reading);
	
	public void analyzeTirePressureFromReading(Reading reading);
	
	public void analyzeEngineCoolantLowFromReading(Reading reading);
	
	public void analyzeCheckEngineLightOnFromReading(Reading reading);
}
