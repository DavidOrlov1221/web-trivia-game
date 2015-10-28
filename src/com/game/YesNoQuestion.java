/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game;

/**
 *
 * @author kondrone
 */
public class YesNoQuestion extends MultiOptionsQuestion {

    public YesNoQuestion(String question, String difficulty, int questionId, String category,String rightAnswer, String... answers) {
        super(question, difficulty, questionId, category, rightAnswer, "yes","no");
        this.removeAnswer(rightAnswer);

    }

}
