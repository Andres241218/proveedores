import { Category } from "./Category";
import { Question } from "./Question";

export interface Evaluation {
    id?: number;
    date?: Date;
    rating?: number;
    category?: Category | null; 
    questionId?: Question | null; 
    


}