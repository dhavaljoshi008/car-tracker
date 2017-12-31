/**
 * VehicleRepository.java
 * app.djxlab.cartracker.api.repository 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.djxlab.cartracker.api.entity.Vehicle;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {
	
}
