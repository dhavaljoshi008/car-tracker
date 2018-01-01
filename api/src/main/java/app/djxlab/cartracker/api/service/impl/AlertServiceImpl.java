/**
 * AlertServiceImpl.java
 * app.djxlab.cartracker.api.service.impl 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import app.djxlab.cartracker.api.constant.Constants;
import app.djxlab.cartracker.api.entity.Alert;
import app.djxlab.cartracker.api.entity.AlertFactory;
import app.djxlab.cartracker.api.model.AlertDTO;
import app.djxlab.cartracker.api.repository.AlertRepository;
import app.djxlab.cartracker.api.service.AlertService;

@Service
public class AlertServiceImpl implements AlertService {

	private AlertRepository alertRepository;
	
	public AlertServiceImpl(AlertRepository alertRepository) {
		this.alertRepository = alertRepository;
	}
		
	@Override
	public Alert insert(Alert alert) {
		return alertRepository.insert(alert);
	}
	
	@Override
	public List<Alert> findAllAlerts() {
		return alertRepository.findAllAlerts();
	}
	
	@Override
	public List<Alert> findAllAlertsForVehicle(String vin) {
		return alertRepository.findAllAlertsForVehicle(vin);
	}

	@Override
	public void triggerEngineRpmAlert(AlertDTO alertDTO) {
		Alert alert = AlertFactory.build(Constants.ALERT_ENGINE_RPM, alertDTO);
		alertRepository.insert(alert);	
	}

	@Override
	public void triggerFuelVolumeAlert(AlertDTO alertDTO) {
		Alert alert = AlertFactory.build(Constants.ALERT_FUEL_VOLUME, alertDTO);
		alertRepository.insert(alert);
	}

	@Override
	public void triggerTirePressureAlert(AlertDTO alertDTO) {
		Alert alert = AlertFactory.build(Constants.ALERT_TIRE_PRESSURE, alertDTO);
		alertRepository.insert(alert);
	}

	@Override
	public void triggerEngineCoolantLowAlert(AlertDTO alertDTO) {
		Alert alert = AlertFactory.build(Constants.ALERT_ENGINE_COOLANT_LOW, alertDTO);
		alertRepository.insert(alert);
	}

	@Override
	public void triggerCheckEngineLightOnAlert(AlertDTO alertDTO) {
		Alert alert = AlertFactory.build(Constants.ALERT_CHECK_ENGINE_LIGHT_ON, alertDTO);
		alertRepository.insert(alert);
	}
}