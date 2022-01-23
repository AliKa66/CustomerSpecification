import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {HomeComponent} from './component/home/home.component';
import {QuestionComponent} from './component/question/question.component';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {ProgressComponent} from './component/progress/progress.component';
import {ButtonsBarComponent} from './component/buttons-bar/buttons-bar.component';
import { GameOverComponent } from './component/game-over/game-over.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    QuestionComponent,
    ProgressComponent,
    ButtonsBarComponent,
    GameOverComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FontAwesomeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
