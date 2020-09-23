/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.dao;

import coetus.bibendum.connexion.Connexion;
import coetus.bibendum.modele.Personne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class PersonneDao {
    
    /*
    ----------------------------------------------------------------------------
        Cette methode insert une personne dans la base de donnee et renvoie 
        vrai si l'insertion a reussi faux sinon
    ----------------------------------------------------------------------------
    */
    
    public boolean createPersonne(Personne p)
    {
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = "insert into personne(nom, prenom, age, sexe) values (?,?,?,?);";
        
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            preparedStatement.setString(1, p.getNom());
            preparedStatement.setString(2, p.getPrenom());
            preparedStatement.setInt(3, p.getAge());
            preparedStatement.setString(4, p.getSexe());
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int b = 1;
        
        try {
            b = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (b>0) {
            System.out.println("Insertion reussi ");
        }
        
        return true ? b> 0 : false;
    }
    
    
    /* 
    ----------------------------------------------------------------------------
     retreive a user by it's name from the database 
     this methode take as a parameter a string and return an object Personne
    ----------------------------------------------------------------------------  
     */
    public Personne getByNom(String nom)
    {
        Connection conn = Connexion.getConnexion();
        Personne personne = null ;
        PreparedStatement pstatement = null;
        String sql = "select * from personne where nom = ? limit 2";
        try {
            pstatement = conn.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            pstatement.setString(1, nom);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResultSet resultSet = null;
        
        try {
            resultSet = pstatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while(resultSet.next())
            personne = new Personne(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5));
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return personne;
    }
    
    
    /*
    ----------------------------------------------------------------------------
    Cette methode retourne un objet de type personne grace a son id
    ----------------------------------------------------------------------------
    */
    
    
    public Personne getById(int Id)
    {
          
        Connection conn = Connexion.getConnexion();
        Personne personne = null ;
        PreparedStatement pstatement = null;
        String sql = "select * from personne where idPersonne = ?";
        try {
            pstatement = conn.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            pstatement.setInt(1, Id);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResultSet resultSet = null;
        
        try {
            resultSet = pstatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while(resultSet.next()){
               personne = new Personne(resultSet.getInt(1), resultSet.getString(2), 
                       resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5)); 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return personne;
    }
    /*
    ----------------------------------------------------------------------------
        Cette methode permet de supprimer une personne en prenant en 
        parametre un nom 
    ----------------------------------------------------------------------------
    */
        public boolean deleteByNom(String nom)
    {
       
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = "delete from personne where idPersonne = ? ";
         Personne personne = getByNom(nom);
         
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            preparedStatement.setInt(1, personne.getIdpersonne());
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int res = 0;
        
        try {
            res = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (res > 0) {
            System.out.println(" objet supprimer !");
        }
        return true ? res > 0: false;
    }
    
    
   public boolean deleteById(int Id)
   {
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = "delete from personne where idPersonne = ? ";
        
           try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            preparedStatement.setInt(1, Id);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int res = 0;
        
        try {
            res = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (res > 0) {
            System.out.println(" objet supprimer !");
        }
        return true ? res > 0: false;
   }
    
    /*
    ----------------------------------------------------------------------------
        Cette methode permet de modifier le nom de la personne 
    ----------------------------------------------------------------------------
    
    */
   
    public boolean updateNom(String nom, Personne nouvellePersonne)
    {
        
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = "update personne set nom = ? where idPersonne = ? ";
        Personne retreive = getByNom(nom);
          try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            preparedStatement.setString(1, nouvellePersonne.getNom());
            preparedStatement.setInt(2, retreive.getIdpersonne());
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int res = 1;
        
        try {
            res = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (res > 0) {
            System.out.println(" Modification effectuer !");
        }
        return true ? res > 0: false;
    }
    
     /*
    ----------------------------------------------------------------------------
        Cette methode permet de modifier le prenom de la personne 
    ----------------------------------------------------------------------------
    
    */
    
    public boolean updatePrenom(String old, Personne newPrenom )
    {
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = "update personne set prenom = ? where idPersonne = ? ";
        Personne retreive = getByNom(old);
          try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            preparedStatement.setString(1, newPrenom.getPrenom() );
            preparedStatement.setString(2, retreive.getPrenom());
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int res = 1;
        
        try {
            res = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (res > 0) {
            System.out.println(" Modification effectuer ! Nouveau prenom est "+newPrenom);
        }
        return true ? res > 0: false;
    }
    
     /*
    ----------------------------------------------------------------------------
        Cette methode permet de modifier l'age de la personne 
    ----------------------------------------------------------------------------
    */
    
    public boolean updateAge(String old, Personne newAge)
    {
         Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = "update personne set age = ? where idPersonne = ? ";
        Personne retreive = getByNom(old);
          try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            preparedStatement.setInt(1, newAge.getAge() );
            preparedStatement.setInt(2, retreive.getIdpersonne());
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int res = 1;
        
        try {
            res = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (res > 0) {
            System.out.println(" Modification effectuer ! ");
        }
        return true ? res > 0: false;
    }
    
    
     /*
    ----------------------------------------------------------------------------
        Cette methode permet de recupere la liste des personnes
    ----------------------------------------------------------------------------
    */
    public List<Personne> getAll()
    {
        
        
        List<Personne> lofPersonnes = new ArrayList<>();
         Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = "select * from personne ";
        
        try {
            preparedStatement = connection.prepareCall(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResultSet res = null;
        
        try {
            res = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(res.next())
            {
                lofPersonnes.add(new Personne(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return lofPersonnes;
    }
    
    
}
