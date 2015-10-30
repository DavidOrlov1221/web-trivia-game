/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game;

import java.util.*;

/**
 *
 * @author kondrone
 */
public class QuestionsModel {

    List<AbsQuestion> questions;

    public QuestionsModel(String filePath) {
        this.questions = IOLogic.loadQuestions(filePath);
    }

    public QuestionsModel(AbsQuestion... questions) {
        this.questions = new ArrayList<>();
        this.questions.addAll(Arrays.asList(questions));
    }

    /**
     *
     * @return key=category value=list of questions that from key category
     */
    public Map<String, List<AbsQuestion>> sortAllQuestionsByCategories() {
        Map<String, List<AbsQuestion>> result = new HashMap<String, List<AbsQuestion>>();
        for (AbsQuestion q : questions) {
            String category = q.getCategory();
            List<AbsQuestion> temp = null;
            if (result.containsKey(category)) {
                temp = result.get(category);
            } else {
                temp = new ArrayList<>();
            }
            temp.add(q);
            result.put(category, temp);
        }
        return result;
    }

    public List<AbsQuestion> getAllQuestionsFromCategories(Map<String, List<AbsQuestion>> sortedByCategories, Set<String> categorySet) {
        List<AbsQuestion> result = new ArrayList<>();
        for (String key : categorySet) {
            result.addAll(sortedByCategories.get(key));
        }
        return result;
    }

    public AbsQuestion deleteQuestionById(int id) {
        for (AbsQuestion q : questions) {
            if (q.getId() == id) {
                this.questions.remove(q);
                return q;
            }
        }
        return null;
    }

    public void Save(String filePath) {
        IOLogic.saveGameQuestions(filePath, questions);
    }
}
