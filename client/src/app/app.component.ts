import { Component } from '@angular/core';
import { MenuItem } from './utils/menu-item'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  appTitle: string;
  menuItems: MenuItem[];

  constructor() {
    this.appTitle = 'Car Tracker';
    this.menuItems = [
      { caption: 'Vehicles', link: '/vehicles' },
      { caption: 'Readings', link: '/readings' },
      { caption: 'Alerts', link: '/alerts' }
    ];
  }
}
