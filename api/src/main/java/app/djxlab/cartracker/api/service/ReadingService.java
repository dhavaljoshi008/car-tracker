/**
 * ReadingService.java
 * app.djxlab.cartracker.api.service 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.service;

import java.util.Date;
import java.util.List;

import app.djxlab.cartracker.api.entity.Reading;

public interface ReadingService {

	public Reading insert(Reading reading);
	
	public List<Reading> findAllReadings();
	
	public List<Reading> findAllReadingsForVehicle(String vin);
	
	public List<Reading> findAllReadingsUptoTimestampForVehicle(Date fromTimestamp, Date uptoTimestamp, String vin);
}
