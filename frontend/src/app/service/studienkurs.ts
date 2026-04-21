import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Studienkurs } from '../model/studienkurs';
import { Student } from '../model/student';

@Injectable({
  providedIn: 'root',
})
export class StudienkursService {
  private apiUrl = "http://localhost:8080/api";

  constructor(private http: HttpClient) {}

  getAllStudienkurse(): Observable<Studienkurs[]> {
    return this.http.get<Studienkurs[]>(`${this.apiUrl}/studienkurse`);
  }

  getAllStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(`${this.apiUrl}/studenten`);
  }
}
