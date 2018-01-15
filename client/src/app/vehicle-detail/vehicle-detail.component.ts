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

  vehicle: Vehicle;

  constructor(private route: ActivatedRoute, private vehicleService: VehicleService) { 
  
  }

  ngOnInit() {
    this.getVehicle(this.route.snapshot.paramMap.get('vin'));
  }

  getVehicle(vin: string): void {
    this.vehicleService.getVehicle(vin)
      .subscribe(vehicle => this.vehicle = vehicle);
  }
}
