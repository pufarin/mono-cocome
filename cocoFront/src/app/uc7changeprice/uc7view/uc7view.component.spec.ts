import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Uc7viewComponent } from './uc7view.component';

describe('Uc7viewComponent', () => {
  let component: Uc7viewComponent;
  let fixture: ComponentFixture<Uc7viewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Uc7viewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Uc7viewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
