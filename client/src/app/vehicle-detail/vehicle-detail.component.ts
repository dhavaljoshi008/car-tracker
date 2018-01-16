import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { VehicleService } from '../vehicles/vehicle.service';
import { AlertService } from '../alerts/alert.service';

import { Vehicle } from '../vehicles/vehicle';
import { Alert } from '../alerts/alert';

@Component({
  selector: 'app-vehicle-detail',
  templateUrl: './vehicle-detail.component.html',
  styleUrls: ['./vehicle-detail.component.css']
})
export class VehicleDetailComponent implements OnInit {

  vehicle: Vehicle;

  highPriorityAlerts: Alert[];

  mediumPriorityAlerts: Alert[];
  
  lowPriorityAlerts: Alert[];

  tester: number;

  constructor(private route: ActivatedRoute, private vehicleService: VehicleService, private alertService: AlertService) { 
  
  }

  ngOnInit() {
    let vin = this.route.snapshot.paramMap.get('vin');
    this.getVehicle(vin);
    this.getHighPriorityAlertsForVehicle(vin);
    this.getMediumPriorityAlertsForVehicle(vin);
    this.getLowPriorityAlertsForVehicle(vin);
  }

  getVehicle(vin: string): void {
    this.vehicleService.getVehicle(vin)
      .subscribe(vehicle => this.vehicle = vehicle);
  }

  getHighPriorityAlertsForVehicle(vin: string): void {
    this.alertService.getAllAlertsByPriorityForVehicle('high', vin)
       .subscribe(alerts => this.highPriorityAlerts = alerts);
  }

  getMediumPriorityAlertsForVehicle(vin: string): void {
    this.alertService.getAllAlertsByPriorityForVehicle('medium', vin)
      .subscribe(alerts => this.mediumPriorityAlerts = alerts);
  }

  getLowPriorityAlertsForVehicle(vin: string): void {
    this.alertService.getAllAlertsByPriorityForVehicle('low', vin)
      .subscribe(alerts => this.lowPriorityAlerts = alerts);
  }
}
