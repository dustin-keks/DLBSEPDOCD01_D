import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Home } from './home';
import { StudienkursService } from '../../service/studienkurs';
import { Student } from '../../model/student';
import { of } from 'rxjs';

describe('Home', () => {
  let component: Home;
  let fixture: ComponentFixture<Home>;

  beforeEach(async () => {
    const mockStudenten: Student[] = [
      {
        id: 1,
        name: 'Maximilian Mustermann',
        studienkurs: {
          id: 1,
          name: 'Toller Kurs',
          kuerzel: 'TK',
          tutor: {
            id: 1,
            name: 'Professor Müller',
            email: 'mueller@test.de'
          }
        }
      }, {
        id: 2,
        name: 'Jonathan Doe',
        studienkurs: {
          id: 2,
          name: 'Noch ein toller Kurs',
          kuerzel: 'TK2',
          tutor: {
            id: 2,
            name: 'Professor Schmitt',
            email: 'professor.schmitt@beispiel.de'
          }
        }
      }
    ];

    const mockService = {
      getAllStudienkurse: vi.fn().mockReturnValue(of([])),
      getAllStudents: vi.fn().mockReturnValue(of(mockStudenten))
    }

    await TestBed.configureTestingModule({
      imports: [Home],
      providers: [{
        provide: StudienkursService,
        useValue: mockService
      }]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Home);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('getStudentsByStudienskursId() should return students of the given studienkurs', () => {
    const result = component.getStudentsByStudienkursId(1);
    expect(result.length).toBe(1);
    expect(result[0].name).toBe('Maximilian Mustermann');
  });

  it('getStudentsByStudienkursId() should return empty array when no students match', () => {
    const result = component.getStudentsByStudienkursId(999);
    expect(result.length).toBe(0);
  });
});
