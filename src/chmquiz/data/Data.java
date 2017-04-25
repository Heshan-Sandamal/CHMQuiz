/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chmquiz.data;

import java.util.ArrayList;

/**
 *
 * @author Heshan Sandamal
 */
public class Data {
    
    public static String studentName;
    public static String nicNo;
    
    public static int languageType=0;  //0-sinhala , 1-english
    
    //for current 15 questions
    public static ArrayList<Integer> randomList=new ArrayList<>();
    public static ArrayList<String> questionsList=new ArrayList<>();
    public static ArrayList<String[]> optionsList=new ArrayList<>();
    public static ArrayList<Integer> answerList=new ArrayList<>();

    
    
    public static void read(){
       
        randomList= RandomListGen.generateList();
        questionsList = QuestionReader.read(randomList);
        optionsList = OptionReader.read(randomList);
        answerList = AnswerReader.read(randomList);
    }
    
    
    
    

    public static ArrayList<String> getQuestionsList() {
        return questionsList;
    }

    public static void setQuestionsList(ArrayList<String> questionsList) {
        Data.questionsList = questionsList;
    }

    public static ArrayList<String[]> getOptionsList() {
        return optionsList;
    }

    public static void setOptionsList(ArrayList<String[]> optionsList) {
        Data.optionsList = optionsList;
    }

    public static ArrayList<Integer> getAnswerList() {
        return answerList;
    }

    public static void setAnswerList(ArrayList<Integer> answerList) {
        Data.answerList = answerList;
    }
    
    
    
    
    
    
    
    
    
}
