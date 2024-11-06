import { Category } from "./Category";
import { Evaluation } from "./Evaluation";

export interface Supplier {
    suppliersId: number;      
    suppliersNit: string;
    suppliersName: string;    
    suppliersPhone?: string; 
    suppliersAddress?: string; 
    suppliersType?: string;  
    predecessorId?: any;   
    categoryName?: Category;  
    evaluations?: Evaluation[] ;  
}