package com.isilearn.model;

import com.isilearn.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Word implements Serializable {

    public static long count = 0;

    @Id
    private long id;

    private String word;
    private String translatedWord;
    private String tryTranslate = null;

    public Word(){
        this.id=++count;
        this.word = "";
        this.translatedWord = "";
        this.tryTranslate = "";
    }

    public Word(String word) {
        this.id=++count;
        this.word = word;
        this.translatedWord = "";
        this.tryTranslate = "";
    }

    public Word(String word, String translatedWord) {
        this.id=++count;
        this.word = word;
        this.translatedWord = translatedWord;
        this.tryTranslate = "";
    }

    public Word(String word, String translatedWord, String tryTranslate) {
        this.id=++count;
        this.word = word;
        this.translatedWord = translatedWord;
        this.tryTranslate = tryTranslate;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslatedWord() {
        return translatedWord;
    }

    public void setTranslatedWord(String translatedWord) {
        this.translatedWord = translatedWord;
    }

    public void setTryTranslate(String word) { this.tryTranslate = word;}

    public String getTryTranslate() { return this.tryTranslate;}

    @Override
    public String toString(){
        return "Word "+id+" { " + word + " = " + translatedWord + " }";
    }

}
