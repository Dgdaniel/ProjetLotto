/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.dao;

import coetus.bibendum.connexion.Connexion;
import coetus.bibendum.modele.Tirage;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class TirageDao {
    
    
    public boolean creerTirage(Tirage unTirage)
    {
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = "insert into tirage(num1, num2, num3, num4, num5, numTirageBonus, jourTirage) values (?,?,?,?,?,?,?)";
        
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            preparedStatement.setInt(1, unTirage.getNumtir1());
            preparedStatement.setInt(2, unTirage.getNumtir2());
            preparedStatement.setInt(3, unTirage.getNumtir3());
            preparedStatement.setInt(4, unTirage.getNumtir4());
            preparedStatement.setInt(5, unTirage.getNumtir5());
            preparedStatement.setInt(6, unTirage.getNumtirbonus());
            preparedStatement.setString(7, unTirage.getJourTirage());
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int b = 1;
        
        try {
            b = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (b>0) {
            System.out.println("Insertion reussi");
        }
        
        return true ? b> 0 : false;
    }
    /*
    ---------------------------------------------------------
    Retreive an boject with it's Id
    -----------------------------------
    */
    
    public Tirage getById(int Id)
    {
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
         Tirage tirageRecu =null;
        String sql = "select * from tirage where idTyrage = ? ";
         
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            preparedStatement.setInt(1, Id);
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet res = null;
        try {
            res = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
             while(res.next())
            tirageRecu = new Tirage(res.getInt(1), res.getInt(3), res.getInt(4), res.getInt(5), res.getInt(6),
                    res.getInt(7), res.getInt(8), res.getDate(2).toLocalDate(), res.getString(9));
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return tirageRecu;
    }
    /*
    ----------------------------------------------------------------------------
        Retreive from the database all the tirage 
    --------------------------------------------------------
    */
    public  List<Tirage> getAll(){
          
        List<Tirage> lofTirage = new ArrayList<>();
         Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = "select * from tirage ";
        
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
                lofTirage.add(new Tirage(res.getInt(1), res.getInt(2), res.getInt(3),res.getInt(3),
                        res.getInt(4),res.getInt(5),res.getInt(6), 
                        res.getDate(7).toLocalDate(),res.getString(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
       
        return lofTirage;
    }
    
    /*
    --------------------------------------------------------------------
    
    ------------------------------------------------
    */
    public boolean  deleteById(int Iddel)
    {
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = "delete from tirage where idTyrage = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            preparedStatement.setInt(1, Iddel);
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int b = 1;
        
        try {
            b = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return true ? b>0 : false;
    }
       
    
    /*
    -------------------------------------------------------
        Permet de recuoer un tirage grace a la date 
        et le jour de tirage
    ---------------------------------------------
    */
    
    
    public Tirage getByDateTirage(LocalDate dateTirage, String jourTirage){
        Connection  con = Connexion.getConnexion();
        PreparedStatement statement = null;
        Tirage retreive = null;
        
        String sql = "select * from tirage where date(dateTyrage) = ? and jourTirage = ?";
        try {
            statement = con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement.setDate(1, Date.valueOf(dateTirage));
            statement.setString(2, jourTirage);
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet res = null;
        
        try {
            res = statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while(res.next())
            {
                 retreive = new Tirage(res.getInt(1), res.getInt(3), res.getInt(4)
                         , res.getInt(5), res.getInt(6), res.getInt(7), res.getInt(8), 
                         res.getDate(2).toLocalDate(), res.getString(9));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retreive;
    }
    
    
    
    /*
    ---------------------------------------------------------
        Cette methode permet de recuperer un tirage 
       par sa date 
    ---------------------------------
    */
    
    public Tirage getByDateTirage(LocalDate date){
        
        Connection  con = Connexion.getConnexion();
        PreparedStatement statement = null;
        Tirage retreive = null;
        
        String sql = "select * from tirage where date(dateTyrage) = ?";
        try {
            statement = con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement.setDate(1, Date.valueOf(date));
       
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet res = null;
        
        try {
            res = statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while(res.next())
            {
                 retreive = new Tirage(res.getInt(1), res.getInt(3), res.getInt(4)
                         , res.getInt(5), res.getInt(6), res.getInt(7), res.getInt(8), 
                         res.getDate(2).toLocalDate(), res.getString(9));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retreive;
    }
    
    /*
    ---------------------------------------------------
        permettant de recuper un tirage par la date 
    ---------------------------
    */
    
    public Tirage getByJourTirage(String jour){
        
        Connection connection = Connexion.getConnexion();
        PreparedStatement statement = null;
        Tirage fresh = null;
     
        
        String retreive = "select * from tirage where jourTirage = ? ";
        try {
            statement = connection.prepareCall(retreive);
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        try {
            statement.setString(1, jour);
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet res = null;
        
        try {
            res = statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            while(res.next())
            {
                fresh = new Tirage(res.getInt(1),res.getInt(3), res.getInt(4), res.getInt(5),
                        res.getInt(6), res.getInt(7), res.getDate(2).toLocalDate(), res.getString(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return fresh;
    }
    
    
    /*
    ----------------------------------------------------------------
        En fait j'aimerais recuperer la dernieres insertion 
        par intervalle de minute 
    ----------------------------------------
    */
    
    
    
}
