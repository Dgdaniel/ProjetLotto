
package coetus.bibendum.controller;


import animatefx.animation.Shake;
import coetus.bibendum.dao.CompteDao;
import coetus.bibendum.dao.GrilleDao;
import coetus.bibendum.dao.TirageDao;
import coetus.bibendum.modele.Calcul;
import coetus.bibendum.modele.Compte;
import coetus.bibendum.modele.Jeu;
import coetus.bibendum.modele.Tirage;
import coetus.bibendum.modele.TypeLotto;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 * 
 * @author Daniel
 */
public class LottoController implements Initializable {
    private CompteDao compteDao;
    private GrilleDao grilleDao;
    private TirageDao tirageDao;
   
    /**
     * Le label sur lequel l'utilisateur a son nom
     * 
     */
    @FXML
    private Label userNameTopBar;

    @FXML
    private Label label;

    @FXML
    private JFXButton bntZero;

       @FXML
    private Label numeroTicket;

    @FXML
    private Label jeuEffectuer;

    @FXML
    private Label montant;
        
      
    @FXML
    private JFXButton bntUn;

    @FXML
    private JFXButton bntDeux;

    @FXML
    private JFXButton bntTrois;

    @FXML
    private JFXButton bntQatre;

    @FXML
    private JFXButton bntCinq;

    @FXML
    private JFXButton bnt6;

    @FXML
    private JFXButton bnt7;
    
    @FXML
    private JFXTextField parie;
    
    @FXML
    private JFXButton bnt8;
    
     @FXML
    private JFXButton bntDash;

    @FXML
    private JFXButton bnt9;

    @FXML
    private JFXTextField miseFiel;

    @FXML
    private JFXButton effacer;


    
    
    private Compte connected;

    private Jeu jeuJouerParUtilisateurConnecter;
    private float argentMiser;
    private int coupJouer;
    
    
    

    
    public void handleButton0Action(ActionEvent event) {
   
        if (label.getText() == null) {
            label.setText("0");  
        } else {
            label.setText(label.getText()+"0");
        }
        
         
    }

    public void handleButton1Action(ActionEvent event) {

       if (label.getText() == null) {
           
            label.setText("1");
        } else {
           
            label.setText(label.getText()+"1");
        }

    }

    public void handleButton2Action(ActionEvent event) {
        
        if (label.getText() == null) {
            label.setText("2");
        } else {
             label.setText(label.getText()+"2"); 
        }
    }

    public void handleButton3Action(ActionEvent event) {
        
        if (label.getText() == null) {
            label.setText("3");
        } else {
              label.setText(label.getText()+"3");
        }
    }

    public void handleButton4Action(ActionEvent event) {
     if (label.getText() == null) {
            label.setText("4");
        } else {
              label.setText(label.getText()+"4");
        }
    }

    public void handleButton5Action(ActionEvent event) {
        
        if (label.getText() == null) {
            label.setText("5");
        } else {
              label.setText(label.getText()+"5");
        }
    }

    public void handleButton6Action(ActionEvent event) {
        
      if (label.getText() == null) {
            label.setText("6");
        } else {
              label.setText(label.getText()+"6");
        }
    }

    public void handleButton7Action(ActionEvent event) {
      
        if (label.getText() == null) {
            label.setText("7");
        } else {
              label.setText(label.getText()+"7");
        }
    }

    public void handleButton8Action(ActionEvent event) {

        if (label.getText() == null) {
            label.setText("8"); 
        }else {
              label.setText(label.getText()+"8");
        }
    }
    
    
      @FXML
    void handleButtonDashAction(ActionEvent event) {
          if (label.getText() !=null) {
               label.setText(label.getText()+"-");
          }
       
        
    }
    
    public void handleButton9Action(ActionEvent event) {
        if (label.getText() == null) {
            label.setText("9");
        } else {
            label.setText(label.getText() + "9");
        }
    }



    /**
     * 
     * @param event 
     */

