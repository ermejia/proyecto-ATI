import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Appoint } from 'src/app/Model/Appoint';
import { EditService } from 'src/app/Services/edit.service';
import { ListService } from 'src/app/Services/list.service';

@Component({
  selector: 'app-edit-appoints',
  templateUrl: './edit-appoints.component.html',
  styleUrls: ['./edit-appoints.component.css']
})
export class EditAppointsComponent implements OnInit {

  id!: number;
  public appoint!: Appoint[];
  appoints: Appoint = new Appoint();
  alertUpdate: boolean = false;


  constructor(private route: ActivatedRoute, private router: Router, private appointService: ListService,
    private updateAppoint: EditService) { }

    ngOnInit(){
      this.appointService.getAppoint(this.route.snapshot.params.id).subscribe((result)=>{
        this.appoint = result;
      })
    }
  
    save() {
      this.updateAppoint
        .updateAppoint(this.appoint).subscribe(data => {
          this.gotoList();
        });
        this.alertUpdate = true;
      }
  
    onSubmit(){
      this.save();
    }
  
    gotoList() {
      this.router.navigate(["listAppointments"]);
      }
}
