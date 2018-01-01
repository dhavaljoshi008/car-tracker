/**
 * ReadingServiceImpl.java
 * app.djxlab.cartracker.api.service.impl 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import app.djxlab.cartracker.api.entity.Reading;
import app.djxlab.cartracker.api.repository.ReadingRepository;
import app.djxlab.cartracker.api.service.BusinessService;
import app.djxlab.cartracker.api.service.ReadingService;

@Service
public class ReadingServiceImpl implements ReadingService {

	private ReadingRepository readingRepository;
	
	private BusinessService businessService;
	
	public ReadingServiceImpl(ReadingRepository readingRepository, BusinessService businessService) {
		this.readingRepository = readingRepository;
		this.businessService = businessService;
	}
	
	@Override
	public Reading insert(Reading reading) {
		Reading copyOfReading = new Reading(reading);
		executeBusinessLogic(copyOfReading); 
		return readingRepository.insert(reading);
	}
	
	private void executeBusinessLogic(Reading reading) {	
		businessService.analyzeEngineRpmFromReading(reading);
		businessService.analyzeFuelVolumeFromReading(reading);
		businessService.analyzeEngineCoolantLowFromReading(reading);
		businessService.analyzeCheckEngineLightOnFromReading(reading);
		businessService.analyzeTirePressureFromReading(reading);
	}

	@Override
	public List<Reading> findAllReadings() {
		return readingRepository.findAllReadings();
	}

	@Override
	public List<Reading> findAllReadingsForVehicle(String vin) {
		return readingRepository.findAllReadingsForVehicle(vin);
	}
}