/**
 * VehicleController.java
 * app.djxlab.cartracker.api.controller 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.djxlab.cartracker.api.entity.Vehicle;
import app.djxlab.cartracker.api.service.VehicleService;

@RestController
public class VehicleController {

	private VehicleService vehicleService;
	
	public VehicleController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}
	
	@RequestMapping(value = "/vehicle", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Vehicle putVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.save(vehicle);
	}
	
	@RequestMapping(value = "/vehicles", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Vehicle> putVehicles(@RequestBody List<Vehicle> vehicles) {
		return vehicleService.save(vehicles);
	}
}
