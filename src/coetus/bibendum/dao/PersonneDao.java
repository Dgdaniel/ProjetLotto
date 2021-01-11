
package coetus.bibendum.dao;

import coetus.bibendum.connexion.Connexion;
import coetus.bibendum.modele.Compte;
import coetus.bibendum.modele.Personne;
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
public class PersonneDao {
    
 
    /**
     * Cette methode insert une personne dans la base de donnee et renvoie 
        vrai si l'insertion a reussi faux sinon
     * @param p
     * @return 
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
            preparedStatement.setString(1, p.getNom().get());
            preparedStatement.setString(2, p.getPrenom().get());
            preparedStatement.setInt(3, p.getAge().get());
            preparedStatement.setString(4, p.getSexe().get());
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int b = 1;
        
        try {
            b = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean fait = false;
          if (b > 0) {
            System.out.println(" objet supprimer !");
             fait = true;
        }
        
        return fait;
    }
    
    
   
    /**
     * retreive a user by it's name from the database 
     * this method take as a parameter a string and return an object Person
     * @param nom
     * @return 
     */
        public Personne getByNom(String nom)
    {
        Connection conn = Connexion.getConnexion();
        Personne personne = null ;
        PreparedStatement pstatement = null;
        String sql = "select * from personne where nom = ? ";
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
            personne = new Personne(new SimpleIntegerProperty(resultSet.getInt(1)), 
                    new SimpleStringProperty( resultSet.getString(2)) , new SimpleStringProperty(resultSet.getString(3)) , 
                    new SimpleIntegerProperty(resultSet.getInt(4)) , new SimpleStringProperty(resultSet.getString(5)) );
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return personne;
    }
    
    

    
    /**
     * This method return an object of type person by it's Id
     * @param Id
     * @return 
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
               personne = new Personne(new SimpleIntegerProperty(resultSet.getInt(1)), 
                    new SimpleStringProperty( resultSet.getString(2)) , new SimpleStringProperty(resultSet.getString(3)) , 
                    new SimpleIntegerProperty(resultSet.getInt(4)) , new SimpleStringProperty(resultSet.getString(5)) );
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return personne;
    }
    
    
    /**
     *   Cette methode permet de supprimer une personne en prenant en 
        parametre un nom 
     * @param nom
     * @return 
     */
        public boolean deleteByNom(String nom)
    {
       boolean fait = false;
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
            preparedStatement.setInt(1, personne.getIdpersonne().get());
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
            fait = true;
        }
        return fait;
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
        
        boolean fait = false;
        
         if (res > 0) {
            System.out.println(" objet supprimer !");
            fait = true;
        }
        return fait;
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
            preparedStatement.setString(1, nouvellePersonne.getNom().get());
            preparedStatement.setInt(2, retreive.getIdpersonne().get());
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int res = 1;
        
        try {
            res = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       boolean fait = false;
          if (res > 0) {
            System.out.println(" objet supprimer !");
             fait = true;
        }
        
        return fait;
    }
    
     
    /**
     * Cette methode permet de modifier le prenom de la personne
     * @param old
     * @param newPrenom
     * @return 
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
            preparedStatement.setString(1, newPrenom.getPrenom().get() );
            preparedStatement.setString(2, retreive.getPrenom().get());
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
    
   
    /**
     * Cette methode permet de modifier l'age de la personne 
     * @param old
     * @param newAge
     * @return 
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
            preparedStatement.setInt(1, newAge.getAge().get() );
            preparedStatement.setInt(2, retreive.getIdpersonne().get());
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int res = 1;
        
        try {
            res = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
      boolean fait = false;
          if (res > 0) {
            System.out.println(" objet supprimer !");
             fait = true;
        }
        
        return fait;
    }
    
    
     /*
    ----------------------------------------------------------------------------
        
    ----------------------------------------------------------------------------
    */
    /**
     * Cette methode permet de recupere la liste des personnes
     * @return 
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
                lofPersonnes.add( new Personne(new SimpleIntegerProperty(res.getInt(1)), 
                    new SimpleStringProperty( res.getString(2)) , new SimpleStringProperty(res.getString(3)) , 
                    new SimpleIntegerProperty(res.getInt(4)) , new SimpleStringProperty(res.getString(5))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return lofPersonnes;
    }
    
    
    public boolean updatePerson(Compte unCompte, Personne personne){
         Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = "update personne set nom = ? , prenom=?, age = ? , sexe = ?  where idPersonne = ? ";
        PersonneDao personneDao = new PersonneDao();
        CompteDao compteDao = new CompteDao();
        Personne retreive = new Personne();
        Compte r = new Compte();
        r = compteDao.getBypseudo(unCompte.getPseudo().get());
        retreive = r.getProprio();
        
  
         
          try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
         
            preparedStatement.setString(1, personne.getNom().get() );
            preparedStatement.setString(2, personne.getPrenom().get());
            preparedStatement.setInt(3, personne.getAge().get());
            if (personne.getSexe()!=null) {
                 preparedStatement.setString(4, personne.getSexe().get());
            }else{
                  preparedStatement.setString(4, null);
            }
            preparedStatement.setInt(5, retreive.getIdpersonne().get());
           
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int res = 1;
        
        try {
            res = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       boolean fait = false;
          if (res > 0) {
            System.out.println(" objet supprimer !");
             fait = true;
        }
        
        return fait;
    }
}
