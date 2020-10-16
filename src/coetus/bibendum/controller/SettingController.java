
package coetus.bibendum.controller;

import coetus.bibendum.modele.Compte;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class SettingController implements Initializable {

    @FXML
    private Label userNameTopBar;

    @FXML
    private Label soldeUtilisateur;

    @FXML
    private JFXButton bntDepot;

        
    @FXML
    private JFXButton bntModifierProfil;

    @FXML
    private Label nom;

    @FXML
    private Label settingPrenom;

    @FXML
    private Label settingAge;

    @FXML
    private JFXButton bntTransfert;

    @FXML
    private JFXButton BntRetrait;

    @FXML
    private Label prixGagnerUtilisateur;

    @FXML
    private TableView<?> utilisateurTable;

    @FXML
    private TableColumn<?, ?> utilisateurTableMontantMiser;

    @FXML
    private TableColumn<?, ?> utilisateurTableJeux;

    @FXML
    private TableColumn<?, ?> utilisateurTableResultatJeux;

    @FXML
    private TableColumn<?, ?> utilisateurTableTicket;
    public Compte userConnected;
    public void utilisateurConnecte(Compte user){
        userConnected = user;
        userNameTopBar.setText(""+userConnected.getProprio().getPrenom()+" "+userConnected.getProprio().getNom());
        nom.setText(userConnected.getProprio().getNom());
        settingPrenom.setText(userConnected.getProprio().getPrenom());
        settingAge.setText(  String.valueOf( userConnected.getProprio().getAge() )   );
        
        if ( userConnected.getSolde() == 0) {
               soldeUtilisateur.setText("0000");
        }else{
            soldeUtilisateur.setText(String.valueOf(userConnected.getSolde()));
        }
        
        if ( userConnected.getPrixGagner() == 0) {
            prixGagnerUtilisateur.setText("0000");
        } else{
            prixGagnerUtilisateur.setText(String.valueOf(userConnected.getSolde()));
        }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
