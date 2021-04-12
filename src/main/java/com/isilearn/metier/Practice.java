package com.isilearn.metier;

import com.isilearn.model.Lesson;
import com.isilearn.model.Word;

import java.util.HashMap;
import java.util.Map;

public class Practice {

    private final Lesson lesson;
    private Map<Word, Boolean> successPerWord;
    private Map<Word, String> missedTranslation;
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
    }

    /**
     *
     * @return Word si il y a encore des mots à traduire
     *         null sinon
     */
    public Word getNextWord(){
        cur++;
        if (cur >= lesson.size())
            return null;
        return lesson.get(cur);
    }


    /**
     *
     * @param translation
     * @return true si bonne traduction
     *          false sinon
     */
    public boolean tryTranslate(String translation) {
        Word tested = lesson.get(cur);

        if (tested.getTranslatedWord().equals(translation)) {
            score++;
            successPerWord.put(tested, true);
            return true;
        }
        else
            missedTranslation.put(tested, translation);
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

}
