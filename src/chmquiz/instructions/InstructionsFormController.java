/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chmquiz.instructions;

import chmquiz.quiz.FXMLDocumentController;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Heshan Sandamal
 */
public class InstructionsFormController implements Initializable {

    Stage prevStage;

    public void setPrevStage(Stage stage) {
        this.prevStage = stage;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void startQuizButtonAction(ActionEvent event) {
        Stage stage=new Stage();
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/chmquiz/quiz/FXMLDocument.fxml"));
        Pane myPane=null;
        try {
            myPane = (Pane) myLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(StartFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FXMLDocumentController controller = (FXMLDocumentController) myLoader.getController();
        controller.setPrevStage(stage);
        Scene myScene = new Scene(myPane);
        stage.setScene(myScene);
        stage.setMaximized(true);
        prevStage.close();
        stage.show();
    }
    
}
