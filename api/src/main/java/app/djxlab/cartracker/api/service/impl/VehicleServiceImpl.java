/**
 * VehicleServiceImpl.java
 * app.djxlab.cartracker.api.service.impl 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import app.djxlab.cartracker.api.entity.Vehicle;
import app.djxlab.cartracker.api.repository.VehicleRepository;
import app.djxlab.cartracker.api.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{

	private VehicleRepository vehicleRepository;
	
	public VehicleServiceImpl(VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}
	
	@Override
	public Vehicle save(Vehicle vehicle) {
		generateVehicleDocumentId(vehicle);
		return vehicleRepository.save(vehicle);
	}
	
	@Override
	public List<Vehicle> save(List<Vehicle> vehicles) {
		for(Vehicle vehicle: vehicles) {
			generateVehicleDocumentId(vehicle);
		}
		return vehicleRepository.save(vehicles);
	}
	
	// Generate custom id for the vehicle document.
	private void generateVehicleDocumentId(Vehicle vehicle) {
		StringBuilder idBuilder = new StringBuilder();
		idBuilder.append("vehicle_").append(vehicle.getVin());
		vehicle.setId(idBuilder.toString());	
	}
	
	@Override
	public Vehicle findOneVehicle(String vin) {
		return vehicleRepository.findOneVehicle(vin);
	}

	@Override
	public List<Vehicle> findAllVehicles() {
		return vehicleRepository.findAllVehicles();
	}
}
