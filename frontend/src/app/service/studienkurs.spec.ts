import { TestBed } from '@angular/core/testing';

import { StudienkursService } from './studienkurs';

describe('Studienkurs', () => {
  let service: StudienkursService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StudienkursService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
