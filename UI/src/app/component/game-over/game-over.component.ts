import {Component, Input, OnInit} from '@angular/core';
import {faCheck, faTimes } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-game-over',
  templateUrl: './game-over.component.html',
  styleUrls: ['./game-over.component.css']
})
export class GameOverComponent implements OnInit {
  @Input() totalCorrect!: number;
  @Input() totalIncorrect!: number;
  faTimes = faTimes;
  faCheck = faCheck;

  constructor() { }

  ngOnInit(): void {
  }

}
