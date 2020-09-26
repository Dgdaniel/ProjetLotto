/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.dao;

import coetus.bibendum.connexion.Connexion;
import coetus.bibendum.modele.Calcul;
import coetus.bibendum.modele.Grille;
import coetus.bibendum.modele.Tirage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class GrilleDao {
    
    /*
    ------------------------------------------------------------------
        Ici c'est que la methode permet d'inserer le jeu 
    bon les elements joues par l'utilisateur
    -------------------------------------------------
    */

     
    public boolean creerGrille(Grille jeuUtilisateur)
    {
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        
        String sql = "insert into grille(montantMise, num1, num2, "
                + "num3, num4, num5, Ticket, numBonus, idCompte, idTypeLotto, idTyrage )"
                + "values (?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(GrilleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
           
            preparedStatement.setFloat(1, jeuUtilisateur.getMontantMise());
            preparedStatement.setInt(2, jeuUtilisateur.getNum1());
            preparedStatement.setInt(3, jeuUtilisateur.getNum2());
        
            if (jeuUtilisateur.getNum3() == 0) {

            } else {
                preparedStatement.setInt(4, jeuUtilisateur.getNum3());
            }
        
            if (jeuUtilisateur.getNum4() == 0) {
                
            }else{
                preparedStatement.setInt(5, jeuUtilisateur.getNum4());
            }
            
            if (jeuUtilisateur.getNum5() == 0) {
                
            }else{
                preparedStatement.setInt(6, jeuUtilisateur.getNum5());
            }
            
            preparedStatement.setString(7, jeuUtilisateur.getTicket());
            
            if (jeuUtilisateur.getNumBonus() == 0 ) {
                
            }else{
                preparedStatement.setInt(8, jeuUtilisateur.getNumBonus()); 
            }
            
            preparedStatement.setInt(9, new CompteDao().getBypseudo(jeuUtilisateur.getJoueur().getPseudo()).getIdCompte()); 
            preparedStatement.setInt(10, new TypeLottoDao().getByLibelle(jeuUtilisateur.getTypeLotto().getLibelle()).getIdTypeLotto());
            
            Calcul calcul = new Calcul();
            int[] tirageTableau = calcul.genererTirage();
            int numBonus = calcul.GenererNumeroBonus();
            Tirage tirage = new Tirage(tirageTableau[0], tirageTableau[1], tirageTableau[2], tirageTableau[3], tirageTableau[4], numBonus);
            TirageDao tirageDao = new TirageDao();
            tirageDao.creerTirage(tirage);
            int mois = LocalDate.now().getMonthValue();
            int minute = LocalDateTime.now().getMinute();
            int heure = LocalDateTime.now().getHour();
            int seconde = LocalDateTime.now().getSecond();
            int jour = LocalDate.now().getDayOfMonth();
            System.out.println(mois +"\t" + jour +"\t" + heure +"\t" + minute +"\t" + seconde);
            
            preparedStatement.setInt(11, new TirageDao().getByHourMinuteAndMounth(mois, heure, minute, seconde, jour).getIdTirage());
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GrilleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        int result = 0;
        try {
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GrilleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            if(result > 0)
                System.out.println("Insertion reussi");
        
        return true ? result > 0 : false;
    }
    
}
