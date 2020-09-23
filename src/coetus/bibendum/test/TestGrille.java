/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.test;

import coetus.bibendum.modele.Compte;
import coetus.bibendum.modele.Personne;
import java.time.LocalDate;

/**
 *
 * @author Daniel
 */
public class TestGrille {
    public static void main(String[] args) {
          Personne p = new Personne(1, "kakou", "kouronziza",25, "masculin");
        System.out.println(p);
           System.out.println("\n\n\n\n");
        Compte c = new Compte(2, "chadwik", "Boseman43", 14000.000F, 0000.0000F,p, LocalDate.now());
        System.out.println(c);
        System.out.println("\n\n\n\n");
//        Grille g = new Grille(45, 10, 2, 8, 300.00f , c, new TypeLotto("Kadoo"));
        System.out.println(LocalDate.now());
    }
    
}
