import { Component, OnInit } from '@angular/core';
import { VehicleService } from './vehicle.service';

@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class VehiclesComponent implements OnInit {

  constructor(private vehicleService: VehicleService) { }

  ngOnInit() {
  }
  
  getAllVehicles(): void {
    this.vehicleService.getAllVehicles()
    .subscribe(vehicles => console.log(vehicles));
  }
}
