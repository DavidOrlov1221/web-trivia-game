/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game;

import java.time.Clock;
import java.util.*;

/**
 *
 * @author kondrone
 */
public class GameController {

    private static Scanner scan = new Scanner(System.in);
    private int id=0;
    //private  List<AbsQuestion> questions
  private QuestionsModel questions;
    public void StartGame(String filePath) {
 
        //TODO add save to file and read
        AbsQuestion q1 = new YesNoQuestion("1", "easy", 1, "motivation", "yes");
        AbsQuestion q2 = new YesNoQuestion("2", "easy", 2, "motivation", "yes");
        AbsQuestion q3 = new YesNoQuestion("3", "easy", 3, "motivation1", "yes");
        AbsQuestion q4 = new YesNoQuestion("4", "easy", 4, "motivation2", "yes");
        AbsQuestion q5 = new YesNoQuestion("5", "easy", 5, "motivation", "yes");
        questions = new QuestionsModel(q1, q2, q3, q4, q5);
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
add();
            }
            if (operation.equalsIgnoreCase("delete")) {
delete();
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
String DeleteOutPut="";
        for (int i = 0; i < questions.questions.size(); i++) {
            DeleteOutPut+=questions.questions.get(i).toString()+"\n";
        }
        System.out.println(DeleteOutPut);
        System.out.println("choose id to delete");
       int i= scan.nextInt();
       i-=1;
          questions.questions.remove(i);
          DeleteOutPut="";
          for ( i = 0; i < questions.questions.size(); i++) {
            DeleteOutPut+=questions.questions.get(i).toString()+"\n";
        }
              System.out.println(DeleteOutPut);
      
    
    }

    private void add() {
        
        System.out.println("what type of question you want to add ?");
        String type= scan.next();
        if (type.equals("YN"))
        {
                   String question= scan.next();
   String difficulty= scan.next();
   
     
    String category = scan.next();
  String rightAnswer= scan.next();
            YesNoQuestion s = new YesNoQuestion(question, difficulty, id, category, rightAnswer);
            id++;
            questions.questions.add(s);
        }
         if (type.equals("OPEN"))
        {
                   String question= scan.next();
   String difficulty= scan.next();
   
     
    String category = scan.next();
  String rightAnswer= scan.next();
  String UserAnswer= scan.next();
             OpenQuestion s = new OpenQuestion(question, difficulty, id, category, rightAnswer);
            id++;
             questions.questions.add(s);
        }
          if (type.equals("MULTI"))
        {
                   String question= scan.next();
   String difficulty= scan.next();
   
     
    String category = scan.next();
  String rightAnswer= scan.next();
  String UserAnswer= scan.next();
  System.out.println("type answers press -1 to stop giving answers");
  ArrayList<String> answersMulti = new ArrayList<String>(); 
 
   String AnswerMulti= scan.next();
  while(!AnswerMulti.equals("-1"))
  {
      answersMulti.add(AnswerMulti);
  }
   String[] arrayaAnswers=answersMulti.toArray(new String[0]);
            MultiOptionsQuestion s = new MultiOptionsQuestion(question, difficulty, id, category, rightAnswer,arrayaAnswers);
            id++;
             questions.questions.add(s);
        }
    
    }

}
