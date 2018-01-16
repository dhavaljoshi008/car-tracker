import { Component, OnInit, OnChanges, SimpleChanges, Input } from '@angular/core';

import { AlertService } from '../alerts/alert.service';

import { Alert } from '../alerts/alert';

@Component({
  selector: 'historical-alerts-chart',
  templateUrl: './historical-alerts-chart.component.html',
  styleUrls: ['./historical-alerts-chart.component.css']
})
export class HistoricalAlertsChartComponent implements OnInit, OnChanges {

  @Input()
  highPriorityAlerts: Alert[];

  @Input()
  mediumPriorityAlerts: Alert[];

  @Input()
  lowPriorityAlerts: Alert[];

  // Doughnut
  doughnutChartLabels: string[];
  doughnutChartData: number[];
  doughnutChartType: string = 'doughnut';

  title: string;

  constructor(private alertService: AlertService) { 
    this.title = 'Total Alerts';
    this.doughnutChartLabels = ['High Priority', 'Medium Priority', 'Low Priority'];
    this.doughnutChartData = [0, 0, 0];
  }

  ngOnInit() {

  }

  ngOnChanges(changes: SimpleChanges): void {
    // Update doughnut chart after data for all the alerts arrives.
    if((this.highPriorityAlerts != undefined) && (this.mediumPriorityAlerts != undefined) && (this.lowPriorityAlerts != undefined)) {
      this.doughnutChartData = [this.highPriorityAlerts.length, this.mediumPriorityAlerts.length, this.lowPriorityAlerts.length];
    }
  }

  chartClicked(e: any): void {
    console.log(e);
  }
  
  chartHovered(e: any): void {
      console.log(e);
  }
}
