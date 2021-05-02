import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Appoint } from 'src/app/Model/Appoint';
import { ListService } from 'src/app/Services/list.service';

@Component({
  selector: 'app-list-appoints',
  templateUrl: './list-appoints.component.html',
  styleUrls: ['./list-appoints.component.css']
})
export class ListAppointsComponent implements OnInit {
  appointments!: Observable<Appoint[]>;

  constructor(private service:ListService, private router:Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.appointments = this.service.getAppoints();
  }

  AddAppoint(){
    this.router.navigate(["add-appoint"]);
  }

  EditAppoint(id: number){
    this.router.navigate(["edit-appoint", id]);
  }

}
