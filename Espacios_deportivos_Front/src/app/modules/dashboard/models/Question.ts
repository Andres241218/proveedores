import { Category } from "./Category";

export interface Question {
    questionId?: number;
    question?: string;
    category?: Category | null; // Usar null si no siempre hay una categoría
}  