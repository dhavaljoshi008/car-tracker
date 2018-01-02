/**
 * AlertRepository.java
 * app.djxlab.cartracker.api.repository 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import app.djxlab.cartracker.api.entity.Alert;

public interface AlertRepository extends MongoRepository<Alert, String> {

	@Query("{'type' : 'alert'}")
	public List<Alert> findAllAlerts();
	
	@Query("{'type' : 'alert', 'vin' : ?0}")
	public List<Alert> findAllAlertsForVehicle(String vin);
	
	@Query("{'type' : 'alert', 'category' : ?0}")
	public List<Alert> findAllAlertsByCategory(String category);
	
	@Query("{'type' : 'alert', 'category' : ?0, 'vin' : ?1}")
	public List<Alert> findAllAlertsByCategoryForVehicle(String category, String vin);
	
	@Query("{'type' : 'alert', 'priority' : ?0}")
	public List<Alert> findAllAlertsByPriority(String priority);
	
	@Query("{'type' : 'alert', 'priority' : ?0, 'vin' : ?1}")
	public List<Alert> findAllAlertsByPriorityForVehicle(String priority, String vin);
}
