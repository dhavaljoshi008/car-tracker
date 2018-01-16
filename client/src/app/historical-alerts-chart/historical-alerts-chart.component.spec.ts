import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HistoricalAlertsChartComponent } from './historical-alerts-chart.component';

describe('HistoricalAlertsChartComponent', () => {
  let component: HistoricalAlertsChartComponent;
  let fixture: ComponentFixture<HistoricalAlertsChartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HistoricalAlertsChartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HistoricalAlertsChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
