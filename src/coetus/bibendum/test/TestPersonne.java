/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.test;

import coetus.bibendum.modele.Compte;
import coetus.bibendum.modele.Personne;
import coetus.bibendum.modele.TypeLotto;
import java.time.LocalDate;
/**
 *
 * @author Daniel
 */
public class TestPersonne {
    
    public static void main(String[] args) {
        Personne p = new Personne(1, "kakou", "kouronziza",25, "masculin");
        System.out.println(p);
        Compte c = new Compte(2, "chadwik", "Boseman43", 14000.000F, 0000.0000F,p, LocalDate.now());
        System.out.println(c);
        
        TypeLotto l = new TypeLotto("kadoo");
        System.out.println(l);
        
        
    }
}
