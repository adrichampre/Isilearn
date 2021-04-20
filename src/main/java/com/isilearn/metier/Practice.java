package com.isilearn.metier;

import com.isilearn.model.Lesson;
import com.isilearn.model.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice {

    private final Lesson lesson;
    private Map<Word, Boolean> successPerWord;
    private Map<Word, String> missedTranslation;
    private List<Word> wordTranslated;
    private int score;
    private int cur;

    public Practice(Lesson lesson) {
        this.lesson = lesson;
        this.score = 0;
        this.cur = 0;
        missedTranslation = new HashMap<>();
        successPerWord = new HashMap<>();
        for (Word word: lesson.getWordList()) {
            successPerWord.put(word, false);
        }
        wordTranslated = new ArrayList<>();
    }

    /**
     *
     * @return Word si il y a encore des mots à traduire
     *         null sinon
     */
    public Word getNextWord(){
        Word word = lesson.get(cur);
        return word;
    }


    /**
     *
     * @param translation
     * @return true si bonne traduction
     *          false sinon
     */
    public boolean tryTranslate(String translation) {
        Word tested = lesson.get(cur);
        cur++;
        System.out.println(cur);
        if (tested.getTranslatedWord().toLowerCase().equals(translation.toLowerCase())) {
            score++;
            successPerWord.put(tested, true);
            return true;
        }
        else {
            tested.setTryTranslate(translation);
            wordTranslated.add(tested);
            missedTranslation.put(tested, translation);
        }
        return false;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public Map<Word, Boolean> getSuccessPerWord() {
        return successPerWord;
    }

    public Map<Word, String> getMissedTranslation() {
        return missedTranslation;
    }

    public int getScore() {
        return score;
    }

    public int getCur() {
        return cur;
    }

    public List<Word> getResultMissed()
    {
        return wordTranslated;
    }
}
