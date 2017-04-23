/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chmquiz.quiz;

import chmquiz.data.Data;
import chmquiz.data.QuestionReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Heshan Sandamal
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private Label timeLabel;

    @FXML
    private RadioButton q1ans1RadioButton, q1ans2RadioButton, q1ans3RadioButton, q1ans4RadioButton;

    private static ArrayList<RadioButton> answrButtonList;

    @FXML
    private void handleButtonAction(ActionEvent event) {

    }

    Stage prevStage;

    public void setPrevStage(Stage stage) {
        this.prevStage = stage;
    }

    public static ArrayList<RadioButton> getAnswrButtonList() {
        return answrButtonList;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        answrButtonList = new ArrayList<>();
        
        answrButtonList.add(q1ans1RadioButton);
        answrButtonList.add(q1ans2RadioButton);
        answrButtonList.add(q1ans3RadioButton);
        answrButtonList.add(q1ans4RadioButton);

        

        Thread t = new Thread(new Runnable() {
            int i = 10;
            boolean run = true;

            @Override
            public void run() {
                while (run) {
                    //final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            //dynamicTimeProperty.set(sdf.format(new Date()));
                            timeLabel.setText("" + i--);

                            if (i < 0) {
                                run = false;
                                Stage stage = new Stage();
                                stage.setTitle("Results of Quiz");
                                Pane myPane = null;
                                try {
                                    myPane = FXMLLoader.load(getClass().getResource("/chmquiz/results/ResultsForm.fxml"));
                                } catch (IOException ex) {
                                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                Scene scene = new Scene(myPane);
                                stage.setScene(scene);

                                prevStage.close();
                                stage.show();
                                
                            }
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        break;
                    }

                }

                System.out.println("end of loop");

            }
        });
        t.setName("Runnable Time Updater");
        t.setDaemon(true);
        t.start();
        
   
        
    }

}
