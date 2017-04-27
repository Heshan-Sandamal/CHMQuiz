/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chmquiz.instructions;

import chmquiz.data.Data;
import chmquiz.data.LanguageConstants;
import chmquiz.main.MainWindowController;
import chmquiz.start.StartFormController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Heshan Sandamal
 */
public class InstructionsFormController implements Initializable {

    Stage prevStage;
    @FXML
    private Label instructionsLabel;
    @FXML
    private Button startQuizButton;

    public void setPrevStage(Stage stage) {
        this.prevStage = stage;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       if(Data.languageType==0){
           startQuizButton.setText(LanguageConstants.startQuizSinhalaButtonText);
           instructionsLabel.setText(LanguageConstants.instructionHeaderSinhalaLableText);
       }else{
            startQuizButton.setText(LanguageConstants.startQuizEngishButtonText);
            instructionsLabel.setText(LanguageConstants.instructionHeaderEnglishLableText);
       }
    }    
    
    @FXML
    private void startQuizButtonAction(ActionEvent event) {
       // Stage stage=new Stage();
       FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/chmquiz/main/MainWindow.fxml"));
        Pane myPane=null;
        try {
            myPane = (Pane) myLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(StartFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        MainWindowController controller = (MainWindowController) myLoader.getController();
        controller.setPrevStage(prevStage);
        Scene myScene = new Scene(myPane);
        prevStage.setScene(myScene);
        prevStage.setMaximized(true);
        prevStage.setResizable(true);
        prevStage.setTitle("CHEMXO Knowledge Challenge 2017");
        prevStage.show();
    }
    
}
