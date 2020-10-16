/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.test;

import coetus.bibendum.modele.Calcul;
import java.time.LocalDate;

/**
 *
 * @author Daniel
 */
public class TestCalcul {

    public static void main(String[] args) {
            
            int [] k = new int [] {45, 1,4};
            int [] j = new int[ ] {20,45,67, 87,1, 4};
            Calcul cal = new Calcul();
            boolean b = cal.aGagner(k, j);
            
            System.out.println(cal.ordreGagner(k, j));

        if (b == true) {
            float prix = cal.givePriceTotheWinner(cal.ordreGagner(k, j), k.length, 10000, 3);     
            System.out.println("prix = "+ prix);
        }
        
        System.out.println(LocalDate.now().toString());
    }
  
  
  
  
}
