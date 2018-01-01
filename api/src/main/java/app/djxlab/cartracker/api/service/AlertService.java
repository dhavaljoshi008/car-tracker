/**
 * AlertService.java
 * app.djxlab.cartracker.api.service 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.service;

import java.util.List;

import app.djxlab.cartracker.api.entity.Alert;
import app.djxlab.cartracker.api.model.AlertDTO;

public interface AlertService {

	public Alert insert(Alert alert);
	
	public List<Alert> findAllAlerts();
	
	public List<Alert> findAllAlertsForVehicle(String vin);
	
	public List<Alert> findAllAlertsByCategory(String category);
	
	public List<Alert> findAllAlertsByCategoryForVehicle(String category, String vin);
	
	public List<Alert> findAllAlertsByPriority(String priority);
	
	public void triggerEngineRpmAlert(AlertDTO alertDTO);
	
	public void triggerFuelVolumeAlert(AlertDTO alertDTO);
	
	public void triggerTirePressureAlert(AlertDTO alertDTO);
	
	public void triggerEngineCoolantLowAlert(AlertDTO alertDTO);
	
	public void triggerCheckEngineLightOnAlert(AlertDTO alertDTO);
}
