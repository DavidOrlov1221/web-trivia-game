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
public class GameController {

    private static Scanner scan = new Scanner(System.in);
    //private  List<AbsQuestion> questions

    public void StartGame(String filePath) {

        //TODO add save to file and read
        AbsQuestion q1 = new YesNoQuestion("1", "easy", 0, "motivation", "yes");
        AbsQuestion q2 = new YesNoQuestion("2", "easy", 0, "motivation", "yes");
        AbsQuestion q3 = new YesNoQuestion("3", "easy", 0, "motivation1", "yes");
        AbsQuestion q4 = new YesNoQuestion("4", "easy", 0, "motivation2", "yes");
        AbsQuestion q5 = new YesNoQuestion("5", "easy", 0, "motivation", "yes");
        QuestionsModel questions = new QuestionsModel(q1, q2, q3, q4, q5);
        System.out.println("welcome to TRIVIA GAME");

        //while the input is not add ,delete ,viwe and save
        while (true) {

            System.out.println("\tenter 'add' to add question");
            System.out.println("\tenter 'delete' to delete question");
            System.out.println("\tenter 'view' to view question");
            System.out.println("\tenter 'save' to save question");
            
            String operation = scan.next();

            //delete options
            if (operation.equalsIgnoreCase("add")) {

            }
            if (operation.equalsIgnoreCase("delete")) {

            }
            if (operation.equalsIgnoreCase("view")) {
                view(questions);
            }
            if (operation.equalsIgnoreCase("save")) {

            } else {
                   
            }
            //viwe options
            

        }
    }

    private void view(QuestionsModel questions) {
        Map<String, List<AbsQuestion>> sortedQuestions = questions.sortAllQuestionsByCategories();
        System.out.println("please choose category (enter 'end' to finish):" + sortedQuestions.keySet());
        Set<String> userCategories = new HashSet<String>();
        while (true) {
            String category = scan.next();
            if (category.equalsIgnoreCase("end")) {
                if (userCategories.size() > 0) {
                    break;
                } else {
                    System.out.println("must choose min 1 category");
                }
            } else if (sortedQuestions.containsKey(category.toLowerCase())) {
                userCategories.add(category.toLowerCase());
            } else if (userCategories.contains(category.toLowerCase())) {
                System.out.println(category.toLowerCase() + " already selected");
            } else {
                System.out.println("please choose category only from the list");
            }

        }
        System.out.println("user choose: " + userCategories);

    }

    private void save() {

    }

    private void delete() {

    }

    private void add() {

    }

}
