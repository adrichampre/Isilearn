package com.isilearn.service;

import com.isilearn.metier.Practice;

public class PracticeService {

    private Practice practice;

    public PracticeService(Practice practice) {
        this.practice = practice;
    }

    public Practice getPractice() {
        return practice;
    }

    public void setPractice(Practice practice) {
        this.practice = practice;
    }
}