    @FXML
    void jouer(ActionEvent event) {
        try {
            
      
   if (label.getText().length() < 2) {
          notifierErreur(" Vous devez choisir au moins deux chiffres compris entre 1 et 90 ");
        }else{
            // jeuperer les information 
            
            if (parie.getText().length() == 0 ) {
                notifierErreur("Vous devez saisir la case Parié ");
            }else if (miseFiel.getText().length()== 0){
                 notifierErreur("Vous devez saisir la case Montant ");
            }else if (Integer.parseInt(parie.getText()) <0 ) {
                notifierErreur(" Veuillez deposez une somme sur votre  \n   COMPTE ");
                }else if (Integer.parseInt(parie.getText()) > connected.getSolde() ) {
                notifierErreur("Votre solde est insuffisant pour effectuer l'operation");
            }else if(Integer.parseInt(parie.getText())  > toArray().length  ) {
                notifierErreur(" Parie Invalide ");
            } 
            
            
            
            else {
             
                argentMiser = Float.parseFloat(miseFiel.getText());
                coupJouer = Integer.parseInt(parie.getText());
                compteDao = new CompteDao();
                compteDao.achat(connected.getPseudo(), argentMiser);
                
                ArrayList<Integer> jeu = getTable();
                System.out.println(jeu);

                System.out.println(" premier " + jeu.get(0) + "    " + jeu.get(1));
                System.out.println(jeu.size());
                    
                
                switch (jeu.size()) {
                    case 2:
                        jeuJouerParUtilisateurConnecter
                                = new Jeu(jeu.get(0), jeu.get(1), argentMiser, connected, new TypeLotto("LOTTO"));
                        numeroTicket.setText(jeuJouerParUtilisateurConnecter.getTicket());
                        jeuEffectuer.setText(jeuJouerParUtilisateurConnecter.getNum1() + "-"
                                + jeuJouerParUtilisateurConnecter.getNum2());
                        montant.setText(String.valueOf(jeuJouerParUtilisateurConnecter.getMontantMise()));
                        break;
                    case 3:
                        jeuJouerParUtilisateurConnecter
                                = new Jeu(jeu.get(0), jeu.get(1), jeu.get(2), argentMiser, connected, new TypeLotto("LOTTO"));
                        numeroTicket.setText(jeuJouerParUtilisateurConnecter.getTicket());
                        jeuEffectuer.setText(jeuJouerParUtilisateurConnecter.getNum1() + "-"
                                + jeuJouerParUtilisateurConnecter.getNum2() + "-"
                                + jeuJouerParUtilisateurConnecter.getNum3());
                        montant.setText(String.valueOf(jeuJouerParUtilisateurConnecter.getMontantMise()));
                        break;
                    case 4:
                        jeuJouerParUtilisateurConnecter
                                = new Jeu(jeu.get(0), jeu.get(1), jeu.get(2), jeu.get(3), argentMiser, connected, new TypeLotto("LOTTO"));
                        numeroTicket.setText(jeuJouerParUtilisateurConnecter.getTicket());
                        jeuEffectuer.setText(jeuJouerParUtilisateurConnecter.getNum1() + "-"
                                + jeuJouerParUtilisateurConnecter.getNum2() + "-"
                                + jeuJouerParUtilisateurConnecter.getNum3() + "-"
                                + jeuJouerParUtilisateurConnecter.getNum4()
                        );
                        montant.setText(String.valueOf(jeuJouerParUtilisateurConnecter.getMontantMise()));
                        break;
                    case 5:
                        jeuJouerParUtilisateurConnecter
                                = new Jeu(jeu.get(0), jeu.get(1), jeu.get(2), jeu.get(3), jeu.get(4), argentMiser, connected, new TypeLotto("LOTTO"));
                        numeroTicket.setText(jeuJouerParUtilisateurConnecter.getTicket());
                        jeuEffectuer.setText(jeuJouerParUtilisateurConnecter.getNum1() + "-"
                                + jeuJouerParUtilisateurConnecter.getNum2() + "-"
                                + jeuJouerParUtilisateurConnecter.getNum3() + "-"
                                + jeuJouerParUtilisateurConnecter.getNum4() + "-"
                                + jeuJouerParUtilisateurConnecter.getNum5());
                        montant.setText(String.valueOf(jeuJouerParUtilisateurConnecter.getMontantMise()));
                        break;
                    case 6:
                        jeuJouerParUtilisateurConnecter
                                = new Jeu(jeu.get(0), jeu.get(1), jeu.get(2), jeu.get(3), jeu.get(4), jeu.get(5), argentMiser, connected, new TypeLotto("LOTTO"));
                        numeroTicket.setText(jeuJouerParUtilisateurConnecter.getTicket());
                        jeuEffectuer.setText(jeuJouerParUtilisateurConnecter.getNum1() + "-"
                                + jeuJouerParUtilisateurConnecter.getNum2() + "-"
                                + jeuJouerParUtilisateurConnecter.getNum3() + "-"
                                + jeuJouerParUtilisateurConnecter.getNum4() + "-"
                                + jeuJouerParUtilisateurConnecter.getNum5() + "-"
                                + jeuJouerParUtilisateurConnecter.getNumBonus());
                        montant.setText(String.valueOf(jeuJouerParUtilisateurConnecter.getMontantMise()));
                        break;
                    default:
                        notifierErreur("☆*: .｡. o(≧▽≦)o .｡.:* comment vous faites ");
                        break;

                }

                grilleDao = new GrilleDao();

                grilleDao.creerSampleGrille(jeuJouerParUtilisateurConnecter);
                tirageDao = new TirageDao();
                System.out.println(LocalDate.now());
                Tirage idTyrage = tirageDao.getByDateTirageSample(LocalDate.now());
                System.out.println(idTyrage);
                grilleDao.setTirageToNotYet(idTyrage.getIdTirage());

                Tirage tirageDujour = tirageDao.getTirage(jeuJouerParUtilisateurConnecter.getTypeLotto().getLibelle());

                

           

                    
                    
                   
           notification(3, "Veuillez patientez", "/coetus/bibendum/icon/clock.png"," processus en cours ");    
           Calcul calcul = new Calcul();
           int tirage [] = new int [6]; 
               tirage[0] = tirageDujour.getNumtir1();
               tirage[1] = tirageDujour.getNumtir2();
               tirage[2] = tirageDujour.getNumtir3();
               tirage[3] = tirageDujour.getNumtir4();
               tirage[4] = tirageDujour.getNumtir5();
               tirage[5] = tirageDujour.getNumtirbonus();
               
               int tableauDujoueur [] = new int[jeu.size()];
               
                for (int i = 0; i < jeu.size(); i++) {
                    tableauDujoueur[i] = jeu.get(i);
                }
                
                boolean found = calcul.aGagner(tableauDujoueur, tirage);
                
                if (found == true) {
                    float prix= calcul.givePriceTotheWinner(calcul.ordreGagner(tableauDujoueur, tirage), tableauDujoueur.length, argentMiser, coupJouer);
                    notifierAgagner(String.valueOf(prix));
                    connected.setPrixGagner(prix);
                    compteDao.depot(connected.getPseudo(), prix);
                    
                }else {
                       notification(6, "     Desole Mais vous avez perdu. \n Retentez vous y etes presque !    ", "/coetus/bibendum/icon/sad.png", " feleication ");  
                    }
{
                   
                }
                
               
           
           
          
           
            
            
                
            }
   }        
            
            
      
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            } catch (NullPointerException e) {
                System.err.println(e.getMessage()); 
                e.printStackTrace();
        }   catch(NumberFormatException nfe)   {
                System.err.println(nfe.getMessage());
               nfe.getLocalizedMessage();
               nfe.printStackTrace();
        } 
      }
    

