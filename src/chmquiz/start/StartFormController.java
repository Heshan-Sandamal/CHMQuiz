/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chmquiz.start;

import chmquiz.data.Data;
import chmquiz.data.LanguageConstants;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Heshan Sandamal
 */
public class StartFormController implements Initializable {

    @FXML
    private ToggleGroup languageGroup;
    @FXML
    private TextField nameText;
    @FXML
    private TextField nicText;
    @FXML
    private RadioButton sinhalaRadioButton;
    @FXML
    private RadioButton englishRadioButton;
    @FXML
    private Button proceedButton;

    /**
     * Initializes the controller class.
     */
    Stage prevStage;
    @FXML
    private Label errorLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label nicLabel;
    @FXML
    private Label languageLabel;

    public void setPrevStage(Stage stage) {
        this.prevStage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        englishRadioButton.setSelected(true);
        errorLabel.setVisible(false);
    }

    @FXML
    private void proceedButtonAction(ActionEvent event) {

        if (sinhalaRadioButton.isSelected()) {
            Data.languageType = 0;
            errorLabel.setText(LanguageConstants.errorMessageOnEmptyNicAndNameSinhala);
        } else {
            Data.languageType = 1;
            errorLabel.setText(LanguageConstants.errorMessageOnEmptyNicAndNameEnglish);
        }

        Data.studentName = nameText.getText();
        Data.nicNo = nicText.getText();

        if (!Data.studentName.isEmpty() && !Data.nicNo.isEmpty()) {
            //Stage stage=new Stage();
            
            Data.read();
            
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/chmquiz/instructions/InstructionsForm.fxml"));
            Pane myPane = null;
            try {
                myPane = (Pane) myLoader.load();
            } catch (IOException ex) {
                Logger.getLogger(StartFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
            InstructionsFormController controller = (InstructionsFormController) myLoader.getController();
            controller.setPrevStage(prevStage);
            Scene myScene = new Scene(myPane);
            prevStage.setScene(myScene);
            prevStage.setResizable(false);
            prevStage.show();
        }else{
            
            errorLabel.setVisible(true);
        }

    }
    
    
    @FXML
    private void sinhalaRadioButtonAction(ActionEvent event) {
        languageLabel.setText(LanguageConstants.languageSinhala);
        nameLabel.setText(LanguageConstants.nameSinhala);
        nicLabel.setText(LanguageConstants.nicSinhala);
        proceedButton.setText(LanguageConstants.proceedSinhala);
        nameText.setPromptText(LanguageConstants.nameSinhala);
        nicText.setPromptText(LanguageConstants.nicSinhala);
    }
    
     @FXML
    private void englishRadioButtonAction(ActionEvent event) {
        languageLabel.setText(LanguageConstants.languageEnglish);
        nameLabel.setText(LanguageConstants.nameEngish);
        nicLabel.setText(LanguageConstants.nicEnglish);
        proceedButton.setText(LanguageConstants.proceedEnglish);
        nameText.setPromptText(LanguageConstants.nameEngish);
        nicText.setPromptText(LanguageConstants.nicEnglish);
    }

}
