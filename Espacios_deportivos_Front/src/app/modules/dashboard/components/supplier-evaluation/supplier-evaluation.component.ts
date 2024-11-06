import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { QuestionService } from '../../services/question.service';
import { Question } from '../../models/Question';
import { GenericResponse } from '../../models/generic-response';


@Component({
  selector: 'app-supplier-evaluation',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './supplier-evaluation.component.html',
  styleUrls: ['./supplier-evaluation.component.scss']
})
export class SupplierEvaluationComponent implements OnInit {
  // Provider Information
  providerName: string = '';
  providerNit: string = '';
  providerType: string = '';
  providerCategory: string = '';
  providerPredecessor: string = '';
  selectedOption: string = '';
  errorMessage: string = '';
  message: string = '';
  // Evaluation Details
  options: string[] = ['Opcion 1', 'Opcion 2', 'Opcion 3', 'Opcion 4'];
  evaluationCriteria: string = 'Criterios de Evaluación';
   
  // Questions and Stars
  questions: Question[] = [];
  stars: number[] = [1, 2, 3, 4, 5];
  rating: number=0;
  applies: boolean =true;

  constructor(private route: ActivatedRoute,private questionService: QuestionService) {
    
  }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.providerName = params['name'] || '';
      this.providerNit = params['nit'] || '';
      this.providerType = params['type'] || '';
      this.providerCategory = params['category'] || '';
      this.providerPredecessor = params['predecessor'] || '';
    });
    this.initializeQuestions();
  }

  // Getters for counts
  get responseCount(): number {
    return this.questions.filter(q => this.rating > 0).length;
  }

  get totalQuestions(): number {
    return this.questions.length;
  }

  private initializeQuestions(): void {
    this.questionService.getAllQuestion().subscribe(
      (data: GenericResponse) => {
        this.questions = data.data;
        this.message=data.message;
        console.log(data);
      },
      (error) => {
        console.error('Error fetching suppliers:', error);
      }
    );
  }
  

 rate(question: Question, rating: number): void {
    if (this.applies) {
      this.rating = rating;
    }
  }
  
  isStarActive(question: Question, star: number): boolean {
    return this.applies && this.rating >= star;
  }

  saveEvaluation(): void {
    if (this.validateEvaluation()) {
      console.log('Saving evaluation...', {
        provider: {
          name: this.providerName,
          nit: this.providerNit,
          type: this.providerType,
          category: this.providerCategory,
          predecessor: this.providerPredecessor
        },
        selectedOption: this.selectedOption,
        questions: this.questions
      });
      // Add your API call or service method here
      this.errorMessage = 'GOOD JOB!!';
    } else {
      this.errorMessage = 'Please complete all required fields';
      console.log('Please complete all required fields');
      // Add your error handling here
    }
  }

  private validateEvaluation(): boolean {
    return this.applies && this.rating > 0
  }
}
