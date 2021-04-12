package com.isilearn.controller;

import com.isilearn.model.Lesson;
import com.isilearn.model.Word;
import com.isilearn.repository.LessonRepository;
import com.isilearn.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:5432")
public class LessonController {

    private final LessonRepository lessonRepository;

    @Autowired
    private WordRepository wordRepository;

    public LessonController(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @GetMapping("/lessons")
    public List<Lesson> getLessons() {
        return (List<Lesson>) lessonRepository.findAll();
    }

    /**
     * Pour trouver une lesson utiliser la route : http://localhost:8080/lesson?id='idDeLaLesson"
     * @param id
     * @return
     */
    @GetMapping("/lesson")
    public Lesson getLesson(@RequestParam(value = "id") Long id) {
        return lessonRepository.findById(id).get();
    }

    @PostMapping("/lesson")
    void addLesson(@RequestBody Lesson lesson) {
        lessonRepository.save(lesson);
    }

    @DeleteMapping("/lesson")
    void deleteLesson(@RequestBody Lesson lesson) {
        lessonRepository.delete(lesson);
    }

    @PostMapping("/lesson/{id}/word")
    void addWord(@RequestBody Word word, @PathVariable Long id){
        wordRepository.save(word);
        lessonRepository.findById(id).get().addWord(word);
    }

}
