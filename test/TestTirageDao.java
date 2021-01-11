/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import coetus.bibendum.dao.TirageDao;
import coetus.bibendum.modele.Calcul;
import coetus.bibendum.modele.Tirage;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Daniel
 */
public class TestTirageDao {
    
    public static String RecevoirJourDeLaSemaine(String DayOfWeek){
        String jourDeLaSemaine;
        if (DayOfWeek.equals("MONDAY")) {
            jourDeLaSemaine = "LUNDI";
        }else if (DayOfWeek.equals("TUESDAY")) {
            jourDeLaSemaine = "MARDI";
        }else if (DayOfWeek.equals("WEDNESDAY")) {
            jourDeLaSemaine = "MERCREDI";
        }else if (DayOfWeek.equalsIgnoreCase("thursday")) {
            jourDeLaSemaine = "JEUDI";
        }else if (DayOfWeek.equalsIgnoreCase("friday")) {
            jourDeLaSemaine = "vendredi".toUpperCase();
        }else if(DayOfWeek.equalsIgnoreCase("saturday")){
            jourDeLaSemaine = "samedi".toUpperCase();
        }else{
            jourDeLaSemaine = "dimanche".toUpperCase();
        }
                
        return jourDeLaSemaine;
    }
    
    public static String RetreiveDayNameInFrench(int position){
        String french = null;
        
        if (position >6) {
            position = position -6;
        }
        String [] dayOfWeekInFrench  = new String [] {"lundi","mardi","mercredi","jeudi","vendredi","samedi","dimanche"};
        french = dayOfWeekInFrench[position];
        return french.toUpperCase();
    }
    
    
    public static void main(String[] args) {

        TirageDao daotirage = new TirageDao();
        
        Tirage g = daotirage.getByDateTirageSample(LocalDate.now());
        System.out.println(" daotirage.getByDateTirageSample(LocalDate.now())   ********* "+g);
        System.out.println(" getTirageSample() =====" +daotirage.getTirageSample());
       

    }
}
