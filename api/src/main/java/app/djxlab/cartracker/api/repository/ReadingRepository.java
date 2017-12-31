/**
 * ReadingRepository.java
 * app.djxlab.cartracker.api.repository 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.djxlab.cartracker.api.entity.Reading;

public interface ReadingRepository extends MongoRepository<Reading, String> {

}
