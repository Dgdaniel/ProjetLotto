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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class GrilleDao {
    

/**
 *   Ici c'est que la methode permet d'inserer le jeu 
 *   bon les elements joues par l'utilisateur
 * @param jeuUtilisateur
 * @return 
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
            
            if (jeuUtilisateur.getNum3() !=0 ) {
                 preparedStatement.setInt(4, jeuUtilisateur.getNum3());
            }else{
                preparedStatement.setString(4, null);
            }
            if (jeuUtilisateur.getNum4() != 0) {
                 preparedStatement.setInt(5, jeuUtilisateur.getNum4());
            }else{
                preparedStatement.setString(5, null);
            }
            
            if (jeuUtilisateur.getNum5()!= 0) {
                preparedStatement.setInt(6, jeuUtilisateur.getNum5());
            }else{
                preparedStatement.setString(6, null);
            }
            
            
            if (jeuUtilisateur.getNumBonus() != 0 ) {
                preparedStatement.setInt(8, jeuUtilisateur.getNumBonus());
            }else{
                preparedStatement.setString(8, null);
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





 public boolean creerSampleGrille(Grille jeuUtilisateur)
    {
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        
        String sql = "insert into grille(montantMise, num1, num2, "
                + "num3, num4, num5, Ticket, numBonus, idCompte, idTypeLotto )"
                + "values (?,?,?,?,?,?,?,?,?,?)";
        
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(GrilleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
           
            preparedStatement.setFloat(1, jeuUtilisateur.getMontantMise());
            preparedStatement.setInt(2, jeuUtilisateur.getNum1());
            preparedStatement.setInt(3, jeuUtilisateur.getNum2());
            
            if (jeuUtilisateur.getNum3() !=0 ) {
                 preparedStatement.setInt(4, jeuUtilisateur.getNum3());
            }else{
                preparedStatement.setString(4, null);
            }
            if (jeuUtilisateur.getNum4() != 0) {
                 preparedStatement.setInt(5, jeuUtilisateur.getNum4());
            }else{
                preparedStatement.setString(5, null);
            }
            
            if (jeuUtilisateur.getNum5()!= 0) {
                preparedStatement.setInt(6, jeuUtilisateur.getNum5());
            }else{
                preparedStatement.setString(6, null);
            }
            
            
            if (jeuUtilisateur.getNumBonus() != 0 ) {
                preparedStatement.setInt(8, jeuUtilisateur.getNumBonus());
            }else{
                preparedStatement.setString(8, null);
            }
           
           
            
            preparedStatement.setString(7, jeuUtilisateur.getTicket());
            
            preparedStatement.setInt(9, new CompteDao().getBypseudo(jeuUtilisateur.getJoueur().getPseudo()).getIdCompte()); 
            preparedStatement.setInt(10, new TypeLottoDao().getByLibelle(jeuUtilisateur.getTypeLotto().getLibelle()).getIdTypeLotto());
            
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
    /**
     * 
     * @return a collection of grille  
     */
    
    public ArrayList<Grille> getAll(){
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        ArrayList<Grille> grilleList = new ArrayList<>();
        String  retreive = "select * from grille where idTyrage is not null";
        
        try {
            preparedStatement = connection.prepareStatement(retreive);
        } catch (SQLException ex) {
            Logger.getLogger(GrilleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResultSet res = null;
        
        try {
            res =preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(GrilleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        try {
            
            while (res.next()) {

                grilleList.add(
                        new Grille(res.getInt(1),
                                res.getInt(3),
                                res.getInt(4),
                                res.getInt(5),
                                res.getInt(6),
                                res.getInt(7),
                                res.getInt(10),
                                res.getFloat(2),
                                new CompteDao().getById(res.getInt(11)),
                                res.getString(8),
                                new TypeLottoDao().getById(res.getInt(12)),
                                new TirageDao().getById(res.getInt(13)),
                                res.getDate(9).toLocalDate()));

            }
        } catch (SQLException ex) {
            Logger.getLogger(GrilleDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException npe){
            System.err.println(npe.getMessage());
            npe.printStackTrace();
            
        }
        
        return  grilleList;
    }
    /**
     * Permet de mettre l'id du tirage au grille qui n'ont pas encore de resultat ou de jeu 
     * @param idTyrage
     * @param date
     * @return 
     */
    
    
    public boolean setTirageToNotYet(int idTyrage){
         Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        
        String  retreive = "update grille set idTyrage = ? where idTyrage is null and date(dateJeu)= ?";
        
        try {
            preparedStatement = connection.prepareStatement(retreive);
        } catch (SQLException ex) {
            Logger.getLogger(GrilleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            preparedStatement.setInt(1, idTyrage);
            preparedStatement.setString(2, LocalDate.now().toString());
        } catch (SQLException ex) {
            Logger.getLogger(GrilleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       int y = 0;
        
        try {
           y = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GrilleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (y>0) {
            System.out.println(" Operation effectue ");
        }
            
        return  true ? y>0 : false;
    }
    
   public Grille getByNumeroTicket(String numeroTicket){
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        Grille grille = null;
        String  retreive = "select * from grille where Ticket = ?  ";
        
        try {
            preparedStatement = connection.prepareStatement(retreive);
        } catch (SQLException ex) {
            Logger.getLogger(GrilleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            preparedStatement.setString(1, numeroTicket);
        } catch (SQLException ex) {
            Logger.getLogger(GrilleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResultSet res = null;
        
        try {
            res = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(GrilleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        try {
            
            while (res.next()) {

                grille =    new Grille(res.getInt(1),
                                res.getInt(3),
                                res.getInt(4),
                                res.getInt(5),
                                res.getInt(6),
                                res.getInt(7),
                                res.getInt(10),
                                res.getFloat(2),
                                new CompteDao().getById(res.getInt(11)),
                                res.getString(8),
                                new TypeLottoDao().getById(res.getInt(12)),
                                new TirageDao().getById(res.getInt(13)),
                                res.getDate(9).toLocalDate());

            }
        } catch (SQLException ex) {
            Logger.getLogger(GrilleDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException npe){
            System.err.println(npe.getMessage());
            npe.printStackTrace();
            
        }
        
        return  grille;
   }
   
   
   public void getTirage(){
       
   }
}
