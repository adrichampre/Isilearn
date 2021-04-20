package com.isilearn.model;

import com.isilearn.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lesson implements Serializable {

    public static long count = 0;

    @Id
    private long id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(columnDefinition="TEXT")
    private ArrayList<Word> wordList;

    public Lesson() {
        //this.id=++count;
        this.name = "";
        this.wordList = new ArrayList<>();
    }

    public Lesson(String name) {
        this.id=++count;
        this.name = name;
        this.wordList = new ArrayList<>();
    }

    public Lesson(String name, ArrayList<Word> words) {
        this.id=++count;
        this.name = "";
        this.wordList = words;
    }

    public Lesson(ArrayList<Word> wordList) {
        this.wordList = wordList;
    }

    public ArrayList<Word> getWordList() {
        return wordList;
    }

    public void setWordList(ArrayList<Word> wordList) {
        this.wordList = wordList;
    }

    public void addWord(Word word){
        wordList.add(word);
    }

    public Word get(int index){
        if(index >= wordList.size())
            return null;
        return wordList.get(index);
    }

    public int size(){
        return wordList.size();
    }

    @Override
    public String toString(){
        return "Lesson "+id+" { '"+name+ "', size : " +size()+" }";
    }
}
