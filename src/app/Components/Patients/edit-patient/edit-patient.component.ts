import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patients } from 'src/app/Model/Patients';
import { DeleteService } from 'src/app/Services/delete.service';
import { EditService } from 'src/app/Services/edit.service';
import { ListService } from 'src/app/Services/list.service';
import { SaveService } from 'src/app/Services/save.service';

@Component({
  selector: 'app-edit-patient',
  templateUrl: './edit-patient.component.html',
  styleUrls: ['./edit-patient.component.css']
})
export class EditPatientComponent implements OnInit {

  dpi!: number;
  public patient!: Patients[];
  patients: Patients = new Patients();
  alertUpdate: boolean = false;
  alertDelete: boolean = false;

  constructor(private route: ActivatedRoute, private router: Router, private updatePatient: EditService,
    private getPatientId: ListService, private deleteService:DeleteService) { }

    ngOnInit(){
      this.getPatientId.getPatient(this.route.snapshot.params.id).subscribe((result)=>{
        this.patient = result;
      })}
  
    save() {
      this.updatePatient
        .updatePatient(this.patient).subscribe(data => {
          this.gotoList();
        });
        this.alertUpdate=true;
      }
  
    onSubmit(){
      this.save();
    }
  
    deletePatient() {
      this.deleteService
        .deletePatient(this.patient).subscribe(data => {
          this.gotoList();
        });
        this.alertDelete=true;
      }
  
  
    gotoList() {
      this.router.navigate(["list-patients"]);
    }
}
