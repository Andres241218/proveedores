import { Question } from "./Question";

export interface Category{
    categoryId?:number;
    categoryName?:String;
    questions?:Question[] | null; 

}


