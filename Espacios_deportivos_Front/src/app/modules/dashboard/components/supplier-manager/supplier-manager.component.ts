import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { SupplierEvaluationComponent } from '../supplier-evaluation/supplier-evaluation.component';
import { SuppliersService } from '../../services/suppliers.service';
import { Supplier } from '../../models/Supplier';
import { GenericResponse } from '../../models/generic-response';
import { Evaluation } from '../../models/Evaluation';
/*
interface Supplier {
  name: string;
  nit: string;
  type: string;
  category: string;
  predecessor: string;
  evaluate: string;
}

interface Evaluation {
  executor: string;
  date: string;
  rating: number;
  predecessor: string;
  supplier: string;
}*/

@Component({
  selector: 'app-supplier-manager',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule], // Importing FormsModule for ngModel
  templateUrl: './supplier-manager.component.html',
  styleUrls: ['./supplier-manager.component.scss']
})
export class SupplierManagerComponent implements OnInit {
  supplierInput: string = '';
  supplierInfo: Supplier | null = null;
  evaluations: Evaluation[] =[];
  statusMessage: string = '';
  supplierAll: Supplier[]=[];
  suppliersList:Supplier[]=[];
  displayedMessage: string='';

  constructor(private router: Router,private suppliersService: SuppliersService) {}

  ngOnInit(): void {
    //this.updateStatus('SupplierManager initialized. Start typing to search for a supplier.');
  }
  goToSupplierEvaluation(supplierInfo:Supplier) {
    if (supplierInfo) {
      this.router.navigate(['/supplier-evaluation'], {
        queryParams: {
          name: supplierInfo.suppliersName,
          nit: supplierInfo.suppliersNit,
          type: supplierInfo.suppliersType,
          category: supplierInfo.categoryName?.categoryName,
          predecessor: supplierInfo.predecessorId
        }
      });
    }
  }

//Metodo para buscar proveedores desde los datos del back end
searchSupplier(): void {
  const searchTerm = this.supplierInput.toLowerCase().trim();
  this.updateStatus(`Searching for: ${searchTerm}`);

  this.suppliersService.getAllSuppliers().subscribe(
    (response: GenericResponse) => {
      const suppliers: Supplier[] = response.data; 

      console.log(suppliers[0].categoryName?.categoryName)
      const matchedSuppliers = suppliers.filter(supplier =>
        supplier.suppliersName.toLowerCase().includes(searchTerm) ||
        supplier.suppliersNit.includes(searchTerm)
      );

      if (searchTerm && matchedSuppliers.length > 0) {
        this.updateSupplierInfo(matchedSuppliers); 
        matchedSuppliers.forEach(supplier => this.updateEvaluations(supplier)); 
      } else {
        this.clearSupplierInfo();
        this.clearEvaluations();
      }
    },
    (error) => {
      console.error('Error fetching suppliers:', error);
      this.clearSupplierInfo();
      this.clearEvaluations();
    }
  );
}

 /*
  searchSupplier(): void {
    const searchTerm = this.supplierInput.toLowerCase().trim();
    this.updateStatus(`Searching for: ${searchTerm}`);

    
    // Mock data - replace with actual API call in a real application
    const suppliers: Supplier[] = [
      {
        name: 'Sample Supplier',
        nit: '123456789',
        type: 'Type A',
        category: 'Category B',
        predecessor: 'Predecessor C',
        evaluate: 'evaluate'
      },
      {
        name: 'medium Supplier',
        nit: '1234567890',
        type: 'Type C',
        category: 'Category B',
        predecessor: 'Predecessor A',
        evaluate: 'evaluate'
      },
      {
        name: 'Another Supplier',
        nit: '987654321',
        type: 'Type B',
        category: 'Category A',
        predecessor: 'Predecessor D',
        evaluate: 'evaluate'
      }
    ];
    
    const matchedSupplier = suppliers.find(supplier =>
      supplier.name.toLowerCase().includes(searchTerm) ||
      supplier.nit.includes(searchTerm)
    );

    if (searchTerm && matchedSupplier) {
      this.updateSupplierInfo(matchedSupplier);
      this.updateEvaluations(matchedSupplier);
    } else {
      this.clearSupplierInfo();
      this.clearEvaluations();
    }
  }
*/
updateSupplierInfo(suppliers: Supplier[]): void {
  // Asignar la lista de proveedores a una propiedad del componente
  this.suppliersList = suppliers;

  // Si estás usando un componente de plantilla, podrías tener una propiedad como 'suppliersList' para mostrar la lista
  if (suppliers.length > 0) {
    this.displayedMessage = `${suppliers.length} suppliers found:`;
  } else {
    this.displayedMessage = 'No suppliers found.';
  }
}

  updateEvaluations(supplier: Supplier): void {
    // Mock data - replace with actual API call in a real application
    this.evaluations = supplier.evaluations ??[];
    this.updateStatus(`Evaluations updated for: ${supplier.suppliersName}`);
  }

  clearSupplierInfo(): void {
    this.supplierInfo = null;
    this.updateStatus('Supplier info cleared');
  }

  clearEvaluations(): void {
    this.evaluations = [];
    this.updateStatus('Evaluations cleared');
  }

  updateStatus(message: string): void {
    this.statusMessage = message;
    setTimeout(() => {
      this.statusMessage = '';
    }, 3000);
  }
}
