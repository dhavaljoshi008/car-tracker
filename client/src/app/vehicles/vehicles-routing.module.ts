import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

import { VehiclesComponent } from './vehicles.component';

const ROUTES: Routes = [
  { path: '', component: VehiclesComponent }
];

@NgModule({
  imports: [RouterModule.forChild(ROUTES)],
  exports: [RouterModule],
})

export class VehiclesRoutingModule { }
