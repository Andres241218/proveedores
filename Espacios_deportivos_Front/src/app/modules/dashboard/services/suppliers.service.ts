// suppliers.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GenericResponse } from '../models/generic-response';
import { Supplier } from '../models/Supplier';

@Injectable({
  providedIn: 'root'
})
export class SuppliersService {

  private apiUrl = 'http://localhost:8085/api/suppliers'; 

  constructor(private http: HttpClient) { }
//metodo get api url para traer todos los proveedores
  getAllSuppliers(): Observable<GenericResponse> {
    return this.http.get<GenericResponse>(this.apiUrl);
  }
//metodo get api url para buscar un proveedore
  searchSupplier(nameOrNit: string): Observable<GenericResponse> {
    return this.http.get<GenericResponse>(`${this.apiUrl}/search`, {
      params: { nameOrNit } 
    });
  }
  //metodo get api url para traer un proveedor por id
  getSupplierById(id: number): Observable<GenericResponse> {
    return this.http.get<GenericResponse>(`${this.apiUrl}/${id}`);
  }

  // Método para agregar un nuevo proveedor
  addSupplier(supplier: Supplier): Observable<GenericResponse> {
    return this.http.post<GenericResponse>(this.apiUrl, supplier);
  }
}

