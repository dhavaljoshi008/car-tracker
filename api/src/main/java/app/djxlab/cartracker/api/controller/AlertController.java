/**
 * AlertController.java
 * app.djxlab.cartracker.api.controller 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.djxlab.cartracker.api.entity.Alert;
import app.djxlab.cartracker.api.service.AlertService;

@RestController
public class AlertController {

	private AlertService alertService;
	
	public AlertController(AlertService alertService) {
		this.alertService = alertService;
	}
	
	// Get all alerts.
	@RequestMapping(value = "/alerts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Alert> getAllAlerts() {
		return alertService.findAllAlerts();
	}
	
	// Get all alerts for a particular vehicle identified by vin.
	@RequestMapping(value = "/alerts/{vin}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Alert> getAllAlertsForVehicle(@PathVariable String vin) {
		return alertService.findAllAlertsForVehicle(vin);
	}
}
