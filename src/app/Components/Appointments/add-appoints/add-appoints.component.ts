import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Appoint } from 'src/app/Model/Appoint';
import { SaveService } from 'src/app/Services/save.service';

@Component({
  selector: 'app-add-appoints',
  templateUrl: './add-appoints.component.html',
  styleUrls: ['./add-appoints.component.css']
})
export class AddAppointsComponent implements OnInit {

  appoint: Appoint = new Appoint();
  submitted = false;
  alert: boolean = false;

  constructor(private router: Router, private saveAppoint:SaveService) { }

  ngOnInit(): void {
  }

  newAppoint(): void {
    this.submitted = false;
    this.appoint = new Appoint();
  }

  save(): void{
    this.saveAppoint
    .createAppoint(this.appoint).subscribe(data => {
      this.appoint = new Appoint();
    });this.alert=true;
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(["listAppointments"]);
  }

}
