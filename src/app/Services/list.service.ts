import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Patients} from '../Model/Patients';
import { Appoint } from '../Model/Appoint';

@Injectable({
  providedIn: 'root'
})
export class ListService {

  baseUrl = '/ClinicaWeb-1.0-SNAPSHOT';
  urlPatient = '/crudPatients';
  urlPatientId = '/getPatient?id=';
  urlAppoint = '/crudAppointments';
  urlAppointId = '/getAppointment?id=';

  constructor(private http:HttpClient) { }
  
  getPatients(): Observable<Patients[]>{
    return this.http.get<Patients[]>(this.baseUrl+this.urlPatient);
  }

  getPatient(id: number): Observable<any> {
    return this.http.get<Patients>(`${this.baseUrl}${this.urlPatientId}${id}`);
  }

  getAppoints(): Observable<Appoint[]>{
    return this.http.get<Appoint[]>(this.baseUrl+this.urlAppoint);
  }

  getAppoint(id: number): Observable<any> {
    return this.http.get<Appoint>(`${this.baseUrl}${this.urlAppointId}${id}`);
  }
}

