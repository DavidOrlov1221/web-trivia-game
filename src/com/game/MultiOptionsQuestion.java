/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author kondrone
 */
public class MultiOptionsQuestion extends AbsQuestion {

    List<String> answers;
 

    public MultiOptionsQuestion(String question, String difficulty, int questionId, String category, String rightAnswer, String... answers) {
        super(question, difficulty, questionId, category,rightAnswer);
        this.answers = Arrays.asList(answers);
        this.answers.add(rightAnswer);
    }

    protected void removeAnswer(String deleteAnswer) {
        this.answers.remove(deleteAnswer);

    }

}
