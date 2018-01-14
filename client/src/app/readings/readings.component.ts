import { Component, OnInit } from '@angular/core';
import { ReadingService } from './reading.service';

@Component({
  selector: 'app-readings',
  templateUrl: './readings.component.html',
  styleUrls: ['./readings.component.css']
})
export class ReadingsComponent implements OnInit {

  constructor(private readingService: ReadingService) { }

  ngOnInit() {
  }

  getAllReadings(): void {
    this.readingService.getAllReadings()
      .subscribe(readings => console.log(readings));
  }
}
