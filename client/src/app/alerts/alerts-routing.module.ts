import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

import { AlertsComponent } from './alerts.component';

const ROUTES: Routes= [
  { path: '', component: AlertsComponent}
];

@NgModule({
  imports: [RouterModule.forChild(ROUTES)],
  exports: [RouterModule]
})

export class AlertsRoutingModule { }
