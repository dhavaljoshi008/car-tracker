import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';

import { VehicleService } from './vehicles/vehicle.service';
import { ReadingService } from './readings/reading.service';
import { AlertService } from './alerts/alert.service';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [VehicleService, ReadingService, AlertService],
  bootstrap: [AppComponent]
})
export class AppModule { }
