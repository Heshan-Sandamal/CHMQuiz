/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chmquiz.main;

import chmquiz.data.Data;
import chmquiz.data.LanguageConstants;
import chmquiz.results.ResultsFormController;
import chmquiz.start.StartFormController;
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
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Heshan Sandamal
 */
public class MainWindowController implements Initializable {
<<<<<<< HEAD
    
    int time = 90;
=======

    int time = 12;
>>>>>>> 267b9cb8295853fdd42a06e65b2552e3432c14d3

    @FXML
    private Label timeLabel;
    
    @FXML
    private Label timeRemainingDescriptionLabel;

    @FXML
    private RadioButton q1ans1RadioButton, q1ans2RadioButton, q1ans3RadioButton, q1ans4RadioButton,
            q2ans1RadioButton, q2ans2RadioButton, q2ans3RadioButton, q2ans4RadioButton,
            q3ans1RadioButton, q3ans2RadioButton, q3ans3RadioButton, q3ans4RadioButton,
            q4ans1RadioButton, q4ans2RadioButton, q4ans3RadioButton, q4ans4RadioButton,
            q5ans1RadioButton, q5ans2RadioButton, q5ans3RadioButton, q5ans4RadioButton,
            q6ans1RadioButton, q6ans2RadioButton, q6ans3RadioButton, q6ans4RadioButton,
            q7ans1RadioButton, q7ans2RadioButton, q7ans3RadioButton, q7ans4RadioButton,
            q8ans1RadioButton, q8ans2RadioButton, q8ans3RadioButton, q8ans4RadioButton,
            q9ans1RadioButton, q9ans2RadioButton, q9ans3RadioButton, q9ans4RadioButton,
            q10ans1RadioButton, q10ans2RadioButton, q10ans3RadioButton, q10ans4RadioButton,
            q11ans1RadioButton, q11ans2RadioButton, q11ans3RadioButton, q11ans4RadioButton,
            q12ans1RadioButton, q12ans2RadioButton, q12ans3RadioButton, q12ans4RadioButton,
            q13ans1RadioButton, q13ans2RadioButton, q13ans3RadioButton, q13ans4RadioButton,
            q14ans1RadioButton, q14ans2RadioButton, q14ans3RadioButton, q14ans4RadioButton,
            q15ans1RadioButton, q15ans2RadioButton, q15ans3RadioButton, q15ans4RadioButton;

    private static ArrayList<RadioButton> answerButtonList;
    @FXML
    private Label q1Label, q2Label, q3Label, q4Label, q5Label, q6Label, q7Label, q8Label, q9Label, q10Label, q11Label, q12Label, q13Label, q14Label, q15Label;

    @FXML
    private ToggleGroup x1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.setQuestions();
        this.setAnswers();
        this.startTimer();

