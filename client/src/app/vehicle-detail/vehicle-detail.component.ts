import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-vehicle-detail',
  templateUrl: './vehicle-detail.component.html',
  styleUrls: ['./vehicle-detail.component.css']
})
export class VehicleDetailComponent implements OnInit {

  title: string
  
  vin: string;

  constructor(private route: ActivatedRoute) { 
    this.title = 'Vehicle Details';
  }

  ngOnInit() {
    this.vin = this.route.snapshot.paramMap.get('vin');
  }
}
