import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { VehicleService } from '../vehicles/vehicle.service';

import { Vehicle } from '../vehicles/vehicle';

@Component({
  selector: 'app-vehicle-detail',
  templateUrl: './vehicle-detail.component.html',
  styleUrls: ['./vehicle-detail.component.css']
})
export class VehicleDetailComponent implements OnInit {

  vin: string;

  vehicle: Vehicle;

  constructor(private route: ActivatedRoute, private vehicleService: VehicleService) { 
  
  }

  ngOnInit() {
    this.vin = this.route.snapshot.paramMap.get('vin');
    this.getVehicle(this.vin)
  }

  getVehicle(vin: string): void {
    this.vehicleService.getVehicle(this.vin)
      .subscribe(vehicle => this.vehicle = vehicle);
  }
}
