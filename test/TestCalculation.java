/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.time.LocalDateTime;


/**
 *
 * @author Daniel
 */
public class TestCalculation {
    
    public static void main(String[] args) {
//        String tab [] = new String [] {"LUNDI","MARDI", "MERCREDI","JEUDI", "VENDREDI", "SAMEDI", "DIMANCHE"};
//        Calcul calc = new Calcul();
//        System.out.println(calc.GenererNumeroTicket());
//         calc.genererTirage();
//         System.out.println(calc.getTable());
//         
//         System.out.println( tab[LocalDate.now().getDayOfWeek().ordinal()]);

    int minute = LocalDateTime.now().getMinute();
    LocalDateTime d = LocalDateTime.now();
        System.out.println(d);
 
//        if (LocalDateTime.of( d.toLocalDate(), (d.getSecond()+ 5) )) {
//            System.out.println(LocalDateTime.now());
//        }
        
    }
}
