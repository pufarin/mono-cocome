import { TestBed } from '@angular/core/testing';

import { Uc7serviceService } from './uc7service.service';

describe('Uc7serviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: Uc7serviceService = TestBed.get(Uc7serviceService);
    expect(service).toBeTruthy();
  });
});
