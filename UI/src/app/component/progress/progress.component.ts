import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-progress',
  templateUrl: './progress.component.html',
  styleUrls: ['./progress.component.css']
})
export class ProgressComponent implements OnInit, OnChanges {
  @Input() correctCount!: number;
  @Input() incorrectCount!: number;
  incorrectValue: number = 0;
  correctValue: number = 0;

  constructor() {
  }

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['incorrectCount']) {
      this.incorrectValue = changes['incorrectCount'].currentValue * 20;
    }

    if (changes['correctCount']) {
      this.correctValue = changes['correctCount'].currentValue * 20;
    }
  }
}
