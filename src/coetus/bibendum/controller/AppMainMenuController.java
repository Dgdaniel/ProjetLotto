
package coetus.bibendum.controller;

import animatefx.animation.FadeInRight;
import coetus.bibendum.dao.TirageDao;
import coetus.bibendum.modele.Calcul;
import coetus.bibendum.modele.Compte;
import coetus.bibendum.modele.Tirage;
import com.gluonhq.charm.glisten.animation.FlipTransition;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
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
    private NumberAxis x;

    @FXML
    private NumberAxis y;
    @FXML
    
    private JFXButton LottoButton;

    @FXML
    private JFXButton ParametreButton;

    @FXML
    private Pane BorderPaneCenter;
       @FXML
    private AreaChart<String, Integer> areaChart;

    @FXML
    private BarChart<String, Integer> BarChart;
    

    @FXML
    private Label UserNameOnTheTopBar;

        @FXML
    private Pane Acceuil;
        
    @FXML
    void handleBntAcceuil(ActionEvent event) {
        if (event.getSource().equals(AcceuilButton)) {
           
            new FlipTransition(Acceuil).play();
        BorderPaneView.setCenter(Acceuil);
        }
            
    }
    
    /**
     * 
     * @param event 
     */
    @FXML
    void handleBntLotto(ActionEvent event) throws IOException {
        
         
        
       if (event.getSource().equals(LottoButton)) {
           
           if (new TirageDao().getByDateTirageSample(LocalDate.now()) == null ) {
             // generer le  tyrage du jour    
                
            Calcul calcul = new Calcul();
            int[] tirageTableau = calcul.genererTirage();
            int numBonus = calcul.GenererNumeroBonus();
            Tirage tirage = new Tirage(tirageTableau[0], tirageTableau[1], tirageTableau[2], tirageTableau[3], tirageTableau[4], numBonus, "LOTTO");
            TirageDao tirageDao = new TirageDao();
            tirageDao.creerTirage(tirage);
    
            }
                   
        FXMLLoader lotto = new FXMLLoader(getClass().getResource("../fxml/lotto.fxml"));
        Pane view = lotto.load();
        LottoController lottoController = lotto.getController();
        lottoController.userConnected(connected);

        new FadeInRight(view).play();
        BorderPaneView.setCenter(view);
        }
     
    }

    @FXML
    void handleBntParametre(ActionEvent event) {
        if (event.getSource().equals(this.ParametreButton)) {
           
           
            try {

                FXMLLoader setting = new FXMLLoader(getClass().getResource("../fxml/setting.fxml"));
                Pane view = setting.load();
                SettingController settingController = setting.getController();
                settingController.utilisateurConnecte(connected);
              
                new FadeInRight(view).play();
                BorderPaneView.setCenter(view);

            } catch (IOException ex) {
                Logger.getLogger(AppMainMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public Compte getConnected() {
        return connected;
    }

    @FXML
    void handleBntTombola(ActionEvent event) throws IOException {
        
    }
    
   
    
    public void utilisateurConnecter(Compte compte){
        connected = new Compte();
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
     
        XYChart.Series series = new XYChart.Series<>();
        
       
        series.setName("Gagnant");
        series.getData().add(new XYChart.Data("Jan", 100));
        series.getData().add(new XYChart.Data("Fev", 170));
        series.getData().add(new XYChart.Data("Mars", 197));
        series.getData().add(new XYChart.Data("Avr", 160));
        series.getData().add(new XYChart.Data("Mai", 165));
        series.getData().add(new XYChart.Data("Juin", 179));
        series.getData().add(new XYChart.Data("Juil", 195));
        series.getData().add(new XYChart.Data("Aout", 140));
        series.getData().add(new XYChart.Data("Sept", 121));
        series.getData().add(new XYChart.Data("Oct", 173));
        series.getData().add(new XYChart.Data("Nov", 185));
        series.getData().add(new XYChart.Data("Dec", 150));
        
         XYChart.Series perdant = new XYChart.Series<>();
         perdant.setName("Perdant");
         
        perdant.getData().add(new XYChart.Data("Jan", 80));
        perdant.getData().add(new XYChart.Data("Fev", 60));
        perdant.getData().add(new XYChart.Data("Mars", 80));
        perdant.getData().add(new XYChart.Data("Avr", 70));
        perdant.getData().add(new XYChart.Data("Mai", 70));
        perdant.getData().add(new XYChart.Data("Juin", 60));
        perdant.getData().add(new XYChart.Data("Juil", 100));
        perdant.getData().add(new XYChart.Data("Aout", 80));
        perdant.getData().add(new XYChart.Data("Sept", 50));
        perdant.getData().add(new XYChart.Data("Oct", 79));
        perdant.getData().add(new XYChart.Data("Nov", 70));
        perdant.getData().add(new XYChart.Data("Dec", 12));
        

        Tooltip tooltip = new Tooltip("Le nombre de gagnants ou cours des mois augmentent souvent.");
        areaChart.getStylesheets().add("-fx-color:green;");
        areaChart.getData().addAll(series, perdant);
        BarChart.getStylesheets().add("chart-bar series<1> bar-legend-symbol default-color<red>");
        BarChart.getData().addAll(perdant);


    }    
    
}
