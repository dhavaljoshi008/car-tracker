import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VehiclesRoutingModule } from './vehicles-routing.module';

import { VehiclesComponent } from './vehicles.component';

@NgModule({
  imports: [
    CommonModule,
    VehiclesRoutingModule
  ],
  declarations: [VehiclesComponent]
})

export class VehiclesModule { }
