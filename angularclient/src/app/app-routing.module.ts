import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LessonsPageComponent} from "./lessons-page/lessons-page.component";
import {LessonPageComponent} from "./lesson-page/lesson-page.component";
import {PracticePageComponent} from "./practice-page/practice-page.component";

const routes: Routes = [
  {path: 'lessons', component: LessonsPageComponent},
  {path: 'lesson/:id', component: LessonPageComponent},
  {path: 'practice', component: PracticePageComponent},
  {path: '', redirectTo: 'lessons', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
