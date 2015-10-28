/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game;

import java.io.Serializable;

/**
 *
 * @author kondrone
 */
public abstract class AbsQuestion implements Serializable {

    private String question;
    private String difficulty;// the difficulty of the question(easy,inadequate or tough)
    private final int questionId;
    private String category;
    private String rightAnswer;

    

    /**
     * TODO: make serializable to the file
     */
    public void save() {

    }

    public AbsQuestion(String question, String difficulty, int questionId, String category,String rightAnswer) {
        this.question = question;
        this.difficulty = difficulty;
        this.questionId = questionId;
        this.category = category;
        this.rightAnswer = rightAnswer;
    }

    @Override
    public String toString() {
        String result = "[id=" + questionId + "] question(difficulty=" + difficulty + "):" + question;
        return result;
    }

    /**
     * this function return new question from input
     *
     * @param <T> is type of the question
     * @return
     */
    public static <T extends AbsQuestion> T createQuestion() {
        return T.createQuestion();
    }

    public static <T extends AbsQuestion> T createAndSaveQuestion() {
        AbsQuestion question = AbsQuestion.<T>createQuestion();
        question.save();
        return (T) question;
    }

}
