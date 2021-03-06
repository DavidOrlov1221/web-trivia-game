/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game;

import java.util.List;
import java.io.*;

/**
 *
 * @author kondrone
 */
public class IOLogic {

    public static List<AbsQuestion> loadQuestions(String filePath){

        try {
            //use buffering
            InputStream file = new FileInputStream(filePath);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            try {
                //deserialize the List
                List<AbsQuestion> qusestions = (List<AbsQuestion>) input.readObject();
                //display its data
                return  qusestions; 
            } finally {
                input.close();
            }
        }
        catch (ClassNotFoundException | IOException ex){
            System.err.println(ex);
           return  null;
        }
    }
    
    public static void saveGameQuestions(String filePath, List<AbsQuestion> questions) {
        //this function need to be checked again for more impossible errorss
        try {
            File file = new  File(filePath);
            if(file.exists() && file.isFile()){
                file.delete();
            }
            OutputStream fileOutput = new FileOutputStream(file);
            OutputStream buffer = new BufferedOutputStream(fileOutput);
            ObjectOutput output = new ObjectOutputStream(buffer);
            try {
                output.writeObject(questions);

            } finally {
                output.close();

            }
        } catch (IOException ex) {
            System.err.print("Cannot perform output." + ex);

        }

    }
}
