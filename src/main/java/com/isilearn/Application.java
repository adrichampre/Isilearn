package com.isilearn;

import com.isilearn.model.Lesson;
import com.isilearn.model.User;
import com.isilearn.model.Word;
import com.isilearn.repository.LessonRepository;
import com.isilearn.repository.UserRepository;
import com.isilearn.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean(name = "wordRepositoryMethod")
    CommandLineRunner init(WordRepository wordRepository){
        return args -> {
            Word word = new Word("Oui", "Yes");
            wordRepository.save(word);
            Word word1 = new Word("Non", "No");
            wordRepository.save(word1);
            Word word2 = new Word("Bonjour", "Hello");
            wordRepository.save(word2);
            Word word3 = new Word("Salut", "Hi");
            wordRepository.save(word3);
            Word word4 = new Word("Merci", "Thanks");
            wordRepository.save(word4);

            wordRepository.findAll().forEach(System.out::println);
        };
    }

    @Bean(name = "lessonRepositoryMethod")
    CommandLineRunner init(LessonRepository lessonRepository){
        return args -> {
            Word word = new Word("Oui", "Yes");
            Word word1 = new Word("Non", "No");
            Word word2 = new Word("Bonjour", "Hello");
            Word word3 = new Word("Salut", "Hi");
            Word word4 = new Word("Merci", "Thanks");
            Lesson lesson = new Lesson("Anglais basique");
            lesson.addWord(word);
            lesson.addWord(word1);
            lesson.addWord(word2);
            lesson.addWord(word3);
            lesson.addWord(word4);

            lessonRepository.save(lesson);
            lessonRepository.findAll().forEach(System.out::println);
        };
    }



}