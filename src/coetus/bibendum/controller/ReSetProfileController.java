
package coetus.bibendum.controller;


import coetus.bibendum.dao.PersonneDao;
import coetus.bibendum.modele.Compte;
import coetus.bibendum.modele.Personne;
import com.jfoenix.controls.JFXButton;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class ReSetProfileController implements Initializable {
    private Personne personne;
    private PersonneDao personneDao;
    private Compte userConnectedCompte;

    
    @FXML
    private JFXTextField nom;

    @FXML
    private JFXTextField prenom;

    @FXML
    private JFXTextField age;

    @FXML
    private JFXButton annuler;

    @FXML
    private JFXButton modifier;

    
    
    
    @FXML
    void annuler(ActionEvent event) {
        
            if (event.getSource().equals(annuler)) {
                 Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                 currentStage.hide();
        }
    }

    @FXML
    void modifier(ActionEvent event) throws IOException {
        
        if (event.getSource().equals(modifier)) {
            
            if (nom.getText().length() == 0 || prenom.getText().length() == 0 || age.getText().length() == 0) {
                
                 LottoController lottoController = new LottoController();
                lottoController.notification( 3,"  Echec de la modification du profil  ","/coetus/bibendum/icon/settings.png", " formulaire invalide ");
                
            }else{
                personne = new Personne();
                personne.setNom(nom.getText());
                personne.setPrenom(prenom.getText());
                personne.setAge(Integer.parseInt(String.valueOf(age.getText())));
               personneDao = new PersonneDao();
           
                  boolean b = personneDao.updatePerson(userConnectedCompte, personne);
                  // 
                   if (b == true) {
                       
                       LottoController lottoController = new LottoController();
                       lottoController.notification(4, " Modification du profil effectue avec succes ! ", "/coetus/bibendum/icon/padlock.png", " modification effectue ");
                   
                       
                       
                       FXMLLoader setting = new FXMLLoader(getClass().getResource("../fxml/setting.fxml"));
                       Pane view = setting.load();
                       SettingController settingController = setting.getController();
                       userConnectedCompte.setProprio(personne);
                       
                       
                       Compte modified = new Compte(userConnectedCompte.getPseudo(), userConnectedCompte.getMotDePasse(), 
                               userConnectedCompte.getSolde(), userConnectedCompte.getProprio());
                      settingController.utilisateurConnecte(modified);

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ReSetProfileController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                      
                       Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                       currentStage.hide();
                    }else{
                         LottoController lottoController = new LottoController();
                         lottoController.notification( 3,"  Echec de la modification du profil  ","/coetus/bibendum/icon/settings-black.png", " modification echouee ");
                         
                        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                 currentStage.hide();
                   }
                  
                
                
            }
            
        }

    }
    
    public  void intializeConnecter(Compte connectedMan){
        userConnectedCompte = new Compte();
        userConnectedCompte = connectedMan;
        this.setUserConnectedCompte(userConnectedCompte);
        
    }
    
    public Compte SendModifier(Compte AfterEffect){
        userConnectedCompte = AfterEffect;
        return  AfterEffect;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public PersonneDao getPersonneDao() {
        return personneDao;
    }

    public void setPersonneDao(PersonneDao personneDao) {
        this.personneDao = personneDao;
    }

    public Compte getUserConnectedCompte() {
        return userConnectedCompte;
    }

    public void setUserConnectedCompte(Compte utilisateur) {
        userConnectedCompte = utilisateur;
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
