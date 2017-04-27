package chmquiz.data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class QuestionReader {
    

    public static ArrayList<String> read(ArrayList<Integer> randomList){
        
       
        ArrayList<String> valueArray = new ArrayList<String>();
       
        
        BufferedReader reader = null;

        try {
            FileInputStream is = new FileInputStream("question"+String.valueOf(Data.languageType)+".txt");
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            int index =0;
            
            while ((line = reader.readLine()) != null) {
                
                if(randomList.contains(index)){
                    valueArray.add(line);
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
