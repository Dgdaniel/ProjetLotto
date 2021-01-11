/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 * 

 */
package coetus.bibendum.dao;

import coetus.bibendum.connexion.Connexion;
import coetus.bibendum.modele.Compte;
import coetus.bibendum.modele.Personne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.NumberBinding;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Daniel
 */
public class CompteDao {
   
    /**
     *  Cette methode permet de creer un compte avec une personne existante ou non
     * @param unCompte
     * @return 
     */
    public boolean creerComptePersonne(Compte unCompte)
    {
         int b = 1;
            boolean bool = verifierPseudo(unCompte.getPseudo().get());
            
            if (bool == true ) {
                System.err.println("Veullez choisir un autre pseudo ");
            }else{
                     
            PersonneDao personneDao = new PersonneDao();
            Personne per  = personneDao.getByNom(unCompte.getProprio().getNom().get());
        
            if (per == null) {
                personneDao.createPersonne(unCompte.getProprio());
            }
            
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = "insert into compte(pseudo, motDePasse, solde, idPersonne) values (?,?,?,?)";
        
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            preparedStatement.setString(1, unCompte.getPseudo().get());
            preparedStatement.setString(2, unCompte.getMotDePasse().get());
            preparedStatement.setFloat(3, unCompte.getSolde().get());
            preparedStatement.setInt(4, new PersonneDao().getByNom(unCompte.getProprio().getNom().get()).getIdpersonne().get());
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        try {
            b = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        if (b>0) {
            System.out.println("Insertion reussi ");
        }
         
            }
           
        
        
        return true ? b> 0 : false;
    }
    
    
    
    /**
     *  Cette methode permet de creer un compte
     * @param unCompte
     * @return 
     */
    public boolean creerCompte(Compte unCompte) {
        int b = 0;
        boolean fait = false;      
        boolean bool = verifierPseudo(unCompte.getPseudo().get());
        if (bool == true) {
            System.err.println(" Veuillez choisir un nouveau pseudo !. Ce pseudo existes deja dans la base");
        } else {
            Connection connection = Connexion.getConnexion();
            PreparedStatement preparedStatement = null;
            String sql = "insert into compte(pseudo, motDePasse, solde, idPersonne) values (?,?,?,?)";

            try {
                preparedStatement = connection.prepareStatement(sql);
            } catch (SQLException ex) {
                Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                preparedStatement.setString(1, unCompte.getPseudo().get());
                preparedStatement.setString(2, unCompte.getMotDePasse().get());
                preparedStatement.setFloat(3, unCompte.getSolde().get());
                preparedStatement.setInt(4, new PersonneDao().getByNom(unCompte.getProprio().getNom().get()).getIdpersonne().get());
            } catch (SQLException ex) {
                Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                b = preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            }
             
       
          
            if (b > 0) {
                System.out.println("Insertion reussi ");
                fait = true;
            }

        }
       
        
        return fait;

    }
    /**
     * 
     * @param Id
     * @return 
     */
       
    public Compte getById(int Id) {
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        Compte compte = null;

        String sql = "Select * from compte where idCompte = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            preparedStatement.setInt(1, Id);
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet resultSet = null;

        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (resultSet.next()) {
                compte = new Compte( new SimpleIntegerProperty(resultSet.getInt(1))
                        , new SimpleStringProperty(resultSet.getString(2)) ,new SimpleStringProperty(resultSet.getString(3)),
                         new SimpleFloatProperty(resultSet.getFloat(4)),  new SimpleFloatProperty(resultSet.getFloat(5)),
                 resultSet.getDate(6).toLocalDate(),  new PersonneDao().getById(resultSet.getInt(7)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return compte;
    }
       
       
      /**
       * Cette methode retourne un personne en prenant en parametre son pseudo
       * @param pseudoAverifier
       * @return 
       */ 
     public boolean verifierPseudo(String pseudoAverifier) {
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = "select * from compte where pseudo = ? ";
        ResultSet rs = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            preparedStatement.setString(1, pseudoAverifier);
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (!rs.next()) {
                rs = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true ? rs != null : false;
    }

       
       /*
       ------------------------------------------------------------------------
       Retourne une personne grace a son pseudo qui biensur unique 
       -----------------------------------------------------------------
       */
    
    public Compte getBypseudo(String pseudo)
       {
            Connection connection = Connexion.getConnexion();
           PreparedStatement preparedStatement = null;
           Compte compte = null;
           String sql = "select * from compte where pseudo = ? ";
           ResultSet rs = null;
           
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
            preparedStatement.setString(1, pseudo);
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
        try {
             rs = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        try {
            while (rs.next()) {
                compte = new Compte( new SimpleIntegerProperty(rs.getInt(1)) , 
                        new SimpleStringProperty(rs.getString(2)),
                        new SimpleStringProperty(rs.getString(3)), 
                        new SimpleFloatProperty(rs.getFloat(4)) , 
                        new SimpleFloatProperty(rs.getFloat("prixGagner")),
                        rs.getDate(6).toLocalDate(),  new PersonneDao().getById(rs.getInt(7))); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
           return compte;
       }

       /**
        * 
        * @param IdCompte
        * @return 
        */
   public boolean deleteById(int IdCompte)
   {
       Connection connection = Connexion.getConnexion();
       PreparedStatement preparedStatement = null;
       String sql = "delete from compte where idCompte = ? ";
       
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            preparedStatement.setInt(1, IdCompte);
           
            
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int b = 0;
      
       
        try {
            b = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(b>0)
           System.out.println(" Object deleted ");
        
        return true ? b>0 : false;
   }
   
   /*
   -----------------------------------------------------------------------------
   Permet au proprietaire de faire des actions
   -----------------------------------------------------------------------------
   
   */
   
   /**
    * 
    */
   public void achat (String  PseudoCompte, float montantAchat){
       
       Connection connection = Connexion.getConnexion();
       PreparedStatement preparedStatement = null;
       String sql = "update compte set solde = ? where idCompte = ? ";
       Compte compte = getBypseudo(PseudoCompte);
       SimpleFloatProperty soldeFloatProperty = null;
      BooleanBinding bool =  compte.getSolde().greaterThan(new SimpleFloatProperty(montantAchat));
      
       if(bool.get() == true){
           soldeFloatProperty = (SimpleFloatProperty) compte.getSolde().subtract(new SimpleFloatProperty(montantAchat));
           compte.setSolde(soldeFloatProperty);
       }
            
           
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (soldeFloatProperty!=null) {
                 preparedStatement.setFloat(1, soldeFloatProperty.getValue());
            }
           
            preparedStatement.setInt(2, compte.getIdCompte().get());
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
   }
   
   /*
   -----------------------------------------------------------------
   methode pour faire un depot sur le compte
   ---------------------------------------------
   */
   /**
    * 
    * @param PseudoCompte
    * @param montantDepot
    * @return 
    */
   public boolean depot (String PseudoCompte, float montantDepot)
   {
       
       Connection connection = Connexion.getConnexion();
       PreparedStatement preparedStatement = null;
       String sql = "update compte set solde = ? where idCompte = ? ";
       Compte compte = getBypseudo(PseudoCompte);
//       SimpleFloatProperty montant = compte.getSolde() + montantDepot;
       NumberBinding montant = null;
    
            
         if (compte != null ) {
           montant = compte.getSolde().add(new SimpleFloatProperty(montantDepot));
           compte.setSolde((SimpleFloatProperty) montant);
                   }
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            preparedStatement.setFloat(1, montant.getValue().floatValue());
            preparedStatement.setInt(2, compte.getIdCompte().get());
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         int b = 0;
        try {
            b = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (b>0) {
            System.out.println(" Depot effectuer ");
       }
        
      return true ? b>0 : false;
   }
      
  /*
  -----------------------------------------------------------------
   methode pour tranferer de l'argent a un autre 
   -----------------------------------------------------------------
   */
   
    public boolean transfert(String pseudoCompte, String destinatairePseudo, float montantTransfert) {
        achat(pseudoCompte, montantTransfert);
        boolean b = depot(destinatairePseudo, montantTransfert);

        return b;

    }
    
    /*
    ------------------------------------------------------------
    methode pour se connecter il verifie a la fois le pseudo et 
    le mot de passe 
    --------------------------------------------------------------
    */
    
    public  Compte getByPseudoPassWord(String pseudo, String pass){
         {
            Connection connection = Connexion.getConnexion();
           PreparedStatement preparedStatement = null;
           Compte compte = null;
           String sql = "select * from compte where pseudo =? and motDePasse =?";
           ResultSet rs = null;
           
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
            preparedStatement.setString(1, pseudo);
            preparedStatement.setString(2, pass);
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
        try {
             rs = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        try {
            while (rs.next()) {
                compte = new Compte( new SimpleIntegerProperty(rs.getInt(1)) , 
                        new SimpleStringProperty(rs.getString(2)),
                        new SimpleStringProperty(rs.getString(3)), 
                        new SimpleFloatProperty(rs.getFloat(4)) , 
                        new SimpleFloatProperty(rs.getFloat("prixGagner")),
                        rs.getDate(6).toLocalDate(),  new PersonneDao().getById(rs.getInt(7))); }
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
           return compte;
       }
    }
    
    public boolean updateCompte(Compte unCompte){
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        Compte compte = new Compte();
        compte = getBypseudo(unCompte.getPseudo().getValue());
        String sql = "update compte  set motDePasse = ?, prixGagner = ? , solde = ? where idCompte = ? ";

        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            preparedStatement.setString(1, unCompte.getMotDePasse().get());
            if (unCompte.getPrixGagner().get() != 0) {
                preparedStatement.setFloat(2, compte.getPrixGagner().get());
            } else {
                preparedStatement.setString(2, null);
            }
            preparedStatement.setFloat(3, unCompte.getSolde().get());

            preparedStatement.setInt(4, compte.getIdCompte().get());
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        int b = 0;
        try {
            b = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (b>0) {
            System.out.println(" Depot effectuer ");
       }
        
      return true ? b>0 : false;
    }
    
   
}


