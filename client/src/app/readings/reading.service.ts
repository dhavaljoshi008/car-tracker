import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { catchError } from 'rxjs/operators/catchError';
import { of } from 'rxjs/observable/of';

import { Reading } from './reading';
 
@Injectable()
export class ReadingService {

  private readingsUrl: string;

  private host = 'localhost';
  
  private port = 9999;
  
  private basePath = 'api/readings';

  constructor(private http: HttpClient) {
    this.readingsUrl = `http://${this.host}:${this.port}/${this.basePath}`;
   }

   // Get all readings for all vehicles.
   getAllReadings(): Observable<Reading[]> {
     return this.http.get(this.readingsUrl)
      .pipe(
        catchError<Reading[], Reading[]>(this.handleError('getAllReadings', []))
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
