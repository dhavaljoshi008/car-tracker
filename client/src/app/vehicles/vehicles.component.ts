import { Component, OnInit } from '@angular/core';
import { VehicleService } from './vehicle.service';
import { Vehicle } from './vehicle';

@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class VehiclesComponent implements OnInit {

  tableHeadings: string[];

  vehicles: Vehicle[];

  constructor(private vehicleService: VehicleService) {
    this.tableHeadings = ['#', 'VIN', 'Make', 'Model', 'Year','RedlineRpm', 'MaxFuelVolume', 'LastServiceDate'];
   }

  ngOnInit() {
    this.getAllVehicles();
  }

  getAllVehicles(): void {
    this.vehicleService.getAllVehicles()
    .subscribe(vehicles => {
      this.vehicles = vehicles;
    });
  }
}
