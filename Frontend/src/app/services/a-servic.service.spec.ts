import { TestBed } from '@angular/core/testing';

import { AServicService } from './a-servic.service';

describe('AServicService', () => {
  let service: AServicService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AServicService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
