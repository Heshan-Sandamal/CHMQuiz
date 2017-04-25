/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chmquiz.results;

import chmquiz.main.MainWindowController;
import chmquiz.data.Data;
import chmquiz.data.LanguageConstants;
import chmquiz.start.StartFormController;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Heshan Sandamal
 */
public class ResultsFormController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField nicTextField;
    @FXML
    private TextField marksTextField;
    @FXML
    private Pane resultsPanel;

    Stage prevStage;
    @FXML
    private Label timeOverLabel;
    @FXML
    private Button viewResultsButton;
    @FXML
    private Label nicLabel;
    @FXML
    private Label marksLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Button restartButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        resultsPanel.setVisible(false);
        //restartButton.setVisible(false);

        if (Data.languageType == 0) {
            timeOverLabel.setText(LanguageConstants.timeOverSinhalaMessage);
            viewResultsButton.setText(LanguageConstants.viewResultsSinhalaMessage);
            nameLabel.setText(LanguageConstants.nameSinhala);
            nicLabel.setText(LanguageConstants.nicSinhala);
            marksLabel.setText(LanguageConstants.marksSinhala);
            restartButton.setText(LanguageConstants.restartSinhala);
        } else {
            timeOverLabel.setText(LanguageConstants.timeOverEnglishMessage);
            viewResultsButton.setText(LanguageConstants.viewResultsEnglishMessage);
            nicLabel.setText(LanguageConstants.nicEnglish);
            nameLabel.setText(LanguageConstants.nameEngish);
            marksLabel.setText(LanguageConstants.marksEnglish);
            restartButton.setText(LanguageConstants.restartEnglish);
        }

    }

    @FXML
    private void restartButtonAction(ActionEvent event) {
        Stage stage = new Stage();
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/chmquiz/start/StartForm.fxml"));
        Pane myPane = null;
        try {
            myPane = (Pane) myLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(StartFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Data.studentName = null;
        Data.nicNo = null;

        StartFormController controller = (StartFormController) myLoader.getController();
        controller.setPrevStage(prevStage);
        Scene myScene = new Scene(myPane);
        stage.setScene(myScene);
        prevStage.close();
        stage.show();
        stage.setResizable(false);
        prevStage.close();
    }

    @FXML
    private void viewResultsButtonAction(ActionEvent event) {

        resultsPanel.setVisible(true);
        ArrayList<RadioButton> answerButtonList = MainWindowController.getAnswerButtonList();

        String str = "";
        //System.out.println("size of button list"+answerButtonList.size());

        int[] answerList = new int[15];

        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 4; i++) {
                if (answerButtonList.get(j * 4 + i).isSelected()) {
                    answerList[j] = i;
                    break;
                }

                if (i == 3) {
                    answerList[j] = -1;
                }
            }
        }

        float total = 0;

        for (int i = 0; i < 4; i++) {
            if (answerList[i] == Data.answerList.get(i) - 1) {
                total += 8;
            }
        }

        for (int i = 4; i < 10; i++) {
            if (answerList[i] == Data.answerList.get(i) - 1) {
                total += 7;
            }
        }

        for (int i = 10; i < 15; i++) {
            if (answerList[i] == Data.answerList.get(i) - 1) {
                total += 5.2;
            }
        }

        nameTextField.setText(Data.studentName);
        nicTextField.setText(Data.nicNo);
        marksTextField.setText(String.valueOf(total));

        try {
            writeToResultsFile(total);
        } catch (IOException ex) {
            Logger.getLogger(ResultsFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setPrevStage(Stage prevStage) {
        this.prevStage = prevStage;
    }

    private void writeToResultsFile(float total) throws IOException {
        // Create a new file, by default canWrite=true, readonly=false
        File file = new File("results.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fr = new FileWriter(file,true);
        fr.write(Data.studentName + " ---- ");
        fr.write(Data.nicNo + " ---- ");
        fr.write(String.valueOf(total) + "\n");

        file.setReadOnly();

        fr.close();

    }

}
