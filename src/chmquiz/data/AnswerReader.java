/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chmquiz.data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Dimuth
 */
public class AnswerReader {
     public static ArrayList<Integer> read(ArrayList<Integer> randomList){
        
       
        ArrayList<Integer> valueArray = new ArrayList<>();
       
        
        BufferedReader reader = null;

        try {
            FileInputStream is = new FileInputStream("answer"+String.valueOf(Data.languageType)+".txt");
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            int index =0;
            
            while ((line = reader.readLine()) != null) {
                
                if(randomList.contains(index)){
                    valueArray.add(Integer.parseInt(line));
                }
                index++;
                
            }

            
        } catch (IOException e) {
            e.printStackTrace();
            
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return valueArray;
        
    }

}
