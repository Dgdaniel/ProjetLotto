/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class Connexion {
    
    private final static  String JDBCURL = "com.mysql.jdbc.Driver"; 
  private final static String URL = "jdbc:mysql://localhost:3306/lotery?useSSL=false";
  private final static String USER = "root";
  private final static String PASS = "";
  
  
  public  static Connection getConnexion(){
      Connection connection = null;
      
      try {
          Class.forName(JDBCURL);
          System.out.println("Importation driver réussi !");
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      try {
          connection = DriverManager.getConnection(URL,USER, PASS);
          System.out.println("Database connected");
      } catch (SQLException ex) {
          Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      
      return connection;
  }
    
    
}


