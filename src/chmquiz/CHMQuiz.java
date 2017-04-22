/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chmquiz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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

        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));

        Pane myPane = (Pane) myLoader.load();

        FXMLDocumentController controller = (FXMLDocumentController) myLoader.getController();

        controller.setPrevStage(stage);

        Scene myScene = new Scene(myPane);
        stage.setScene(myScene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
