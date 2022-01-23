import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  @Output() isClicked = new EventEmitter();

  constructor() {
  }

  ngOnInit(): void {
  }

  onClick(btn: HTMLInputElement) {
    this.isClicked.emit();
    btn.disabled = true;
  }
}
