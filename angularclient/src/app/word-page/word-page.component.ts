import {Component, Input, OnInit} from '@angular/core';
import {PracticeService} from "../services/practice.service";
import {Word} from "../models/word";

@Component({
  selector: 'app-word-page',
  templateUrl: './word-page.component.html',
  styleUrls: ['./word-page.component.css']
})
export class WordPageComponent implements OnInit {

  word: Word = new Word("","", "");

  constructor(private practiceService: PracticeService) { }

  ngOnInit(): void {
    this.practiceService.next().subscribe(data =>
      {
        this.word = data;
      }
    );
  }

  next(){
    this.practiceService.next().subscribe(data =>
      {
        this.word= data;
      }
    );
  }
}
