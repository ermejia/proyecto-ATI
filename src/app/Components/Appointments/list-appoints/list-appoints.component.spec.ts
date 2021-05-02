import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListAppointsComponent } from './list-appoints.component';

describe('ListAppointsComponent', () => {
  let component: ListAppointsComponent;
  let fixture: ComponentFixture<ListAppointsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListAppointsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListAppointsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
