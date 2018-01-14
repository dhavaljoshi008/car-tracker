import { Component, OnInit } from '@angular/core';
import { AlertService } from './alert.service';

@Component({
  selector: 'app-alerts',
  templateUrl: './alerts.component.html',
  styleUrls: ['./alerts.component.css']
})
export class AlertsComponent implements OnInit {

  constructor(private alertService: AlertService) {

   }

  ngOnInit() {
  }

  getAllAlerts(): void {
    this.alertService.getAllAlerts()
      .subscribe(alerts => console.log(alerts));
  }
}