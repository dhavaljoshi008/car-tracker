/**
 * VehicleController.java
 * app.djxlab.cartracker.api.controller 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	// Upsert a particular vehicle.
    @CrossOrigin(origins = "http://mocker.egen.io")
	@RequestMapping(value = "/vehicle", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Vehicle putVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.save(vehicle);
	}
	
    // Upsert all vehicles.
    @CrossOrigin(origins = "http://mocker.egen.io")
	@RequestMapping(value = "/vehicles", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Vehicle> putVehicles(@RequestBody List<Vehicle> vehicles) {
		return vehicleService.save(vehicles);
	}
    
    // Get a particular vehicle identified by vin.
    @RequestMapping(value = "/vehicle/{vin}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle getVehicle(@PathVariable String vin) {
    		return vehicleService.findOneVehicle(vin);
    }
    
    // Get all vehicles.
    @RequestMapping(value = "/vehicles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> getAllVehicles() {
    		return vehicleService.findAllVehicles();
    }
}
