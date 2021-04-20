package com.isilearn.controller;

import com.isilearn.model.User;
import com.isilearn.model.Word;
import com.isilearn.repository.LessonRepository;
import com.isilearn.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WordController {

    private final WordRepository wordRepository;

    public WordController(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @GetMapping("/words")
    List<Word> getWords(){
        return (List<Word>) wordRepository.findAll();
    }

    /**
     * Pour trouver un mot utiliser la route : http://localhost:8080/word?id='idDuMot"
     * @param id
     * @return
     */
    @GetMapping("/word")
    Word getWord(@RequestParam(value = "id") Long id){
        return wordRepository.findById(id).get();
    }

    @PostMapping("/word")
    void addWord(@RequestBody Word word) {
        wordRepository.save(word);
    }

    @DeleteMapping("/word")
    void deleteWord(@RequestBody Word word){
        wordRepository.delete(word);
    }

}
