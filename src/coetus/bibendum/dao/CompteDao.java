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

/**
 *
 * @author Daniel
 */
public class CompteDao {
    /*
    --------------------------------------------------------------------------
    Cette methode permet de creer un compte avec une personne existante ou non
    --------------------------------------------------------------------------
    */
    
    public boolean creerComptePersonne(Compte unCompte)
    {
         int b = 1;
            boolean bool = verifierPseudo(unCompte.getPseudo());
            
            if (bool == true ) {
                System.err.println("Veullez choisir un autre pseudo ");
            }else{
                     
            PersonneDao personneDao = new PersonneDao();
            Personne per  = personneDao.getByNom(unCompte.getProprio().getNom());
        
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
            preparedStatement.setString(1, unCompte.getPseudo());
            preparedStatement.setString(2, unCompte.getMotDePasse());
            preparedStatement.setFloat(3, unCompte.getSolde());
            preparedStatement.setInt(4, new PersonneDao().getByNom(unCompte.getProprio().getNom()).getIdpersonne());
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
    
    /*
    ----------------------------------------------------------------------------
    Cette methode permet de creer un compte
    ----------------------------------------------------------------------------
    */
    
    public boolean creerCompte(Compte unCompte) {
        int b = 0;
        boolean bool = verifierPseudo(unCompte.getPseudo());
        if (bool == true) {
            System.err.println("Veuillez choisir un nouveau pseudo !");
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
                preparedStatement.setString(1, unCompte.getPseudo());
                preparedStatement.setString(2, unCompte.getMotDePasse());
                preparedStatement.setFloat(3, unCompte.getSolde());
                preparedStatement.setInt(4, new PersonneDao().getByNom(unCompte.getProprio().getNom()).getIdpersonne());
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
            }

        }

        return true ? b > 0 : false;
    }
    
       
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
                compte = new Compte(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getFloat(4), resultSet.getFloat(5),
                        new PersonneDao().getById(resultSet.getInt(7)),
                        resultSet.getDate(6).toLocalDate());
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return compte;
    }
       
       /*
       -------------------------------------------------------------------------
       Cette methode retourne un personne en prenant en parametre son pseudo
       -------------------------------------------------------------------------
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
                compte = new Compte(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), 
                        rs.getDate(6).toLocalDate(),  new PersonneDao().getById(rs.getInt(7))); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
           return compte;
       }

/*
--------------------------------------------------------------------------------
Cette methode permet de supprimer un compte 
--------------------------------------------------------------------------------    
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
   
   
   public void achat (String  PseudoCompte, float montantAchat){
       
       Connection connection = Connexion.getConnexion();
       PreparedStatement preparedStatement = null;
       String sql = "update compte set solde = ? where idCompte = ? ";
       Compte compte = getBypseudo(PseudoCompte);
        if (compte.getSolde() > montantAchat) {
            float montant = compte.getSolde() - montantAchat;
           
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            preparedStatement.setFloat(1, montant);
            preparedStatement.setInt(2, compte.getIdCompte());
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       }else{
            System.err.println("Montant insuffisant pour effectuer ! ");
        }
       
       
   }
   
   /*
   -----------------------------------------------------------------
   methode pour faire un depot sur le compte
   ---------------------------------------------
   */
   
   public boolean depot (String PseudoCompte, float montantDepot)
   {
       
       Connection connection = Connexion.getConnexion();
       PreparedStatement preparedStatement = null;
       String sql = "update compte set solde = ? where idCompte = ? ";
       Compte compte = getBypseudo(PseudoCompte);
       float montant = compte.getSolde() + montantDepot;
       
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            preparedStatement.setFloat(1, montant);
            preparedStatement.setInt(2, compte.getIdCompte());
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
}
