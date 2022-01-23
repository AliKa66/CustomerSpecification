import {Component} from '@angular/core';
import {Question} from "./model/question";
import {QuizState} from "./model/quiz-state";
import {QuestionService} from "./service/question.service";
import {AnsweredQuestion} from "./model/answeredQuestion";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'UI';
  quizState = QuizState;

  currentState = QuizState.UNTOUCHED;
  questions: Question[] | undefined;
  question: Question | undefined;
  answerIsCorrect: boolean | undefined;
  totalCorrect = 0;
  totalIncorrect = 0;
  nextButtonDisabled = true;

  constructor(private service: QuestionService) {
  }


  fetchQuestions() {
    this.resetCounters();
    this.nextButtonDisabled = true;
    this.service
      .getQuestions()
      .subscribe(response => {
        this.questions = response;
        this.toNextQuestion();
        this.setState(QuizState.PLAYING);
      });
  }

  toNextQuestion() {
    if (this.questions?.length == 0) {
      this.setState(QuizState.END);
    } else {
      this.nextButtonDisabled = true;
      this.question = this.questions?.pop();
    }
  }

  setState(state: QuizState) {
    this.currentState = state;
  }

  checkAnswer(event: AnsweredQuestion) {
    this.nextButtonDisabled = false;
    this.service
      .checkAnswer(event)
      .subscribe(res => {
        this.answerIsCorrect = res;
        res ? this.totalCorrect++ : this.totalIncorrect++;
      });
  }

  private resetCounters() {
    this.totalIncorrect = 0;
    this.totalCorrect = 0;
  }
}
