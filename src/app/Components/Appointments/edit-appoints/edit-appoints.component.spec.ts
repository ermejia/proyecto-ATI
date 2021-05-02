import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditAppointsComponent } from './edit-appoints.component';

describe('EditAppointsComponent', () => {
  let component: EditAppointsComponent;
  let fixture: ComponentFixture<EditAppointsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditAppointsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditAppointsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
