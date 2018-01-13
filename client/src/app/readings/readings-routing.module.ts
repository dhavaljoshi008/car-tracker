import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

import { ReadingsComponent } from './readings.component';

const ROUTES: Routes = [
  { path: '', component: ReadingsComponent }
];

@NgModule({
  imports: [RouterModule.forChild(ROUTES)],
  exports: [RouterModule]
})

export class ReadingsRoutingModule { }
