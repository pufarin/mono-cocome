import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Uc5viewComponent } from './uc5view.component';

describe('Uc5viewComponent', () => {
  let component: Uc5viewComponent;
  let fixture: ComponentFixture<Uc5viewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Uc5viewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Uc5viewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
