import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GenericResponse } from '../models/generic-response';
import { Observable } from 'rxjs';
import { Question } from '../models/Question';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  private apiUrl = 'http://localhost:8085/api/questions'; 

  constructor(private http: HttpClient) { }
//metodo get api url para traer todos los proveedores
  getAllQuestion(): Observable<GenericResponse> {
    return this.http.get<GenericResponse>(this.apiUrl);
  }
//metodo get api url para buscar un proveedore
  searchQuestion(nameOrNit: string): Observable<GenericResponse> {
    return this.http.get<GenericResponse>(`${this.apiUrl}/search`, {
      params: { nameOrNit } 
    });
  }
  //metodo get api url para traer un proveedor por id
  getQuestionById(id: number): Observable<GenericResponse> {
    return this.http.get<GenericResponse>(`${this.apiUrl}/${id}`);
  }

  // Método para agregar un nuevo proveedor
  addQuestion(question: Question): Observable<GenericResponse> {
    return this.http.post<GenericResponse>(this.apiUrl, question);
  }
}
