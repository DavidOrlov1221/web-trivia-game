/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author kondrone
 */
public abstract class AbsQuestion implements Serializable {

    private String question;
    private String difficulty;// the difficulty of the question(easy,inadequate or tough)
    private final int Id;
    private String category;
    private String rightAnswer;
    List<String> answers;

    public String getQuestion() {
        return question;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getId() {
        return Id;
    }

    public String getCategory() {
        return category;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public AbsQuestion(String question, String difficulty, int questionId, String category, String rightAnswer, String... answers) {
        this.question = question;
        this.difficulty = difficulty;
        this.Id = questionId;
        this.category = category;
        this.rightAnswer = rightAnswer;
        this.answers = new ArrayList<String>();
        this.answers.add(rightAnswer);
        this.answers.addAll(Arrays.asList(answers));
    }

    @Override
    public String toString() {
        String result = "[id=" + Id + "] question(difficulty=" + difficulty + "):" + question;
        return result;
    }

    public void removeAnswer(String deleteAnswer) {
        this.answers.remove(deleteAnswer);
    }
     public void removeAnswer(int i) {
        this.answers.remove(i);
    }

    public void addAnswer(String deleteAnswer) {
        this.answers.add(deleteAnswer);
    }

    public boolean isAnswerRight(String answer) {
        return answer.equals(this.rightAnswer);
    }

}