    @FXML
    void effacer(ActionEvent event) {
        label.setText(" ");

    }
    
    public  void notifierErreur(String texte){
           Image image = new Image("/coetus/bibendum/icon/baseline_error.png");
            Notifications notifications = Notifications.create()
                    .title("    ERREUR   ")
                    .text(texte)
                    .graphic(new ImageView(image))
                    .hideAfter(Duration.seconds(3)) 
                    .position(Pos.TOP_CENTER);
                     
//            new FadeOutUp(label).play();
            notifications.show();
           
        
    }
    
    public void notification(int duree, String texte, String iconLink, String title){
        Image image = new Image(iconLink);
            Notifications notifications = Notifications.create()
                    .title("   "+title.toUpperCase()+"  ")
                    .text(texte)
                    .graphic(new ImageView(image))
                    .hideAfter(Duration.seconds(duree))
                    .position(Pos.TOP_CENTER);        
            notifications.show();
        
    }
    
    public void notifierAgagner(String solde){
        Image image = new Image("/coetus/bibendum/icon/bing-black.png");
            Notifications notifications = Notifications.create()
                    .title("   ERREUR   ")
                    .text("Bravo, vouz venez de gagner \n. Votre montant gagne est  "+solde)
                    .graphic(new ImageView(image))
                    .hideAfter(Duration.seconds(10)) 
                    .position(Pos.TOP_CENTER);
                     
            new Shake(label).setCycleCount(3).setDelay(Duration.seconds(1.5)).play();
            notifications.show();
    }

    public void userConnected(Compte unCompte) {
        connected = unCompte;
        userNameTopBar.setText(connected.getProprio().getPrenom() + " " + connected.getProprio().getNom());

    }

 
    public ArrayList<Integer> getTable(){
        
        ArrayList<Integer> integers = new ArrayList<>();
        if (label.getText() != null) {
            String [] receive = label.getText().trim().split("-");
            for (String receive1 : receive) {
                int intArray = Integer.parseInt(receive1);
                integers.add(intArray);
            }
        }
      
        return integers;
        
    }
    

    public int [] toArray() {
          int [] table = new int[6] ;
          
          try {
              if (label.getText() != null && label.getText().length() >= 5) {
            String[] receive ;
             receive =  label.getText().split("-");
            for (int i = 0; i < receive.length; i++) {
                int intArray = Integer.parseInt(receive[i]);
                table[i] = intArray;
            }
        }
            
        } catch (NumberFormatException e) {
              System.err.println("\n"+e.getMessage());
        }
         
        return table;
    }
   
   private LocalDateTime heurLocalDateTime;
    

       @Override
    public void initialize(URL url, ResourceBundle rb) {
        label.setStyle("-fx-font-size: 40px;");
         label.setStyle("-fx-border-width: 2px ; -fx-border-color:#5c057f;");
      
           Tooltip tooltipParie = new Tooltip("Le nombre de numero dont vous etes sur de trouver !! ");
           tooltipParie.setStyle("-fx-font-familly: Arial; -fx-font-size: 15px;");
           parie.setTooltip(tooltipParie);
           
           
           Tooltip tooltipmiser = new Tooltip("Le montant que vous miser. Il est obligatoire");
           tooltipmiser.setStyle("-fx-font-familly: Arial; -fx-font-size: 15px;");
           miseFiel.setTooltip(tooltipmiser);
      
           heurLocalDateTime = LocalDateTime.now();
         
    }

    
    public void  userData(Compte compte){
        connected = compte;
    }
    
    public static void main(String[] args) {
     

    }
}
