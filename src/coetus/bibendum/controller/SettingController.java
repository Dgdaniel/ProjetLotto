
package coetus.bibendum.controller;

import animatefx.animation.SlideInUp;
import coetus.bibendum.connexion.Connexion;
import coetus.bibendum.dao.CompteDao;
import coetus.bibendum.dao.TirageDao;
import coetus.bibendum.modele.Compte;
import coetus.bibendum.modele.GrilleSimple;
import coetus.bibendum.modele.Tirage;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
    private TableView<GrilleSimple> utilisateurTable;
       @FXML
    private TableColumn<GrilleSimple, String> utilisateurTableMontantMiser;

    @FXML
    private TableColumn<GrilleSimple, String> utilisateurTableJeux;

    @FXML
    private TableColumn<GrilleSimple, String> utilisateurTableResultatJeux;

    @FXML
    private TableColumn<GrilleSimple, String> utilisateurTableTicket;

    @FXML
    private TableColumn<GrilleSimple, String> utilisateurDateJeu;
    public Compte userConnected;
    ObservableList<GrilleSimple> yourGrilleSimples;
    
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
        
       
        yourGrilleSimples = Liste(this.getUserConnected());
        
        utilisateurTable.setItems(yourGrilleSimples);
        utilisateurTableMontantMiser.setCellValueFactory(new PropertyValueFactory<>("montantMise"));
        utilisateurTableJeux.setCellValueFactory(new PropertyValueFactory<>("jeu"));
        utilisateurTableResultatJeux.setCellValueFactory(new PropertyValueFactory<>("resultatjeu"));
        utilisateurTableTicket.setCellValueFactory(new PropertyValueFactory<>("ticket"));
        utilisateurDateJeu.setCellValueFactory(new PropertyValueFactory<>("datejeu"));
    }
    
    public static  ObservableList<GrilleSimple> Liste(Compte comptea){
        
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        ObservableList<GrilleSimple>  userList =  FXCollections.observableArrayList();
        
        String sql = "select * from grille where idCompte = ? ";
        
        CompteDao compteDao = new CompteDao();
        Compte c = new Compte();
        c = compteDao.getBypseudo(comptea.getPseudo());
        try {
            
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SettingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            preparedStatement.setInt(1, c.getIdCompte() );
        } catch (SQLException ex) {
            Logger.getLogger(SettingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResultSet resultSet = null;
        
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SettingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while (resultSet.next()) {

                if (resultSet.getString("num3") == null && resultSet.getString("num4") == null
                        && resultSet.getString("num5") == null && resultSet.getString("numBonus") == null
                        && resultSet.getString("idTyrage") == null) {
                   
                    userList.add(
                            new GrilleSimple(resultSet.getString("montantMise"),
                                    (resultSet.getInt("num1") + "-" + resultSet.getInt("num2")),
                                    " ",
                                    resultSet.getString("Ticket"),
                                    resultSet.getString("dateJeu"))
                    );

                } else if (resultSet.getString("num4") == null
                        && resultSet.getString("num5") == null && resultSet.getString("numBonus") == null
                        && resultSet.getString("idTyrage") == null) {
                    userList.add(
                            new GrilleSimple(resultSet.getString("montantMise"),
                                    (resultSet.getInt("num1") + "-" + resultSet.getInt("num2") + "" + resultSet.getInt("num3")),
                                    " ", resultSet.getString("Ticket"),
                                    resultSet.getString("dateJeu"))
                    );
                } else if (resultSet.getString("num5") == null && resultSet.getString("numBonus") == null
                        && resultSet.getString("idTyrage") == null) {
                    userList.add(
                            new GrilleSimple(resultSet.getString("montantMise"),
                                   (resultSet.getInt("num1") + "-" + resultSet.getInt("num2")
                                            + "" + resultSet.getInt("num3") + "-" + resultSet.getInt("num4")),
                                    " ", resultSet.getString("Ticket"),
                                    resultSet.getString("dateJeu"))
                    );
                } else if (resultSet.getString("numBonus") == null
                        && resultSet.getString("idTyrage") == null) {
                    userList.add(
                            new GrilleSimple(resultSet.getString("montantMise"),
                                    resultSet.getString(resultSet.getInt("num1") + "-" + resultSet.getInt("num2")
                                            + "" + resultSet.getInt("num3") + "-" + resultSet.getInt("num4")
                                            + "-" + resultSet.getInt("num5")),
                                    " ", resultSet.getString("Ticket"),
                                    resultSet.getString("dateJeu"))
                    );
                } else if (resultSet.getString("idTyrage") == null) {
                    userList.add(
                            new GrilleSimple(resultSet.getString("montantMise"),
                                    (resultSet.getInt("num1") + "-" + resultSet.getInt("num2")
                                            + "-" + resultSet.getInt("num3") + "-" + resultSet.getInt("num4")
                                            + "-" + resultSet.getInt("num5")
                                            + "-" + resultSet.getInt("numBonus")),
                                    " ", resultSet.getString("Ticket"),
                                    resultSet.getString("dateJeu"))
                    );
                } else {
                    TirageDao tirageDao = new TirageDao();
                    Tirage t = new Tirage();
                    t = tirageDao.getById(resultSet.getInt("idTyrage"));

                    StringBuilder s = new StringBuilder(40);
                    s.append(t.getNumtir1());
                    s.append("-");
                    s.append(t.getNumtir2());
                    s.append("-");
                    s.append(t.getNumtir3());
                    s.append("-");
                    s.append(t.getNumtir4());
                    s.append("-");
                    s.append(t.getNumtir5());
                    s.append("-");
                    s.append(t.getNumtirbonus());
                    userList.add(
                            new GrilleSimple(resultSet.getString("montantMise"),
                                    (resultSet.getInt("num1") + "-" + resultSet.getInt("num2")
                                            + "" + resultSet.getInt("num3") + "-" + resultSet.getInt("num4")
                                            + "-" + resultSet.getInt("num5")
                                            + "-" + resultSet.getInt("numBonus")), s.toString(),
                                     resultSet.getString("Ticket"),
                                    resultSet.getString("dateJeu"))
                    );
                }

                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(SettingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userList;
        
    }

    public Compte getUserConnected() {
        return userConnected;
    }

    public void setUserConnected(Compte userConnected) {
        this.userConnected = userConnected;
    }
    
    @FXML
    void FaireDepot(ActionEvent event) {

    }

    @FXML
    void FaireRetrait(ActionEvent event) {

    }

    @FXML
    void FaireTransfert(ActionEvent event) {

    }

    @FXML
    void modifier(ActionEvent event) {
          try {
                     
                     Stage stage = new Stage();
                     FXMLLoader reSetView = new FXMLLoader(getClass().getResource("../fxml/resetprofile.fxml"));
                     Pane resetProfilePane = reSetView.load();
                     
                     ReSetProfileController reSetProfileController = reSetView.getController();
                     Compte logIn = new Compte(userConnected.getPseudo(), userConnected.getMotDePasse(), userConnected.getSolde(), userConnected.getProprio());
                     reSetProfileController.setUserConnectedCompte(logIn);
                     new SlideInUp(resetProfilePane).play();
                     
                     Scene scene = new Scene(resetProfilePane);
                     Image image = new Image("/coetus/bibendum/icon/settings.png");
                     stage.setScene(scene);
                     stage.getIcons().add(image);
                     stage.setTitle("Parametre");
                     stage.setResizable(false);
                     stage.show();
                   
                 } catch (IOException e) {
                     System.err.println(e.getMessage());
                     System.err.println(e.getLocalizedMessage());
                     e.printStackTrace();
                 }
        
    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //  utilisateurConnecte(userConnected);
  
       
       
       
    }    
    
}

