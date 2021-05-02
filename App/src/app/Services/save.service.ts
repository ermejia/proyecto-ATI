import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SaveService {

  baseUrl = '/ClinicaWeb-1.0-SNAPSHOT';
  urlPatient = '/crudPatients';
  urlAppoint = '/crudAppointments';
  urlDiagnostic = '/crudDiagnostic';

  constructor(private http:HttpClient) { }

  createPatient(patient: Object): Observable<Object>{
    return this.http.post(`${this.baseUrl+this.urlPatient}`, patient);
  }

  createAppoint(appoint: Object): Observable<Object>{
    return this.http.post(`${this.baseUrl+this.urlAppoint}`, appoint);
  }

  createDiagnostic(diagnostic: Object): Observable<Object>{
    return this.http.post(`${this.baseUrl+this.urlDiagnostic}`, diagnostic);
  }

}
