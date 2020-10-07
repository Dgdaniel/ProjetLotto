
package coetus.bibendum.controller;

import animatefx.animation.FadeInRight;
import coetus.bibendum.modele.Compte;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class AppMainMenuController implements Initializable {
    
    
    public Compte connected;
    @FXML
    private JFXButton AcceuilButton;
    
        @FXML
    private BorderPane BorderPaneView;
    @FXML
    private JFXButton TombolaButton;

    @FXML
    private JFXButton LottoButton;

    @FXML
    private JFXButton ParametreButton;

    @FXML
    private Pane BorderPaneCenter;
  
    @FXML
    private Label UserNameOnTheTopBar;

    @FXML
    void handleBntAcceuil(ActionEvent event) {

    }
    
    /**
     * 
     * @param event 
     */
    @FXML
    void handleBntLotto(ActionEvent event) {

    }

    @FXML
    void handleBntParametre(ActionEvent event) {
            if (event.getSource().equals(this.ParametreButton)) {
               
                try {
                    Pane view =  FXMLLoader.load(getClass().getResource("../fxml/setting.fxml"));
                   
                    new FadeInRight(view);
                    BorderPaneView.setCenter(view);
                   
                 } catch (IOException ex) {
                    Logger.getLogger(AppMainMenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
        }
    }

    @FXML
    void handleBntTombola(ActionEvent event) {

    }
    
   
    
    public void utilisateurConnecter(Compte compte){
        connected = compte;
        UserNameOnTheTopBar.setText("Welcome to "+connected.getProprio().getPrenom()+" "+connected.getProprio().getNom());
    
    }
    
     
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
      
        try {
             UserNameOnTheTopBar.setText(connected.getProprio().getNom()+""+connected.getProprio().getPrenom());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      
    }    
    
}
