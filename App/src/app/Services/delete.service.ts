import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DeleteService {
  
  baseUrl = '/ClinicaWeb-1.0-SNAPSHOT';
  urlPatient = '/deletePatient';

  constructor(private http:HttpClient) { }

  deletePatient(patient: Object): Observable<any> {
    return this.http.post(`${this.baseUrl+this.urlPatient}`, patient);
  }
}
