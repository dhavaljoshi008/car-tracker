import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { CustomPreloader } from './utils/custom-preloader';

const ROUTES: Routes = [
  { 
    path: 'vehicles', 
    loadChildren: 'app/vehicles/vehicles.module#VehiclesModule',
    data: { preload: true }
  },
  {
    path: 'readings',
    loadChildren: 'app/readings/readings.module#ReadingsModule',
    data: { preload: true }
  },
  {
    path: 'alerts',
    loadChildren: 'app/alerts/alerts.module#AlertsModule',
    data: { preload: true }
  }
];

@NgModule({
  imports: [RouterModule.forRoot(ROUTES, { preloadingStrategy: CustomPreloader })],
  exports: [RouterModule],
  providers: [CustomPreloader]
})

export class AppRoutingModule { }
