import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VehiclesRoutingModule } from './vehicles-routing.module';
import { ChartsModule } from 'ng2-charts';
import { AgmCoreModule } from '@agm/core';

import { VehiclesComponent } from './vehicles.component';
import { VehicleDetailComponent } from '../vehicle-detail/vehicle-detail.component';
import { HistoricalAlertsChartComponent } from '../historical-alerts-chart/historical-alerts-chart.component';
import { GeolocationComponent } from '../geolocation/geolocation.component';
import { ApiKeys } from '../../config/api-keys';
import { SignalChartComponent } from '../signal-chart/signal-chart.component';

@NgModule({
  imports: [
    CommonModule,
    VehiclesRoutingModule,
    ChartsModule,
    AgmCoreModule.forRoot({
      apiKey: `${ApiKeys.googleMapsApiKey }`
    })
  ],
  declarations: [VehiclesComponent, VehicleDetailComponent, HistoricalAlertsChartComponent, GeolocationComponent, SignalChartComponent]
})

export class VehiclesModule { }
