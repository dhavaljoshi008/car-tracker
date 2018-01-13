import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReadingsRoutingModule } from './readings-routing.module';

import { ReadingsComponent } from './readings.component';

@NgModule({
  imports: [
    CommonModule,
    ReadingsRoutingModule
  ],
  declarations: [ReadingsComponent]
})
export class ReadingsModule { }
