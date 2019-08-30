import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Uc3viewComponent } from './uc3view.component';

describe('Uc3viewComponent', () => {
  let component: Uc3viewComponent;
  let fixture: ComponentFixture<Uc3viewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Uc3viewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Uc3viewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
