/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.controller;

import com.gluonhq.charm.glisten.animation.FadeOutDownTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class IncriptionController implements Initializable{

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private TextField nomField;

    @FXML
    private TextField ConfirmPasseField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField PseudoField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField AgeField;

    @FXML
    private TextField sexeField;

    @FXML
    private PasswordField Mot_De_passe;

    @FXML
    private Label statuLabel;

    @FXML
    private Button submitBnt;
    
        @FXML
    private ImageView bntBack;
        
    @FXML
    void handlesubmitBnt(ActionEvent event) {

    }
    
 @FXML
    void handlebntBack(MouseEvent event) throws IOException {
        Parent view = FXMLLoader.load(getClass().getResource("/coetus/bibendum/fxml/connexion.fxml"));
        Scene nouveauScene = new Scene(view);
        Stage app_stage = (Stage) ( (Node) event.getSource() ).getScene().getWindow();
        new FadeOutDownTransition(view).play();
        app_stage.setScene(nouveauScene);
        app_stage.show();
      
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

}

