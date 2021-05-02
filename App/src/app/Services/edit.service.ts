import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patients } from '../Model/Patients';

@Injectable({
  providedIn: 'root'
})
export class EditService {

  baseUrl = '/ClinicaWeb-1.0-SNAPSHOT';
  urlPatientId = '/getPatient?id=';
  urlUpdatePatient = '/updatePatient';
  urlUpdateAppoint = '/updateAppointment';

  constructor(private http:HttpClient) { }


  updatePatient(patient: Object): Observable<Object>{
    return this.http.post(`${this.baseUrl+this.urlUpdatePatient}`, patient);
  }

  updateAppoint(appoint: Object): Observable<Object>{
    return this.http.post(`${this.baseUrl+this.urlUpdateAppoint}`, appoint);
  }

}
