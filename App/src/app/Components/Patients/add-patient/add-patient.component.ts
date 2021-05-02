import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patients } from 'src/app/Model/Patients';
import { SaveService } from 'src/app/Services/save.service';

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent implements OnInit {

  patient: Patients = new Patients();
  submitted = false;
  alert: boolean = false;

  constructor(private router: Router, private service: SaveService) { }

  ngOnInit(): void {
  }

  newPatient(): void {
    this.submitted = false;
    this.patient = new Patients();
  }

  save() {
    this.service
    .createPatient(this.patient).subscribe(data => {
      this.patient = new Patients();
      this.gotoList();
    });
    this.alert=true;
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(["list-patients"]);
  }

}
