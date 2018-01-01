/**
 * BusinessServiceImpl.java
 * app.djxlab.cartracker.api.service.impl 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.service.impl;

import org.springframework.stereotype.Service;

import app.djxlab.cartracker.api.constant.Constants;
import app.djxlab.cartracker.api.entity.Reading;
import app.djxlab.cartracker.api.entity.Tires;
import app.djxlab.cartracker.api.entity.Vehicle;
import app.djxlab.cartracker.api.model.AlertDTO;
import app.djxlab.cartracker.api.service.AlertService;
import app.djxlab.cartracker.api.service.BusinessService;
import app.djxlab.cartracker.api.service.VehicleService;

@Service
public class BusinessServiceImpl implements BusinessService {

	private VehicleService vehicleService;
	
	private AlertService alertService;
	
	public BusinessServiceImpl(VehicleService vehicleService, AlertService alertService) {
		this.vehicleService = vehicleService;
		this.alertService = alertService;
	}

	@Override
	public void analyzeEngineRpmFromReading(Reading reading) {
		Vehicle vehicle = vehicleService.findOneVehicle(reading.getVin());
		int engineRpm = reading.getEngineRpm();
		int redlineRpm = vehicle.getRedlineRpm();
		
		if(engineRpm > redlineRpm) {
			AlertDTO alertDTO = new AlertDTO();
			alertDTO.setVin(vehicle.getVin());
			alertDTO.setMake(vehicle.getMake());
			alertDTO.setModel(vehicle.getModel());
			alertDTO.setEngineRpm(engineRpm);
			alertDTO.setRedlineRpm(redlineRpm);
		
			alertService.triggerEngineRpmAlert(alertDTO);
		}
	}

	@Override
	public void analyzeFuelVolumeFromReading(Reading reading) {
		Vehicle vehicle = vehicleService.findOneVehicle(reading.getVin());
		double fuelVolume = reading.getFuelVolume();
		double maxFuelVolume = vehicle.getMaxFuelVolume();
		double fuelThresholdPercent = Constants.FUEL_THRESHOLD_PERCENT;
		
		if(fuelVolume < (fuelThresholdPercent * maxFuelVolume)) {
			AlertDTO alertDTO = new AlertDTO();
			alertDTO.setVin(vehicle.getVin());
			alertDTO.setMake(vehicle.getMake());
			alertDTO.setModel(vehicle.getModel());
			alertDTO.setFuelVolume(fuelVolume);
			alertDTO.setMaxFuelVolume(maxFuelVolume);
			
			alertService.triggerFuelVolumeAlert(alertDTO);
		}
	}

	@Override
	public void analyzeTirePressureFromReading(Reading reading) {
		Vehicle vehicle = vehicleService.findOneVehicle(reading.getVin());

		Tires tires = reading.getTires();
		double tirePressureLowThreshold = Constants.TIRE_PRESSURE_LOW_THRESHOLD;
		double tirePresssureHighThreshold = Constants.TIRE_PRESSURE_HIGH_THRESHOLD;
		
		double frontLeft = tires.getFrontLeft();
		double frontRight = tires.getFrontRight();
		double rearLeft = tires.getRearLeft();
		double rearRight = tires.getRearRight();
		
		double[] tireArray = {frontLeft, frontRight , rearLeft, rearRight};
		
		for(Double tirePressure: tireArray) {
			if(tirePressure < tirePressureLowThreshold || tirePressure > tirePresssureHighThreshold) {
				
				AlertDTO alertDTO = new AlertDTO();
				alertDTO.setVin(vehicle.getVin());
				alertDTO.setMake(vehicle.getMake());
				alertDTO.setModel(vehicle.getModel());
				alertDTO.setTires(tires);
				
				alertService.triggerTirePressureAlert(alertDTO);
				break;
			}
		}	
	}

	@Override
	public void analyzeEngineCoolantLowFromReading(Reading reading) {
		Vehicle vehicle = vehicleService.findOneVehicle(reading.getVin());

		boolean engineCoolantLow = reading.isEngineCoolantLow();
		
		if(engineCoolantLow) {
			AlertDTO alertDTO = new AlertDTO();
			alertDTO.setVin(vehicle.getVin());
			alertDTO.setMake(vehicle.getMake());
			alertDTO.setModel(vehicle.getModel());
			alertDTO.setEngineCoolantLow(engineCoolantLow);
			
			alertService.triggerEngineCoolantLowAlert(alertDTO);;
		}
	}

	@Override
	public void analyzeCheckEngineLightOnFromReading(Reading reading) {
		Vehicle vehicle = vehicleService.findOneVehicle(reading.getVin());

		boolean checkEngineLightOn = reading.isCheckEngineLightOn();
		
	
		
		if(checkEngineLightOn) {
			AlertDTO alertDTO = new AlertDTO();
			alertDTO.setVin(vehicle.getVin());
			alertDTO.setMake(vehicle.getMake());
			alertDTO.setModel(vehicle.getModel());
			alertDTO.setCheckEngineLightOn(checkEngineLightOn);
			
			alertService.triggerCheckEngineLightOnAlert(alertDTO);
		}
	}
}
