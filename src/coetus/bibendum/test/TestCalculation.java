/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.test;

import coetus.bibendum.modele.Calcul;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Daniel
 */
public class TestCalculation {
    
    public static void main(String[] args) {
        String tab [] = new String [] {"LUNDI","MARDI", "MERCREDI","JEUDI", "VENDREDI", "SAMEDI", "DIMANCHE"};
        Calcul calc = new Calcul();
        System.out.println(calc.GenererNumeroTicket());
         calc.genererTirage();
         System.out.println(calc.getTable());
         
         System.out.println( tab[LocalDate.now().getDayOfWeek().ordinal()]);

    int minute = LocalDateTime.now().getMinute();
    
        System.out.println(LocalDate.MAX);
        
    }
}
