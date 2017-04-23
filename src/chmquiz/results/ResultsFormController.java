/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chmquiz.results;

import chmquiz.main.MainWindowController;
import chmquiz.quiz.FXMLDocumentController;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

/**
 * FXML Controller class
 *
 * @author Heshan Sandamal
 */
public class ResultsFormController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label resultLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ArrayList<RadioButton> answerButtonList = MainWindowController.getAnswerButtonList();

        String str="";
        //System.out.println("size of button list"+answerButtonList.size());
        for (int j = 0; j < answerButtonList.size(); j++) {
            //System.out.print(j);
            if (answerButtonList.get(j).isSelected()) {
                str+=j;
                
            }
        }
        
        resultLabel.setText(str);
        
              
        
    }

}
