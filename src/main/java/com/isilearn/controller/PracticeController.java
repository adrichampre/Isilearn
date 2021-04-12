package com.isilearn.controller;


import com.isilearn.metier.Practice;
import com.isilearn.model.Lesson;
import com.isilearn.model.Word;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "http://localhost:5432")
public class PracticeController {

    private Practice practice;

    public PracticeController() {
    }

    @PostMapping("/practice/start")
    void startPractice(@RequestBody Lesson lesson){
        practice = new Practice(lesson);
    }

    @PostMapping("/practice/translate")
    void tryTranslate(@RequestBody String string){
        boolean result = practice.tryTranslate(string);
    }

    @GetMapping("/practice/next")
    public Word getNextWord(){
        return practice.getNextWord();
    }

    @GetMapping("/practice/results")
    public Practice getResults(){
        return practice;
    }

}
