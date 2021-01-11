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

    public boolean creerTirage(Tirage unTirage) {
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = "insert into tirage(num1, num2, num3, num4, num5, numTirageBonus, jourTirage, TypeLotto) values (?,?,?,?,?,?,?, ?)";

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
            preparedStatement.setString(8, unTirage.getTypeJouer());

        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        int b = 1;

        try {
            b = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (b > 0) {
            System.out.println("Insertion reussi");
        }

        return true ? b > 0 : false;
    }

    /*
    ---------------------------------------------------------
    Retreive an boject with it's Id
    -----------------------------------
     */

    public Tirage getById(int Id) {
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        Tirage tirageRecu = null;
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
            while (res.next()) {
                tirageRecu = new Tirage(res.getInt("idTyrage"), res.getInt("num1"), res.getInt("num2"), res.getInt("num3"),
                       res.getInt("num4"), res.getInt("num5"), res.getInt("numtirageBonus"),
                       res.getDate("dateTyrage").toLocalDate(), res.getString("jourTirage"), res.getString("TypeLotto"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
    public List<Tirage> getAll() {

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
            while (res.next()) {
                lofTirage.add( new Tirage(res.getInt("idTyrage"), res.getInt("num1"), res.getInt("num2"), res.getInt("num3"),
                       res.getInt("num4"), res.getInt("num5"), res.getInt("numtirageBonus"),
                       res.getDate("dateTyrage").toLocalDate(), res.getString("jourTirage"), res.getString("TypeLotto")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
    public boolean deleteById(int Iddel) {
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
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return true ? b > 0 : false;
    }

    /*
    -------------------------------------------------------
        Permet de recuoer un tirage grace a la date 
        et le jour de tirage
    ---------------------------------------------
     */
    public Tirage getByDateTirage(LocalDate dateTirage, String jourTirage) {
        Connection con = Connexion.getConnexion();
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
            while (res.next()) {
                retreive   = new Tirage(res.getInt("idTyrage"), res.getInt("num1"), res.getInt("num2"), res.getInt("num3"),
                       res.getInt("num4"), res.getInt("num5"), res.getInt("numtirageBonus"),
                       res.getDate("dateTyrage").toLocalDate(), res.getString("jourTirage"), res.getString("TypeLotto"));
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
    public Tirage getByDateTirageSample(LocalDate date) {

        Connection con = Connexion.getConnexion();
        PreparedStatement statement = null;
        Tirage retreive = null;

        String sql = "select * from tirage where date(dateTyrage) = ? ";
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
            while (res.next()) {
                retreive =   new Tirage(res.getInt("idTyrage"), res.getInt("num1"), res.getInt("num2"), res.getInt("num3"),
                       res.getInt("num4"), res.getInt("num5"), res.getInt("numtirageBonus"),
                       res.getDate("dateTyrage").toLocalDate(), res.getString("jourTirage"), res.getString("TypeLotto"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retreive;
    }

    /**
     * permettant de recuper un tirage par la date
     *
     * @param jour
     * @return
     */
    public Tirage getByJourTirage(String jour) {

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
            while (res.next()) {
                fresh =  new Tirage(res.getInt("idTyrage"), res.getInt("num1"), res.getInt("num2"), res.getInt("num3"),
                       res.getInt("num4"), res.getInt("num5"), res.getInt("numtirageBonus"),
                       res.getDate("dateTyrage").toLocalDate(), res.getString("jourTirage"), res.getString("TypeLotto"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fresh;
    }

    /**
     *
     * @param mois
     * @param heure
     * @param minute
     * @param seconde
     * @param jour
     * @return
     */
    public Tirage getByHourMinuteAndMounth(int mois, int heure, int minute, int seconde, int jour) {
        Connection connection = Connexion.getConnexion();
        PreparedStatement statement = null;
        Tirage fresh = null;

        String retreive = "select * from tirage where month(dateTyrage) = ? and hour(dateTyrage) = ? and minute(dateTyrage) = ? "
                + "and second(dateTyrage) = ? and day(dateTyrage) = ?";
        try {
            statement = connection.prepareCall(retreive);
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            statement.setInt(1, mois);
            statement.setInt(2, heure);
            statement.setInt(3, minute);
            statement.setInt(4, seconde);
            statement.setInt(5, jour);
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

            while (res.next()) {
                fresh =  new Tirage(res.getInt("idTyrage"), res.getInt("num1"), res.getInt("num2"), res.getInt("num3"),
                       res.getInt("num4"), res.getInt("num5"), res.getInt("numtirageBonus"),
                       res.getDate("dateTyrage").toLocalDate(), res.getString("jourTirage"), res.getString("TypeLotto"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fresh;
    }

    public Tirage getByDateDayAndTypePlay(String date, String jour, String typejouer) {

        Connection connection = Connexion.getConnexion();
        PreparedStatement statement = null;
        Tirage fresh = null;

        String retreive = "select * from tirage where date(dateTyrage) = ?  and  day(dateTyrage) = ?  and TypeLotto = ?";
        try {
            statement = connection.prepareCall(retreive);
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            statement.setString(1, date);
            statement.setString(2, jour);
            statement.setString(3, typejouer);
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
            while (res.next()) {
                fresh = new Tirage(res.getInt(1), res.getInt(3), res.getInt(4), res.getInt(5),
                        res.getInt(6), res.getInt(7), res.getDate(2).toLocalDate(),
                        res.getString(8), res.getString(9));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fresh;

    }

    /**
     * Permet de creer un tirage en signalant que c'est un lotto de tel type.
     * Cela permettra de recuper un tirage unique pour tous les joueurs ^_~ ^_~
     * ^_~ ^_~ ^_~ ^_~
     *
     * @param unTirage
     * @return
     */

    public boolean creerTirageBefore(Tirage unTirage) {
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = "insert into tirage(num1, num2, num3, num4, num5, numTirageBonus, "
                + "jourTirage, TypeLotto) values (?,?,?,?,?,?,?,?)";

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
            preparedStatement.setString(8, unTirage.getTypeJouer());

        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        int b = 1;

        try {
            b = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (b > 0) {
            System.out.println("Insertion reussi");
        }

        return true ? b > 0 : false;
    }
/**
 * 
 * @param jour
 * @param heure
 * @param tj
 * @return tirage 
 */
    public Tirage getTodayTirage(String jour, int heure, String tj) {
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = "select * from tirage where jourTirage = ? and hour(dateTyrage) = ? and TypeLotto ? ";

        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            preparedStatement.setString(1, jour);
            preparedStatement.setInt(1, heure);
            preparedStatement.setString(3, tj);
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet res = null;

        try {
            res = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Tirage n = null;

        try {
            while (res.next()) {
                n = new Tirage(res.getInt(1), res.getInt(3), res.getInt(4), res.getInt(5),
                        res.getInt(6), res.getInt(7), res.getDate(2).toLocalDate(),
                        res.getString(8), res.getString(9));

            }
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    /**
     * retoune un id tirage dernier donc recent qui est de type donne 
     * @param typejouer
     * @return 
     */

    
    public Tirage getTirage(String typejouer) {
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = " select *  from tirage where  idTyrage in (select max(idTyrage) from tirage ) and TypeLotto = ? ";

        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            preparedStatement.setString(1, typejouer);

        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet res = null;

        try {
            res = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Tirage n = null;

        try {
            while (res.next()) {
                n = new Tirage(res.getInt(1), res.getInt(3), res.getInt(4), res.getInt(5),
                        res.getInt(6), res.getInt(7), res.getDate(2).toLocalDate(),
                        res.getString(8), res.getString(9));

            }
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    
    
      public Tirage getTirageBYMaxIdlotto() {
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = " select *  from tirage where  idTyrage in (select max(idTyrage) from tirage ) and TypeLotto = ? ";

        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            preparedStatement.setString(1, "LOTTO");
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
   

        ResultSet res = null;

        try {
            res = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Tirage n = null;

        try {
            while (res.next()) {
            
                    n = new Tirage(res.getInt("idTyrage"), res.getInt("num1"), res.getInt("num2"), res.getInt("num3"),
                       res.getInt("num4"), res.getInt("num5"), res.getInt("numtirageBonus"),
                       res.getDate("dateTyrage").toLocalDate(), res.getString("jourTirage"), res.getString("TypeLotto"));
        
                    
            }
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    
      public Tirage getTirageSample() {
        Connection connection = Connexion.getConnexion();
        PreparedStatement preparedStatement = null;
        String sql = " select *  from tirage where  idTyrage = (select max(idTyrage) from tirage ) and TypeLotto = ? ";

        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            preparedStatement.setString(1, "LOTTO");
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   

        ResultSet res = null;

        try {
            res = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Tirage n = null;

        try {
            while (res.next()) {
                 n = new Tirage(res.getInt("idTyrage"), res.getInt("num1"), res.getInt("num2"), res.getInt("num3"),
                       res.getInt("num4"), res.getInt("num5"), res.getInt("numtirageBonus"),
                       res.getDate("dateTyrage").toLocalDate(), res.getString("jourTirage"), res.getString("TypeLotto"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(TirageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
}


/*
    ----------------------------------------------------------------
        En fait j'aimerais recuperer la dernieres insertion 
        par intervalle de minute 
    ----------------------------------------
 */
/**
 *
 */
