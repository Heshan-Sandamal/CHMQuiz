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
    
    public static String sinhalaInstructions="ගැටළු 15කින් යුක්තය.\n" +
"සියළුම ගැටළු වලට මිනිත්තු 3ක් ඇතුලත පිළිතුරු සැපයිය යුතුය.\n" +
"අන්තර්ජාලය, ජංගම දුරකථනය භාවිතා කළ හැකිය.";
    
    public static String englishInstructions="The quiz consists of 15 questions\n" +
"Answer all questions within 5 minutes\n" +
"Usage of internet of mobile phones is allowed";

    
    
    public static void read(){
        
        randomList= RandomListGen.generateList();
        
        
        questionsList = QuestionReader.read(randomList);
        
        optionsList = OptionReader.read(randomList);
        
        answerList = AnswerReader.read(randomList);
//        System.out.println(questionsList);
        
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
