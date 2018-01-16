import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VehiclesRoutingModule } from './vehicles-routing.module';
import { ChartsModule } from 'ng2-charts';

import { VehiclesComponent } from './vehicles.component';
import { VehicleDetailComponent } from '../vehicle-detail/vehicle-detail.component';
import { HistoricalAlertsChartComponent } from '../historical-alerts-chart/historical-alerts-chart.component';

@NgModule({
  imports: [
    CommonModule,
    VehiclesRoutingModule,
    ChartsModule
  ],
  declarations: [VehiclesComponent, VehicleDetailComponent, HistoricalAlertsChartComponent]
})

export class VehiclesModule { }
