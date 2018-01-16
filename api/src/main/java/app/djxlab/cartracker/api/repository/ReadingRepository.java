/**
 * ReadingRepository.java
 * app.djxlab.cartracker.api.repository 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import app.djxlab.cartracker.api.entity.Reading;

public interface ReadingRepository extends MongoRepository<Reading, String> {
	
	@Query("{'type' : 'reading'}")
	public List<Reading> findAllReadings();
	
	@Query("{'type' : 'reading', 'vin' : ?0}")
	public List<Reading> findAllReadingsForVehicle(String vin);
	
	@Query("{'type' : 'reading', 'timestamp' : {$gte : ?0, $lte : ?1}, 'vin' : ?2}")
	public List<Reading> findAllReadingsUptoTimestampForVehicle(Date fromTimestamp, Date uptoTimestamp, String vin);
}
