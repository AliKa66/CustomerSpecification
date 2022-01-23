import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {Question} from "../../model/question";
import {AnsweredQuestion} from "../../model/answeredQuestion";

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit, OnChanges {
  @Input()
  question!: Question;
  @Output() checkAnswer = new EventEmitter<AnsweredQuestion>();
  buttonsDisabled!: boolean;

  constructor() {
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log(changes);
    if (changes['question']) {
      this.buttonsDisabled = false;
    }
  }

  ngOnInit(): void {
  }

  onClick(answer: string) {
    const answeredQuestion: AnsweredQuestion = {question: this.question.question, answer};
    this.checkAnswer.emit(answeredQuestion);
    this.buttonsDisabled = true;
  }
}
