package chmquiz.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Dimuth on 4/22/2017.
 */
public class QuestionReader {

    public static String read(){
        BufferedReader reader = null;

        try {
            File file = new File("quiz.txt");
            reader = new BufferedReader(new FileReader(file));

            String line,k=null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
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
