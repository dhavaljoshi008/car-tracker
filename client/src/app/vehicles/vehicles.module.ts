import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VehiclesRoutingModule } from './vehicles-routing.module';

import { VehiclesComponent } from './vehicles.component';
import { VehicleDetailComponent } from '../vehicle-detail/vehicle-detail.component';

@NgModule({
  imports: [
    CommonModule,
    VehiclesRoutingModule
  ],
  declarations: [VehiclesComponent, VehicleDetailComponent]
})

export class VehiclesModule { }
