/**
 * VehicleService.java
 * app.djxlab.cartracker.api.service 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.service;

import java.util.List;

import app.djxlab.cartracker.api.entity.Vehicle;

public interface VehicleService {

	public Vehicle save(Vehicle vehicle);
	
	public List<Vehicle> save(List<Vehicle> vehicles); 
	
	public Vehicle findOneVehicle(String vin);
}
