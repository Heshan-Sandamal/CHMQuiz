/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chmquiz.start;

import chmquiz.instructions.InstructionsFormController;
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
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Heshan Sandamal
 */
public class PasswordDialogController implements Initializable {

    @FXML
    private PasswordField passwordField;
    @FXML
    private Button okButton;
    
    
    private final static String PASSWORD="chmquiz@uom";
    private Stage prevStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    private void okButtonAction(ActionEvent actionEvent){
        if(PASSWORD.equals(passwordField.getText())){
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/chmquiz/start/StartForm.fxml"));
            Pane myPane = null;
            try {
                myPane = (Pane) myLoader.load();
            } catch (IOException ex) {
                Logger.getLogger(StartFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
            StartFormController controller = (StartFormController) myLoader.getController();
            controller.setPrevStage(prevStage);
            Scene myScene = new Scene(myPane);
            prevStage.setScene(myScene);
            prevStage.setResizable(false);
            prevStage.setTitle("Enter Details");
            prevStage.show();
        }
    }
    
    
    public void setPrevStage(Stage stage) {
        this.prevStage = stage;
    }

    
    
    
}
