import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

import { VehiclesComponent } from './vehicles.component';
import { VehicleDetailComponent } from '../vehicle-detail/vehicle-detail.component';

const ROUTES: Routes = [
  { 
    path: '', 
    component: VehiclesComponent
  },

  { 
    path: ':vin', 
    component: VehicleDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(ROUTES)],
  exports: [RouterModule],
})

export class VehiclesRoutingModule { }
