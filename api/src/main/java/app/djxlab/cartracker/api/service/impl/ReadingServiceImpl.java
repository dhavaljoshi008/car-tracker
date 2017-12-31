/**
 * ReadingServiceImpl.java
 * app.djxlab.cartracker.api.service.impl 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.service.impl;

import org.springframework.stereotype.Service;

import app.djxlab.cartracker.api.entity.Reading;
import app.djxlab.cartracker.api.repository.ReadingRepository;
import app.djxlab.cartracker.api.service.ReadingService;

@Service
public class ReadingServiceImpl implements ReadingService {

	private ReadingRepository readingRepository;
	
	public ReadingServiceImpl(ReadingRepository readingRepository) {
		this.readingRepository = readingRepository;
	}
	
	@Override
	public Reading insert(Reading reading) {
		return readingRepository.insert(reading);
	}

}
