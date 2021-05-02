import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Patients } from 'src/app/Model/Patients';
import { ListService } from 'src/app/Services/list.service';


@Component({
  selector: 'app-list-patient',
  templateUrl: './list-patient.component.html',
  styleUrls: ['./list-patient.component.css']
})

  export class ListPatientComponent implements OnInit {
    patients!: Observable<Patients[]>;
  
    constructor(private service:ListService, private router:Router) { }
  
    ngOnInit(): void {
      this.reloadData();
    }
  
    reloadData() {
      this.patients = this.service.getPatients();
    }
  
    AddPatient(){
      this.router.navigate(["add-patients"]);
    }
  
    EditPatient(id:number){
      this.router.navigate(["edit-patients", id]);
    }

}
