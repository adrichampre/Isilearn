package com.isilearn.controller;


import com.isilearn.metier.Practice;
import com.isilearn.model.Lesson;
import com.isilearn.model.Word;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PracticeController {

    private Practice practice;

    public PracticeController() {
    }

    @PostMapping("/practice/start")
    void startPractice(@RequestBody Lesson lesson){
        System.out.println("Start practice with "+lesson);

        practice = new Practice(lesson);
    }

    @PostMapping("/practice/translate")
    void tryTranslate(@RequestBody String string){
        System.out.println("Check translate");
        practice.tryTranslate(string);
    }

    @GetMapping("/practice/next")
    public Word getNextWord(){
        System.out.println("Next word");
        return practice.getNextWord();
    }

    @GetMapping("/practice/results")
    public Practice getResults(){
        System.out.println("Results");
        return practice;
    }

    @GetMapping("/practice/results/missed")
    public List<Word> getResultsMissed(){
        System.out.println("Results Missed");
        return practice.getResultMissed();
    }

}
