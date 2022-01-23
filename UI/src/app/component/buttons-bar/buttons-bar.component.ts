import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {faArrowCircleRight, faRedo} from "@fortawesome/free-solid-svg-icons";
import {QuizState} from "../../model/quiz-state";

@Component({
  selector: 'app-buttons-bar',
  templateUrl: './buttons-bar.component.html',
  styleUrls: ['./buttons-bar.component.css']
})
export class ButtonsBarComponent implements OnInit, OnChanges {
  @Output() nextClick = new EventEmitter();
  @Output() restart = new EventEmitter();
  @Input() currentState!: QuizState;
  @Input() nextButtonDisabled!: boolean;
  faCircleRight = faArrowCircleRight;
  faRedo = faRedo;
  quizState = QuizState;

  constructor() {
  }

  ngOnChanges(changes: SimpleChanges): void {
  }

  ngOnInit(): void {
  }

  toNextQuestion() {
    this.nextClick.emit();
  }

  restartQuiz() {
    this.restart.emit();
  }
}
