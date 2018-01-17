import { Component, OnInit, Input } from '@angular/core';

import { Marker } from './marker';

@Component({
  selector: 'geolocation',
  templateUrl: './geolocation.component.html',
  styleUrls: ['./geolocation.component.css']
})

export class GeolocationComponent implements OnInit {
  
  latitude: number
  longitude: number;
  zoom: number;

  @Input()
  markers: Marker[];

  constructor() {
    this.latitude = 37.09024;
    this.longitude = -95.712891;
    this.zoom = 3;
   }

  ngOnInit() {
  }
  
}
