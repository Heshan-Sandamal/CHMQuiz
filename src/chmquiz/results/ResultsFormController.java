/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chmquiz.results;

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

        ArrayList<RadioButton> answrButtonList = FXMLDocumentController.getAnswrButtonList();

        for (int j = 0; j < answrButtonList.size(); j++) {
            if (answrButtonList.get(j).isSelected()) {
                System.out.println("selected " + j);
                resultLabel.setText("selected "+j);
            }
        }
        
              
        
    }

}
