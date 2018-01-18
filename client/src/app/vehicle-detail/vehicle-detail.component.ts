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

  mapReadings: Reading[];

  signalReadings: Reading[];

  mapUptoTimestamp: number;

  signalUptoTimestamp: number;

  mapPastMinutes: number[];

  signalPastMinutes: number[];

  signalTypes: string[];

  currentSignalType: string;

  markers: Marker[];

  signalLabels: Array<any>;

  signalData: Array<any>;

  signalTypeMap = new Map<string, string>();

  constructor(private route: ActivatedRoute, private vehicleService: VehicleService, private alertService: AlertService, private readingService: ReadingService) { 
    this.mapPastMinutes = [15, 30, 60, 90, 120];
    this.mapUptoTimestamp = this.mapPastMinutes[0]; // Default mapUptoTimestamp.
    this.markers = [];
    
    this.signalTypes = ['Engine RPM', 'Engine HP', 'EngineCoolant Low', 'CheckEngineLight On', 'Fuel Volume', 'Speed', 'CruiseControl On'];
    this.currentSignalType = this.signalTypes[0]; // Default signal.
    this.signalPastMinutes = [15, 30, 60, 90, 120];
    this.signalUptoTimestamp = this.signalPastMinutes[0]; // Default signalUptoTimestamp.
    this.signalLabels = [];
    this.signalData = [];

    this.signalTypeMap.set(this.signalTypes[0], 'engineRpm');
    this.signalTypeMap.set(this.signalTypes[1], 'engineHp');
    this.signalTypeMap.set(this.signalTypes[2], 'engineCoolantLow');
    this.signalTypeMap.set(this.signalTypes[3], 'checkEngineLightOn');
    this.signalTypeMap.set(this.signalTypes[4], 'fuelVolume');
    this.signalTypeMap.set(this.signalTypes[5], 'speed');
    this.signalTypeMap.set(this.signalTypes[6], 'cruiseControlOn');
  }

  ngOnInit() {
    // Vehicle info.
    let vin = this.route.snapshot.paramMap.get('vin');
    this.getVehicle(vin);

    // Total Alerts.
    this.getHighPriorityAlertsForVehicle(vin);
    this.getMediumPriorityAlertsForVehicle(vin);
    this.getLowPriorityAlertsForVehicle(vin);

    // Signal History.
    let now = new Date();
    if(this.mapUptoTimestamp == this.signalUptoTimestamp) {
      // Initialize map and signal readings with same uptoTimestamp.
      this.getAllReadingsUptoTimestampForVehicle(this.calculateBeginingTimestamp(now, this.mapUptoTimestamp), now.toISOString(), vin);
    } 
    else {
      // Initialize map readings with  mapUptoTimestamp.
      this.getAllReadingsUptoTimestampForVehicle(this.calculateBeginingTimestamp(now, this.mapUptoTimestamp), now.toISOString(), vin);
      this.mapReadings = this.readings;
      // Initialize signal readings with  signalUptoTimestamp.
      this.getAllReadingsUptoTimestampForVehicle(this.calculateBeginingTimestamp(now, this.signalUptoTimestamp), now.toISOString(), vin);
      this.signalReadings = this.readings;
    }
  }

  setMapUptoTimestamp(value: number) {
    this.mapUptoTimestamp = value;
    let now = new Date();
    this.getAllReadingsUptoTimestampForVehicle(this.calculateBeginingTimestamp(now, this.mapUptoTimestamp), now.toISOString(), this.vehicle.vin, 'map');
  }

  setSignalUptoTimestamp(value: number) {
    this.signalUptoTimestamp = value;
    let now = new Date();
    this.getAllReadingsUptoTimestampForVehicle(this.calculateBeginingTimestamp(now, this.signalUptoTimestamp), now.toISOString(), this.vehicle.vin, 'signal');
  }

  setCurrentSignalType(type: string) {
    this.currentSignalType = type;
    this.populateSignalDataAndLabels(this.signalReadings, type);
  }

  refreshMap() {
    let now = new Date();
    this.getAllReadingsUptoTimestampForVehicle(this.calculateBeginingTimestamp(now, this.mapUptoTimestamp), now.toISOString(), this.vehicle.vin, 'map');
  }

  refreshSignalChart() {
    let now = new Date();
    this.getAllReadingsUptoTimestampForVehicle(this.calculateBeginingTimestamp(now, this.signalUptoTimestamp), now.toISOString(), this.vehicle.vin, 'signal');
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

  // Calculate begining timestamp. Default value = 15.
  calculateBeginingTimestamp(uptoTimestamp: Date = new Date(), minutesBefore: number = 15): string {
    let fromTimestamp = moment(uptoTimestamp).subtract(minutesBefore, 'm');
    return fromTimestamp.toISOString();
  }

  // Get all readings upto timestamp for a vehicle identified by vin. readingsFor is optional (e.g. 'map' for map readings, 'signal' for signal readings.)
  getAllReadingsUptoTimestampForVehicle(fromTimestamp: string, uptoTimestamp: string, vin: string, readingsFor?: string): void {
    this.readingService.getAllReadingsUptoTimestampForVehicle(fromTimestamp,uptoTimestamp, vin)
    .subscribe(readings => {
      this.readings = readings;
      if(readingsFor) { 
        if(readingsFor.toLowerCase() == 'map') {
          this.mapReadings = this.readings;
          this.populateMapMarkers(this.mapReadings);
        }
        else if(readingsFor.toLowerCase() == 'signal') {
          this.signalReadings = this.readings;
          this.populateSignalDataAndLabels(this.signalReadings, this.currentSignalType);
        } 
      }
      else {
        this.populateMapMarkers(this.readings);
        this.populateSignalDataAndLabels(this.readings, this.currentSignalType);
      }
    });
  }

  // Clear old markers.
  cleartMapMarkers() {
    this.markers = [];
  }

  // Clear old signal data and labels.
  clearSignalDataAndLabels() {
    this.signalData = [];
    this.signalLabels = [];
  }

  // Populate map markers.
  populateMapMarkers(mapReadings: Reading[]) {

    // Clear old markers.
    this.cleartMapMarkers();

    for(let reading of this.readings) {
      this.markers.push({latitude: reading.latitude, longitude: reading.longitude, label: `Lat: ${reading.latitude}, Lng: ${reading.longitude}`, draggable: false});
    }
  }

  // Populate signal data and labels.
  populateSignalDataAndLabels(signalReadings: Reading[], signalType: string) {

    // Clear old signal data and labels.
    this.clearSignalDataAndLabels();
  
    for(let signalReading of signalReadings) {
        this.signalData.push(signalReading[this.signalTypeMap.get(signalType)]);
        this.signalLabels.push(new Date(signalReading.timestamp).toLocaleTimeString());
    }
  }
}
