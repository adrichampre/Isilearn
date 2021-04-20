import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LessonsPageComponent } from './lessons-page/lessons-page.component';
import { PracticePageComponent } from './practice-page/practice-page.component';
import {HttpClientModule} from "@angular/common/http";
import {LessonService} from "./services/lesson.service";
import {CommonModule} from "@angular/common";
import { LessonPageComponent } from './lesson-page/lesson-page.component';
import { WordPageComponent } from './word-page/word-page.component';
import {PracticeService} from "./services/practice.service";
import {ReactiveFormsModule} from "@angular/forms";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    LessonsPageComponent,
    PracticePageComponent,
    LessonPageComponent,
    WordPageComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        CommonModule,
        ReactiveFormsModule,
        BrowserAnimationsModule
    ],
  providers: [
    LessonService,
    PracticeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
