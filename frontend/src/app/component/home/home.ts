import { Component, inject } from '@angular/core';
import { Studienkurs } from '../../model/studienkurs';
import { Student } from '../../model/student';
import { StudienkursService } from '../../service/studienkurs';
import { toSignal } from '@angular/core/rxjs-interop';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.html',
  styleUrl: './home.scss',
})
export class Home {
  private studienkursService = inject(StudienkursService);

  studienkurse = toSignal(this.studienkursService.getAllStudienkurse(), {
    initialValue: [] as Studienkurs[]
  });

  studenten = toSignal(this.studienkursService.getAllStudents(), {
    initialValue: [] as Student[]
  });

  getStudentsByStudienkursId(studienkursId: number): Student[] {
    return this.studenten().filter(student => student.studienkurs.id === studienkursId);
  }
}
