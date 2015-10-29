package com.game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kondrone
 */
public class Main {

    public static void main(String[] args) {
        List<AbsQuestion> questions = new ArrayList<AbsQuestion>();
        questions.add(new  MultiOptionsQuestion("what is your name", "easy", 0, "game", "ronen", "ahmad","guy"));
        //Logic.saveGameQuestions("~/Desctop/File.txt", questions);
        
        
    }

}
