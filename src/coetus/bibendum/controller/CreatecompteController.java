/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.controller;

import animatefx.animation.SlideInLeft;
import coetus.bibendum.dao.CompteDao;
import coetus.bibendum.dao.PersonneDao;
import coetus.bibendum.modele.Compte;
import coetus.bibendum.modele.Personne;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class CreatecompteController implements Initializable {
    
    LottoController controller = new LottoController();
    public Compte user;
    private Personne personne;
    private  Compte compte;
    
 @FXML
    private JFXTextField nom;

    @FXML
    private JFXTextField prenom;

    @FXML
    private JFXTextField sexe;

    @FXML
    private JFXTextField age;

    @FXML
    private JFXPasswordField confMdp;

    @FXML
    private JFXTextField pseudo;

    @FXML
    private JFXPasswordField mdp;

    @FXML
    private JFXButton createCompte;

    @FXML
    private JFXButton seConnecter;

    @FXML
    void createUnCompte(ActionEvent event) {

        if (nom.getText().isEmpty() || prenom.getText().isEmpty() || age.getText().isEmpty()) {

            controller.notification(3, "     Formulaire non remplie ", "/coetus/bibendum/icon/broken-zoneT.png", "     Formulaire invalide ");
        } else if (pseudo.getText().isEmpty() || mdp.getText().isEmpty() || confMdp.getText().isEmpty()) {
            controller.notification(3, "      Formulaire non remplie ", "/coetus/bibendum/icon/broken-zoneT.png", "     Formulaire invalide ");
        } 
        
        else if (new CompteDao().getBypseudo(pseudo.getText()) != null) {
            controller.notification(3, "     Pseudo deja existant ", "/coetus/bibendum/icon/broken-zoneT.png", "     Pseudo Erreur ");
        } else {

            if (sexe.getText().isEmpty() == false) {

                if (sexe.getText().charAt(0) == 'm' || sexe.getText().charAt(0) == 'M') {
                    personne = new Personne(nom.getText(), prenom.getText(), Integer.parseInt(String.valueOf(age.getText())), "Masculin");

                } else {
                    personne = new Personne(nom.getText(), prenom.getText(), Integer.parseInt(String.valueOf(age.getText())), "Feminin");
                }
            }

            CompteDao compteDao = new CompteDao();
            boolean b = false;
            if (mdp.getText().equals(confMdp.getText())) {
                
                PersonneDao personneDao = new PersonneDao();
                personneDao.createPersonne(personne);

                compte = new Compte(pseudo.getText(), mdp.getText(), 500, personne);
                compteDao.creerCompte(compte);

                if (compteDao.creerCompte(compte)) {

                    controller.notification(3, "     Compte Creer avec success :-)  \n  Veuillez vous connectez ", "/coetus/bibendum/icon/broken-zoneT.png", "  welcome  ");
                } else {
                    controller.notification(3, "     Mot de passe non correspondant  ", "/coetus/bibendum/icon/broken-zoneT.png", "   pass error syn erro ");
                }

            }
        }
    }

    
    
    @FXML
    void seconnecter(ActionEvent event) throws IOException  {
        
          FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/connexion.fxml"));
          Parent connexionView = loader.load();
          
        Scene ConnexionScene = new Scene(connexionView);
        Stage connexionStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    
        new SlideInLeft(connexionView).play();
        connexionStage.setScene(ConnexionScene);
        Image image = new  Image("/coetus/bibendum/icon/broken-zoneT.png");
        connexionStage.getIcons().add(image);
        connexionStage.setTitle(" Aleam-Lotto Create an Account ");
        connexionStage.centerOnScreen();
        connexionStage.setResizable(false);
        connexionStage.show();
        
    }
    
    
    public void setUtilisateur(Compte Connecter){
        user = new Compte();
        user = Connecter;
  
        
    }
    
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  
    
 
}

   