/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chmquiz;

import chmquiz.data.Data;
import chmquiz.start.PasswordDialogController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Heshan Sandamal
 */
public class CHMQuiz extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        
        //setUserAgentStylesheet(STYLESHEET_MODENA);
        
        for (int i = 0; i < Data.answerList.size(); i++) {
            System.out.println(Data.answerList.get(i));
        }

        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("start/PasswordDialog.fxml"));
        Pane myPane = (Pane) myLoader.load();
        PasswordDialogController controller = (PasswordDialogController) myLoader.getController();
        controller.setPrevStage(stage);
        Scene myScene = new Scene(myPane);
        stage.setScene(myScene);
        stage.setResizable(false);
        stage.setTitle("Confirm Access");
        stage.show();

//        stage.setTitle("CHEMXO Knowledge Challenge 2017");
//        Pane myPane = null;
//        try {
//            myPane = FXMLLoader.load(getClass().getResource("start/StartForm.fxml"));
//        } catch (IOException ex) {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//         FXMLDocumentController controller = (FXMLDocumentController) myPane;
//        controller.setPrevStage(stage);
//
//        Scene scene = new Scene(myPane);
//        stage.setScene(scene);
//        stage.setResizable(false);
//        
//
//      //prevStage.close();
//        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }

}
