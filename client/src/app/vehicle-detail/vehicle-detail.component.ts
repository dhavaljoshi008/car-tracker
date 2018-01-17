import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { VehicleService } from '../vehicles/vehicle.service';
import { AlertService } from '../alerts/alert.service';

import { Vehicle } from '../vehicles/vehicle';
import { Alert } from '../alerts/alert';
import { Reading } from '../readings/reading';

import * as moment from 'moment';
import { ReadingService } from '../readings/reading.service';
import { Marker } from '../geolocation/marker';

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

  readings: Reading[];

  uptoTimestamp: number ;

  pastMinutes: number[];

  markers: Marker[];

  constructor(private route: ActivatedRoute, private vehicleService: VehicleService, private alertService: AlertService, private readingService: ReadingService) { 
    this.pastMinutes = [30, 60, 90, 120];
    this.uptoTimestamp = this.pastMinutes[0]; // Default uptoTimestamp;
    this.markers = [];
  }

  ngOnInit() {
    let vin = this.route.snapshot.paramMap.get('vin');
    this.getVehicle(vin);
    this.getHighPriorityAlertsForVehicle(vin);
    this.getMediumPriorityAlertsForVehicle(vin);
    this.getLowPriorityAlertsForVehicle(vin);
    let now = new Date();
    this.getAllReadingsUptoTimestampForVehicle(this.calculateBeginingTimestamp(now, this.uptoTimestamp), now.toISOString(), vin);
  }

  setUptoTimestamp(value: number) {
    this.uptoTimestamp = value;
    let now = new Date();
    this.getAllReadingsUptoTimestampForVehicle(this.calculateBeginingTimestamp(now, this.uptoTimestamp), now.toISOString(), this.vehicle.vin);
  }

  refreshMap() {
    let now = new Date();
    this.getAllReadingsUptoTimestampForVehicle(this.calculateBeginingTimestamp(now, this.uptoTimestamp), now.toISOString(), this.vehicle.vin);
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

  calculateBeginingTimestamp(uptoTimestamp: Date = new Date(), minutesBefore: number = 30): string {
    let fromTimestamp = moment(uptoTimestamp).subtract(minutesBefore, 'm');
    return fromTimestamp.toISOString();
  }

  getAllReadingsUptoTimestampForVehicle(fromTimestamp: string, uptoTimestamp: string, vin: string): void {
    this.readingService.getAllReadingsUptoTimestampForVehicle(fromTimestamp,uptoTimestamp, vin)
    .subscribe(readings => {
      this.readings = readings;
      for(let reading of this.readings) {
        this.markers.push({latitude: reading.latitude, longitude: reading.longitude, label: `Lat: ${reading.latitude}, Lng: ${reading.longitude}`, draggable: false});
      }
    });
  }
}
