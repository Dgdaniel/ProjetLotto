package coetus.bibendum.controller;

import com.gluonhq.charm.glisten.animation.FadeInDownBigTransition;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ConnexionController implements Initializable{

    
   @FXML
    private Pane ConnexionPane;

    @FXML
    private TextField loginField;

    @FXML
    private TextField ConnextPassField;

    @FXML
    private Label motDePasseOublie;

    @FXML
    private Button bntConnexion;

    @FXML
    private Button btnCreerUnCompte;

    @FXML
    private ImageView bntClose;

    @FXML
    void handleForgottenPassword(MouseEvent event) {
            
    }

    @FXML
    void handlebntClose(MouseEvent event) {

    }

    @FXML
    void handlebtnConnexion(ActionEvent event) {

    }

    @FXML
    void handlebtnCreerUnCompte(ActionEvent event) throws IOException {
        Parent view = FXMLLoader.load(getClass().getResource("/coetus/bibendum/fxml/incription.fxml"));
        Scene nouveauScene = new Scene(view);
        Stage app_stage = (Stage) ( (Node) event.getSource() ).getScene().getWindow();
        new FadeInDownBigTransition(view).play();
        app_stage.setScene(nouveauScene);
        app_stage.show();
    }

   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      bntClose.setOnMouseClicked(new EventHandler<MouseEvent> () {
          @Override
          public void handle(MouseEvent event) {
              Platform.exit();
          }
      });
    }
   
    }
