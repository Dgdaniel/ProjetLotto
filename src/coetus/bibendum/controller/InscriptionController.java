/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class InscriptionController implements Initializable {
    
      @FXML
    private Pane pane;
      
      @FXML 
    private ImageView bntBack;
    
       @FXML 
    private ImageView closeBnt;
      
    @FXML
    private TextField nomField;

    @FXML
    private TextField pseudoField;

    @FXML
    private TextField sexeField;

    @FXML
    private TextField ageField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField mdpField;

    @FXML
    private PasswordField confField;
    
        @FXML
    private Label statutLabel;

    @FXML
    private Button submit;

    @FXML
    void handleSubmitButton(ActionEvent event) {
            
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       closeBnt.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent event) {
               Platform.exit();
           }
       });
    }    
    
}
