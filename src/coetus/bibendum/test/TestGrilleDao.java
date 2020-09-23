/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.test;

import coetus.bibendum.dao.CompteDao;
import coetus.bibendum.dao.GrilleDao;
import coetus.bibendum.dao.PersonneDao;
import coetus.bibendum.modele.Calcul;
import coetus.bibendum.modele.Compte;
import coetus.bibendum.modele.Grille;
import coetus.bibendum.modele.Personne;
import coetus.bibendum.modele.TypeLotto;

/**
 *
 * @author Daniel
 */
public class TestGrilleDao {
    
    public static void main(String[] args) {
        Calcul cal = new Calcul();
//        Personne p = new Personne( "kakou", "kouronziza",25, "masculin");
//        Personne falcon = new Personne(1, "canAll", "TheGreatJesus", 15000, "Masculin");
//         Compte newCompte = new Compte("Frank", "frank052", 15000, falcon);
//        Grille grille = new Grille(12, 47, 50, 20, 70, 67, 9, newCompte, 
//                cal.GenererNumeroTicket(), new TypeLotto("TirageImmediat"), LocalDate.now());
        
        Personne ya = new Personne("Flava", "Flavien", 25, "Feminin");
        PersonneDao pdao = new PersonneDao();
       // pdao.createPersonne(ya);
        CompteDao cdao = new CompteDao();
        Compte cmake = new Compte("Flavien", "flava254", 15005, ya);
       // cdao.creerCompte(cmake);
        Grille g = new Grille(14, 40, 58, 62, 24, 8, 500, cmake, new TypeLotto("Kadoo"));
        GrilleDao grilleDao = new GrilleDao();
        grilleDao.creerGrille(g);

    }
}
