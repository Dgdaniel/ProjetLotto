package coetus.bibendum.controller;



import animatefx.animation.SlideInUp;
import coetus.bibendum.dao.CompteDao;
import coetus.bibendum.modele.Compte;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ConnexionController implements Initializable {

   

   public static Compte logIn = null;
    
    @FXML
    private Pane ConnexionPane;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField ConnextPassField;

    @FXML
    private Label motDePasseOublie;

    @FXML
    private Label checkUser;

    @FXML
    private Label checkUser11;

    @FXML
    private Button bntConnexion;

    @FXML
    private Button btnCreerUnCompte;

    @FXML
    private ImageView bntClose;
    
    public String pseudoUser;
    public String mdpUser;
    public double xOffset;
    public double yOffset;
    public Compte connected;
    public CompteDao compteDao;

    


    @FXML
    void handleForgottenPassword(MouseEvent event) {
            System.out.println(" ok veuillez attendre les prochaines ");
    }

    @FXML
    void handlebntClose(MouseEvent event) {
        Platform.exit();
    }
    
    @FXML
    void handlebtnConnexion(ActionEvent event) throws IOException {
       pseudoUser = loginField.getText();
       mdpUser =ConnextPassField.getText();
        if (pseudoUser.isEmpty() || mdpUser.isEmpty()) {
            checkUser.setStyle("-fx-text-fill: red;");
            checkUser.setText(" Champs vides ");
        }else{
            
            if ( verifierUtilisateurLogin(pseudoUser, mdpUser) == true ) {
                 Parent appMainMenu = FXMLLoader.load(getClass().getResource("../fxml/appMainMenu.fxml"));
                 logIn = new Compte(connected.getPseudo(), connected.getMotDePasse(), connected.getSolde(), connected.getProprio());
                
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/appMainMenu.fxml"));
                    Parent appMenu = loader.load();
                    AppMainMenuController appMainMenuController = loader.getController();               
                    logIn =  new Compte(connected.getPseudo(), connected.getMotDePasse(), connected.getSolde(), connected.getProprio());
                    appMainMenuController.utilisateurConnecter(logIn);
                    Scene appMenuScene  = new Scene(appMenu);
                    Stage app_MainMenuStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    
                    new SlideInUp(appMainMenu).play();
                    app_MainMenuStage.setScene(appMenuScene);
                    app_MainMenuStage.centerOnScreen();
                    app_MainMenuStage.show();
                    
            }
        }
       
    }


    @FXML
    void handlebtnCreerUnCompte(ActionEvent event) throws IOException {
        Parent view = FXMLLoader.load(getClass().getResource("/coetus/bibendum/fxml/createcompte.fxml"));
        Scene nouveauScene = new Scene(view);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        new SlideInUp(view).play();
        app_stage.setTitle("Aleam-Lotto Connexion");
        app_stage.setScene(nouveauScene);
        app_stage.setResizable(false);
        app_stage.show();
    }

   public boolean verifierUtilisateurLogin(String pseudo, String motDePasse){
       boolean isConnected = false;
        compteDao = new CompteDao();
        if (compteDao.getBypseudo(pseudo) == null) {
            checkUser.setStyle(" -fx-alignment: CENTER; -fx-text-fill: red;");
            checkUser.setText(" Login invalide ");
            
           
       }else{
            if (compteDao.getByPseudoPassWord(pseudo, motDePasse) == null) {
                checkUser.setStyle(" -fx-alignment: CENTER; -fx-text-fill: red;");
                checkUser11.setStyle("  -fx-alignment: CENTER; -fx-text-fill: red;");
                checkUser.setText(" ");
                checkUser11.setText("Mot de passe invalide");
                
              
            }else{
                connected = new Compte();
                connected = compteDao.getByPseudoPassWord(pseudo, motDePasse);
                checkUser11.setStyle("-fx-alignment: CENTER; -fx-text-fill: green;");
                checkUser11.setText(" Connexion reussie ");
                isConnected = true;
                
            }
        }
        
        return isConnected;
    }
    public Compte getConnected() {
        return connected;
    }
    
    public void setPseudoUser(String pseudoUser) {
        this.pseudoUser = pseudoUser;
    }

    public void setMdpUser(String mdpUser) {
        this.mdpUser = mdpUser;
    }

    
    
     public void setConnected(Compte connected) {
        this.connected = connected;
    }
     
    public String getPseudoUser() {
        return pseudoUser;
    }

    public String getMdpUser() {
        return mdpUser;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginField.setStyle("-fx-font-size:20px;");
        ConnextPassField.setStyle("-fx-font-size:17px;");
      
       
       

        bntClose.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Platform.exit();
            }
        });

    }


}
