import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddAppointsComponent } from './Components/Appointments/add-appoints/add-appoints.component';
import { EditAppointsComponent } from './Components/Appointments/edit-appoints/edit-appoints.component';
import { ListAppointsComponent } from './Components/Appointments/list-appoints/list-appoints.component';
import { AddDiagnosticComponent } from './Components/Diagnostic/add-diagnostic/add-diagnostic.component';
import { AddPatientComponent } from './Components/Patients/add-patient/add-patient.component';
import { EditPatientComponent } from './Components/Patients/edit-patient/edit-patient.component';
import { ListPatientComponent } from './Components/Patients/list-patient/list-patient.component';

const routes: Routes = [
  {path: 'list-patients', component:ListPatientComponent},
  {path: 'add-patients', component:AddPatientComponent},
  {path: 'edit-patients/:id', component:EditPatientComponent},
  {path: 'listAppointments', component:ListAppointsComponent},
  {path: 'add-appoint', component:AddAppointsComponent},
  {path: 'edit-appoint/:id', component:EditAppointsComponent},
  {path: 'addDiagnostic', component:AddDiagnosticComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
