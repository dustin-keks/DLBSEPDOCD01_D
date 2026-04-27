import { TestBed } from '@angular/core/testing';

import { StudienkursService } from './studienkurs';
import { HttpTestingController, provideHttpClientTesting } from '@angular/common/http/testing';
import { provideHttpClient } from '@angular/common/http';
import { Student } from '../model/student';
import { Studienkurs } from '../model/studienkurs';

describe('Studienkurs', () => {
  let service: StudienkursService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        provideHttpClient(),
        provideHttpClientTesting()
      ]
    });
    service = TestBed.inject(StudienkursService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('getAllStudienkurse() should call GET /api/studienkurse', () => {
    const mockData: Studienkurs[] = [{
      id: 50,
      name: 'Python programmieren',
      kuerzel: 'PP',
      tutor: {
        id: 51,
        name: 'Professor Muster',
        email: 'abc@test.de'
      }
    }];

    service.getAllStudienkurse().subscribe(result => {
      expect(result.length).toBe(1);
      expect(result[0].name).toBe('Python programmieren');
    });

    const req = httpMock.expectOne('http://localhost:8080/api/studienkurse');
    expect(req.request.method).toBe('GET');
    req.flush(mockData);
  });

  it('getAllStudents() should call GET /api/studenten', () => {
    const mockData: Student[] = [{
      id: 60,
      name: 'Max Mustermann',
      studienkurs: {
        id: 61,
        name: 'Continuous Integration and Continuous Delivery',
        kuerzel: 'CI/CD',
        tutor: {
          id: 62,
          name: 'Professor Doe',
          email: 'j.doe@iu.de'
        }
      }
    }];

    service.getAllStudents().subscribe(result => {
      expect(result.length).toBe(1);
      expect(result[0].name).toBe('Max Mustermann');
    });

    const req = httpMock.expectOne('http://localhost:8080/api/studenten');
    expect(req.request.method).toBe('GET');
    req.flush(mockData);
  });
});
