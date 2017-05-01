/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chmquiz.dynamicPanel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Heshan Sandamal
 */
public class QContainerController implements Initializable {

    @FXML
    private GridPane containerPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        containerPane.setPrefHeight(283*10);
        //containerPane.
        try {
            Pane newPane = FXMLLoader.load(getClass().getResource("/chmquiz/dynamicPanel/Pane.fxml"));
            containerPane.add(newPane, 0, 0);
        } catch (IOException ex) {
            Logger.getLogger(QContainerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Pane newPane1 = FXMLLoader.load(getClass().getResource("/chmquiz/dynamicPanel/Pane.fxml"));
            containerPane.add(newPane1, 0, 1);
        } catch (IOException ex) {
            Logger.getLogger(QContainerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Pane newPane1 = FXMLLoader.load(getClass().getResource("/chmquiz/dynamicPanel/Pane.fxml"));
            containerPane.add(newPane1, 0, 2);
        } catch (IOException ex) {
            Logger.getLogger(QContainerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
            Pane newPane1 = FXMLLoader.load(getClass().getResource("/chmquiz/dynamicPanel/Pane.fxml"));
            containerPane.add(newPane1, 0, 3);
        } catch (IOException ex) {
            Logger.getLogger(QContainerController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
        try {
            Pane newPane1 = FXMLLoader.load(getClass().getResource("/chmquiz/dynamicPanel/Pane.fxml"));
            containerPane.add(newPane1, 0, 4);
        } catch (IOException ex) {
            Logger.getLogger(QContainerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            Pane newPane1 = FXMLLoader.load(getClass().getResource("/chmquiz/dynamicPanel/Pane.fxml"));
            containerPane.add(newPane1, 0, 5);
        } catch (IOException ex) {
            Logger.getLogger(QContainerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Pane newPane1 = FXMLLoader.load(getClass().getResource("/chmquiz/dynamicPanel/Pane.fxml"));
            containerPane.add(newPane1, 0, 6);
        } catch (IOException ex) {
            Logger.getLogger(QContainerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Pane newPane1 = FXMLLoader.load(getClass().getResource("/chmquiz/dynamicPanel/Pane.fxml"));
            containerPane.add(newPane1, 0, 7);
        } catch (IOException ex) {
            Logger.getLogger(QContainerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Pane newPane1 = FXMLLoader.load(getClass().getResource("/chmquiz/dynamicPanel/Pane.fxml"));
            containerPane.add(newPane1, 0, 8);
        } catch (IOException ex) {
            Logger.getLogger(QContainerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Pane newPane1 = FXMLLoader.load(getClass().getResource("/chmquiz/dynamicPanel/Pane.fxml"));
            containerPane.add(newPane1, 0, 9);
        } catch (IOException ex) {
            Logger.getLogger(QContainerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //containerPane.add(new Button("Next"), 0, 5);
    }    
    
}
