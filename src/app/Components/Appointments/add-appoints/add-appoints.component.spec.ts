import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAppointsComponent } from './add-appoints.component';

describe('AddAppointsComponent', () => {
  let component: AddAppointsComponent;
  let fixture: ComponentFixture<AddAppointsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddAppointsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddAppointsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
