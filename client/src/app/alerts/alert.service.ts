import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { catchError } from 'rxjs/operators/catchError';
import { of } from 'rxjs/observable/of';

import { Alert } from './alert';

@Injectable()
export class AlertService { 

  private alertsUrl: string;
  
  private host = 'localhost';

  private port = '9999';

  private basePath = 'api/alerts';

  constructor(private http: HttpClient) {
    this.alertsUrl = `http://${this.host}:${this.port}/${this.basePath}`;
   }

   // Get all alerts for all vehicles.
   getAllAlerts(): Observable<Alert[]> {
    return this.http.get<Alert[]>(this.alertsUrl)
      .pipe(
        catchError<Alert[], Alert[]>(this.handleError('getAllAlerts', []))
      )
   }

   // Get all alerts by priority for a particular vehicle identified by vin.
   getAllAlertsByPriorityForVehicle(priority: string, vin: string): Observable<Alert[]> {
     return this.http.get<Alert[]>(`${this.alertsUrl}/priority/${priority}/vehicle/${vin}`)
     .pipe(
       catchError<Alert[], Alert[]>(this.handleError('getAllAlertsByPriorityForVehicle', []))
     )
   }

   private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      console.error(error); 
  
      console.log(`${operation} failed: ${error.message}`);
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}