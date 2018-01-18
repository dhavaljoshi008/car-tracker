import { Component, OnInit, OnChanges, SimpleChanges, Input, ViewChild } from '@angular/core';
import { BaseChartDirective } from 'ng2-charts/ng2-charts';

@Component({
  selector: 'signal-chart',
  templateUrl: './signal-chart.component.html',
  styleUrls: ['./signal-chart.component.css']
})
export class SignalChartComponent implements OnInit, OnChanges {
  
  @ViewChild(BaseChartDirective) chart: BaseChartDirective;
 
  @Input() signalData: Array<any>;

  @Input() signalChartLabels: Array<any>;

  @Input() signalType: string;

  signalChartType: string;

  signalChartData: Array<any>;

  signalChartOptions: any;

  showLegend: boolean;

  constructor() {
    this.signalChartType = 'line';
    this.showLegend = true;
    this.signalChartLabels = [];
    this.signalChartData = [
      { data: [], label: '' },
    ];

    this.signalChartOptions = {
      responsive: true,
      legend: {
        labels: {
          fontColor: 'rgb(255, 99, 132)'
        }
      },
      showLines: true
    };
  }

  ngOnInit() {
    
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.signalChartData[0].data = this.signalData;
    this.signalChartData[0].label = this.signalType;

    // Update chart.
    setTimeout(() => {
      if (this.chart && this.chart.chart && this.chart.chart.config) {
        this.chart.chart.update();
      }
      }, 1000);
  }

  onChartClick(event) {
  }
}