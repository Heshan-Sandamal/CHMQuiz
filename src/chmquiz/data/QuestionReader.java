package chmquiz.data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class QuestionReader {

    public static String read(){
        BufferedReader reader = null;

        try {
            FileInputStream is = new FileInputStream("quiz.txt");
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line,k=null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                System.out.println(line.charAt(0));
                k=line;
                
            }

            return k;
        } catch (IOException e) {
            e.printStackTrace();
            return "null";
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }

}
