/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.test;

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
//        Calcul cal = new Calcul();
//        int gety [] =  cal.genererTirage();
//        String jour =     RecevoirJourDeLaSemaine(LocalDateTime.now().getDayOfWeek().toString());  
//        Tirage t = new Tirage( gety[0], gety[1], gety[2], gety[3], gety[4], cal.GenererNumeroBonus(), jour);
//    
//        
//       TirageDao tirageDao = new TirageDao();
//       
//        tirageDao.creerTirage(t);
//        System.out.println(tirageDao.getByDateTirage(LocalDate.of(2020, 9, 7) , "lundi".toUpperCase()));
        Calcul cal = new Calcul();
        int getIt [] =  cal.genererTirage();
       Tirage gt = new Tirage(getIt [0], getIt [1], getIt[2], getIt[3], getIt[4], 
               cal.GenererNumeroBonus(),RetreiveDayNameInFrench(LocalDate.now().getDayOfWeek().ordinal()) );
       
       Tirage tg = new Tirage(getIt [0], getIt [1], getIt[2], getIt[3], getIt[4], cal.GenererNumeroBonus(), LocalDate.now(), "LOTTO", RetreiveDayNameInFrench(LocalDate.now().getDayOfWeek().ordinal()));
//               ;
//      
//       int get [] = cal.genererTirage();
//       
//       Tirage teo = new Tirage(get[0], get[1], get[2], get[3], get[4], cal.GenererNumeroBonus(),
//       RetreiveDayNameInFrench(LocalDate.now().getDayOfWeek().ordinal()+1));
////       dfr.creerTirage(teo);
//       int fvtab [] = cal.genererTirage();
//       Tirage fv = new Tirage(fvtab[0], fvtab[1], fvtab[2], fvtab[3],fvtab[4], cal.GenererNumeroBonus(),
//               RetreiveDayNameInFrench(LocalDate.now().getDayOfWeek().ordinal()+2));
//        System.out.println("\n"+teo+"\n"+fv);
        TirageDao daotirage = new TirageDao();
        
        Tirage g = daotirage.getByDateTirage(LocalDate.now());
        System.out.println(g);
       
//        Tirage f = daotirage.getByHourMinuteAndMounth(9, 9, 12, 31, 7);
//            for (Tirage tirage : daotirage.getAll()) {
//                System.out.println(tirage);
//        }
        
//                System.out.println(daotirage.getTirage("LOTTO"));
        
//        daotirage.creerTirageBefore(tg);
        
//        System.out.println(f);
//        System.out.println(g);
        
//        for (int i = 0; i < 10; i++) {
//               int mois = LocalDate.now().getMonthValue();
//            int minute = LocalDateTime.now().getMinute();
//            int heure = LocalDateTime.now().getHour();
//            int seconde = LocalDateTime.now().getSecond();
//            int jour = LocalDate.now().getDayOfMonth();
//            
//            System.out.println(mois +"\t"+jour+"\t"+heure+"\t"+minute+"\t"+seconde);
//        }

//        Tirage k = tirageDao.getById(1);
//       
//        System.out.println(k);
    }
}
