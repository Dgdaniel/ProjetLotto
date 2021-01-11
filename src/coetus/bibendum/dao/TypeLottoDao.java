/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.dao;

import coetus.bibendum.connexion.Connexion;
import coetus.bibendum.modele.TypeLotto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Daniel
 */
public class TypeLottoDao {
    
    public boolean creerTypeLotto(TypeLotto unTypeLotto){
        
        Connection conn= Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = "insert into typelotto(idTypeLotto, libelleLotto) values (?,?) ";
        
        try {
            preparedStatement = conn.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TypeLottoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            preparedStatement.setInt(1, unTypeLotto.getIdTypeLotto().get());
            preparedStatement.setString(2, unTypeLotto.getLibelle().get());
        } catch (SQLException ex) {
            Logger.getLogger(TypeLottoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        int res = 1;
        try {
           res =  preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TypeLottoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (res>0) {
            System.out.println("Insertion reussi ");
        }
        return true ? res >0 :false;
    }
    
    
    public TypeLotto getById(int Id){
        
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = (" select * from typelotto where idTypeLotto = ?");
        TypeLotto newTypeLotto = null;
        ResultSet rs = null;
        
          try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            preparedStatement.setInt(1, Id);
        } catch (SQLException ex) {
            Logger.getLogger(TypeLottoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        try {
            rs= preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(TypeLottoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while(rs.next())
            newTypeLotto = new TypeLotto(
                    new SimpleIntegerProperty(rs.getInt(1)),
                    new SimpleStringProperty( rs.getString(2)));
        } catch (SQLException ex) {
            Logger.getLogger(TypeLottoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  newTypeLotto;
        
    }
    
    
    public TypeLotto getByLibelle(String lib){
        
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = (" select * from typelotto where libelleLotto = ?");
        TypeLotto newTypeLotto = null;
        ResultSet rs = null;
        
          try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            preparedStatement.setString(1, lib);
        } catch (SQLException ex) {
            Logger.getLogger(TypeLottoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        try {
            rs= preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(TypeLottoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while (rs.next()) {                
                newTypeLotto = new TypeLotto(  new SimpleIntegerProperty(rs.getInt(1)),
                    new SimpleStringProperty( rs.getString(2))); 
            }
   
        } catch (SQLException ex) {
            Logger.getLogger(TypeLottoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  newTypeLotto;
        
    }
    
    public boolean updateNom(String oldlib, TypeLotto newlib){
        
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = ("update typelotto set libelleLotto = ? where idTypeLotto = ?");
        TypeLotto retreive = getByLibelle(oldlib);
         try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            preparedStatement.setString(1, newlib.getLibelle().get());
            preparedStatement.setInt(2, retreive.getIdTypeLotto().get() );
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
    
    
    
    
    public List<TypeLotto> getAll()
    {
        
        
        List<TypeLotto> lofTypeLotto = new ArrayList<>();
         Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = "select * from typelotto ";
        
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
                lofTypeLotto.add(new TypeLotto(  new SimpleIntegerProperty(res.getInt(1)),
                    new SimpleStringProperty( res.getString(2))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return lofTypeLotto;
    }
    
    
}
