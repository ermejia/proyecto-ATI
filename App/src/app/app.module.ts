import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListPatientComponent } from './Components/Patients/list-patient/list-patient.component';
import { AddPatientComponent } from './Components/Patients/add-patient/add-patient.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { EditPatientComponent } from './Components/Patients/edit-patient/edit-patient.component';
import { ListAppointsComponent } from './Components/Appointments/list-appoints/list-appoints.component';
import { EditAppointsComponent } from './Components/Appointments/edit-appoints/edit-appoints.component';
import { AddAppointsComponent } from './Components/Appointments/add-appoints/add-appoints.component';
import { AddDiagnosticComponent } from './Components/Diagnostic/add-diagnostic/add-diagnostic.component';

@NgModule({
  declarations: [
    AppComponent,
    ListPatientComponent,
    AddPatientComponent,
    EditPatientComponent,
    ListAppointsComponent,
    EditAppointsComponent,
    AddAppointsComponent,
    AddDiagnosticComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
