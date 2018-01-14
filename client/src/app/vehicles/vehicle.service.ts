import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs/observable/of';

import { Vehicle } from './vehicle';



@Injectable()
export class VehicleService {

  private vehiclesUrl;

  private host = 'localhost';

  private port = 9999;

  private basePath = 'api/vehicles';

  constructor(private http: HttpClient) {
    this.vehiclesUrl = `http://${this.host}:${this.port}/${this.basePath}`;
   }

   // Get all vehicles.
   getAllVehicles(): Observable<Vehicle[]> {
     return this.http.get<Vehicle[]>(this.vehiclesUrl)
        .pipe(
          catchError<Vehicle[], Vehicle[]>(this.handleError('getVehicles', []))
        )
   }

   // Error handler.
   private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      console.error(error); 
  
      console.log(`${operation} failed: ${error.message}`);
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}