        if (Data.languageType == 0) {
            timeRemainingDescriptionLabel.setText(LanguageConstants.timeRemainingSinhala);
        } else {
            timeRemainingDescriptionLabel.setText(LanguageConstants.timeRemainingEnglish);
        }
    }

    Stage prevStage;

    public void setPrevStage(Stage stage) {
        this.prevStage = stage;
    }

    private void setQuestions() {
        q1Label.setText(Data.getQuestionsList().get(0));
        q2Label.setText(Data.getQuestionsList().get(1));
        q3Label.setText(Data.getQuestionsList().get(2));
        q4Label.setText(Data.getQuestionsList().get(3));
        q5Label.setText(Data.getQuestionsList().get(4));
        q6Label.setText(Data.getQuestionsList().get(5));
        q7Label.setText(Data.getQuestionsList().get(6));
        q8Label.setText(Data.getQuestionsList().get(7));
        q9Label.setText(Data.getQuestionsList().get(8));
        q10Label.setText(Data.getQuestionsList().get(9));
        q11Label.setText(Data.getQuestionsList().get(10));
        q12Label.setText(Data.getQuestionsList().get(11));
        q13Label.setText(Data.getQuestionsList().get(12));
        q14Label.setText(Data.getQuestionsList().get(13));
        q15Label.setText(Data.getQuestionsList().get(14));
    }

    private void startTimer() {
        Thread t = new Thread(new Runnable() {

            boolean run = true;

            @Override
            public void run() {
                while (run) {
                    //final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            //dynamicTimeProperty.set(sdf.format(new Date()));
                            timeLabel.setText("" + time--);
                            
                            if(time==9){
                                timeLabel.setTextFill(Color.RED);
                                timeLabel.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                            }

                            if (time < 0) {
                                run = false;
                                Stage stage = new Stage();
                                FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/chmquiz/results/ResultsForm.fxml"));
                                Pane myPane = null;
                                try {
                                    myPane = (Pane) myLoader.load();
                                } catch (IOException ex) {
                                    Logger.getLogger(StartFormController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                ResultsFormController controller = (ResultsFormController) myLoader.getController();
                                controller.setPrevStage(stage);
                                Scene myScene = new Scene(myPane);
                                stage.setScene(myScene);
                                stage.setTitle("Results");
                                stage.show();
                                stage.setResizable(false);
                                prevStage.close();

                            }
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        break;
                    }

                }

                //System.out.println("end of loop");
            }
        });
        t.setName("Runnable Time Updater");
        t.setDaemon(true);
        t.start();
    }

    public static ArrayList<RadioButton> getAnswerButtonList() {
        return answerButtonList;
    }

    private void setAnswers() {
        answerButtonList = new ArrayList<>();

        answerButtonList.add(q1ans1RadioButton);
        answerButtonList.add(q1ans2RadioButton);
        answerButtonList.add(q1ans3RadioButton);
        answerButtonList.add(q1ans4RadioButton);

        answerButtonList.add(q2ans1RadioButton);
        answerButtonList.add(q2ans2RadioButton);
        answerButtonList.add(q2ans3RadioButton);
        answerButtonList.add(q2ans4RadioButton);

        answerButtonList.add(q3ans1RadioButton);
        answerButtonList.add(q3ans2RadioButton);
        answerButtonList.add(q3ans3RadioButton);
        answerButtonList.add(q3ans4RadioButton);

        answerButtonList.add(q4ans1RadioButton);
        answerButtonList.add(q4ans2RadioButton);
        answerButtonList.add(q4ans3RadioButton);
        answerButtonList.add(q4ans4RadioButton);

        answerButtonList.add(q5ans1RadioButton);
        answerButtonList.add(q5ans2RadioButton);
        answerButtonList.add(q5ans3RadioButton);
        answerButtonList.add(q5ans4RadioButton);

        answerButtonList.add(q6ans1RadioButton);
        answerButtonList.add(q6ans2RadioButton);
        answerButtonList.add(q6ans3RadioButton);
        answerButtonList.add(q6ans4RadioButton);

        answerButtonList.add(q7ans1RadioButton);
        answerButtonList.add(q7ans2RadioButton);
        answerButtonList.add(q7ans3RadioButton);
        answerButtonList.add(q7ans4RadioButton);

        answerButtonList.add(q8ans1RadioButton);
        answerButtonList.add(q8ans2RadioButton);
        answerButtonList.add(q8ans3RadioButton);
        answerButtonList.add(q8ans4RadioButton);

        answerButtonList.add(q9ans1RadioButton);
        answerButtonList.add(q9ans2RadioButton);
        answerButtonList.add(q9ans3RadioButton);
        answerButtonList.add(q9ans4RadioButton);

        answerButtonList.add(q10ans1RadioButton);
        answerButtonList.add(q10ans2RadioButton);
        answerButtonList.add(q10ans3RadioButton);
        answerButtonList.add(q10ans4RadioButton);

        answerButtonList.add(q11ans1RadioButton);
        answerButtonList.add(q11ans2RadioButton);
        answerButtonList.add(q11ans3RadioButton);
        answerButtonList.add(q11ans4RadioButton);

        answerButtonList.add(q12ans1RadioButton);
        answerButtonList.add(q12ans2RadioButton);
        answerButtonList.add(q12ans3RadioButton);
        answerButtonList.add(q12ans4RadioButton);

        answerButtonList.add(q13ans1RadioButton);
        answerButtonList.add(q13ans2RadioButton);
        answerButtonList.add(q13ans3RadioButton);
        answerButtonList.add(q13ans4RadioButton);

        answerButtonList.add(q14ans1RadioButton);
        answerButtonList.add(q14ans2RadioButton);
        answerButtonList.add(q14ans3RadioButton);
        answerButtonList.add(q14ans4RadioButton);

        answerButtonList.add(q15ans1RadioButton);
        answerButtonList.add(q15ans2RadioButton);
        answerButtonList.add(q15ans3RadioButton);
        answerButtonList.add(q15ans4RadioButton);

        for (int i = 0; i < 15; i++) {
            String[] opt = Data.optionsList.get(i);
            answerButtonList.get(i * 4).setText(opt[0]);
            answerButtonList.get(i * 4 + 1).setText(opt[1]);
            answerButtonList.get(i * 4 + 2).setText(opt[2]);
            answerButtonList.get(i * 4 + 3).setText(opt[3]);
        }

    }
}
