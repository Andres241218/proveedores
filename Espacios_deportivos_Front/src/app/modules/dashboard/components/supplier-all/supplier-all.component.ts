import { Component } from '@angular/core';
import { SuppliersService } from '../../services/suppliers.service';
import { GenericResponse } from '../../models/generic-response';
import { CommonModule } from '@angular/common';
import { Supplier } from '../../models/Supplier';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-supplier-all',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './supplier-all.component.html',
  styleUrl: './supplier-all.component.scss'
})
export class SupplierAllComponent {

   supplierAll: Supplier[]=[];
   searchTerm: string = '';
   supplier:Supplier | undefined;
   message: string='';
  constructor(private suppliersService: SuppliersService) { }

  ngOnInit(): void {
    this.loadSuppliers();
  }
//Metodo para trader todos los datos del backend de Proveedores
  loadSuppliers(): void {
    this.suppliersService.getAllSuppliers().subscribe(
      (data: GenericResponse) => {
        this.supplierAll = data.data;
        this.message=data.message;
        console.log(data);
      },
      (error) => {
        console.error('Error fetching suppliers:', error);
      }
    );
  }
  //Metodo para buscar un proveedor por su NIT o Nombre
  searchSupplier(): void {
    this.suppliersService.searchSupplier(this.searchTerm).subscribe(
      (data: GenericResponse) => {
        this.supplier = data.data;
        this.message=data.message;
      },
      (error) => {
        console.error('Error fetching supplier:', error);
      }
    );
  }
}
