/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chmquiz.quiz;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Heshan Sandamal
 */
public class FXMLDocumentController implements Initializable {


    @FXML
    private Label timeLabel;
    

    @FXML
    private RadioButton q1ans1RadioButton, q1ans2RadioButton, q1ans3RadioButton, q1ans4RadioButton;

    private static ArrayList<RadioButton> answrButtonList;
    
    @FXML
    private ToggleGroup q1;

    Stage prevStage;
    @FXML
    private Label label;

    public void setPrevStage(Stage stage) {
        this.prevStage = stage;
    }

    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        answrButtonList = new ArrayList<>();
//        
//        answrButtonList.add(q1ans1RadioButton);
//        answrButtonList.add(q1ans2RadioButton);
//        answrButtonList.add(q1ans3RadioButton);
//        answrButtonList.add(q1ans4RadioButton);
        
        
//        System.out.println("size of q list"+Data.getQuestionsList().size());
//        System.out.println(Data.getQuestionsList().get(0));
        
//        for (int i = 0; i < Data.getQuestionsList().size(); i++) {
//            
//        }

       //label2.setText("sdfds");
       //this.startTimer();
        
  
    }

       

    

}
