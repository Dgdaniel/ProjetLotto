/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.test;

import coetus.bibendum.dao.PersonneDao;
import coetus.bibendum.modele.Personne;

/**
 *
 * @author Daniel
 */
public class TestPersonneDao {
    
    public static void main(String[] args) {
         Personne p = new Personne(1, "kakou", "kouronziza",25, "masculin");
//        System.out.println(p);
//        Compte c = new Compte(2, "chadwik", "Boseman43", 14000.000F, 0000.0000F,p, LocalDateTime.now());
//        System.out.println(c);
   
        PersonneDao pdo = new PersonneDao();

 boolean bool = pdo.deleteByNom("Daniz");
//
//  pdo.createPersonne(p);
    

        System.out.println("apres operation bool a pour valeur "+bool);
      
      
       
    }
    
}
