import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from '../models/generic-response';
import { Category } from '../models/Category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private apiUrl = 'http://localhost:8085/api/category'; 

  constructor(private http: HttpClient) { }
//metodo get api url para traer todos los proveedores
  getAllCategory(): Observable<GenericResponse> {
    return this.http.get<GenericResponse>(this.apiUrl);
  }
//metodo get api url para buscar un proveedore
  searchCategory(nameOrNit: string): Observable<GenericResponse> {
    return this.http.get<GenericResponse>(`${this.apiUrl}/search`, {
      params: { nameOrNit } 
    });
  }
  //metodo get api url para traer un proveedor por id
  getCategoryById(id: number): Observable<GenericResponse> {
    return this.http.get<GenericResponse>(`${this.apiUrl}/${id}`);
  }

  // Método para agregar un nuevo proveedor
  addCategory(category: Category): Observable<GenericResponse> {
    return this.http.post<GenericResponse>(this.apiUrl, category);
  }
}
