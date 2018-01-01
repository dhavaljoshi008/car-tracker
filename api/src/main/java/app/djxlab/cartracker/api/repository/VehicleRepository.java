/**
 * VehicleRepository.java
 * app.djxlab.cartracker.api.repository 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import app.djxlab.cartracker.api.entity.Vehicle;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {
	
	@Query("{'type' : 'vehicle', 'vin' : ?0 }")
	public Vehicle findOneVehicle(String vin);
}
