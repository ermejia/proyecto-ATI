import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Diagnostic } from 'src/app/Model/Diagnostic';
import { ListService } from 'src/app/Services/list.service';
import { SaveService } from 'src/app/Services/save.service';

@Component({
  selector: 'app-add-diagnostic',
  templateUrl: './add-diagnostic.component.html',
  styleUrls: ['./add-diagnostic.component.css']
})
export class AddDiagnosticComponent implements OnInit {

  diagnostic: Diagnostic = new Diagnostic();
  submitted = false;
  alert: boolean = false;

  constructor(private router: Router, private service: SaveService, private dataService: ListService) { }

  ngOnInit(): void {
  }

  newDiagnostic(): void {
    this.submitted = false;
    this.diagnostic = new Diagnostic();
  }

  save() {
    this.service
    .createDiagnostic(this.diagnostic).subscribe(data => {
      this.diagnostic = new Diagnostic();
      this.gotoList();
    });
    this.alert = true;
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(["addDiagnostic"]);
  }

}
