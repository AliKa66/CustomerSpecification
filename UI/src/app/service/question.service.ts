import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Question} from "../model/question";
import {Observable} from "rxjs";
import {AnsweredQuestion} from "../model/answeredQuestion";

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  private baseUrl = "http://localhost:8080"

  constructor(private http: HttpClient) {

  }

  getQuestions(): Observable<Question[]> {
    const url = this.baseUrl + '/questions';
    const params = new HttpParams().set('amount', 5);
    return this.http
      .get<Question[]>(url, {params: params})
  }

  checkAnswer(question: AnsweredQuestion): Observable<boolean> {
    const url = this.baseUrl + '/checkanswer';
    return this.http
      .post<boolean>(url, question);
  }
}
