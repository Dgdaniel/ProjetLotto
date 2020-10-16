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
        Personne p = new Personne( "kakou", "kouronziza",25, "masculin");
        Personne falcon = new Personne(1, "canAll", "TheGreatJesus", 15000, "Masculin");
         Compte newCompte = new Compte("Frank", "frank052", 15000, falcon);
        TypeLotto typeLotto = new TypeLotto("LOTTO");
       Grille grille = new Grille(14, 10, 20, 30, 50, 6, newCompte, typeLotto);
        Personne ya = new Personne("Flava", "Flavien", 25, "Feminin");
        PersonneDao pdao = new PersonneDao();
       // pdao.createPersonne(ya);
        CompteDao cdao = new CompteDao();
        Compte cmake = new Compte("Flavien", "flava254", 15005, ya);
       // cdao.creerCompte(cmake);
        Grille g = new Grille(14, 80, 88, 72, 24, 400, cmake, new TypeLotto("LOTTO"));
//         Grille goGrille = new Grille(14, 1, 8, 7, 24, 7, 400, cmake, new TypeLotto("LOTTO"));
        GrilleDao grilleDao = new GrilleDao();
        grilleDao.creerSampleGrille(g);
//        grilleDao.creerSampleGrille(goGrille);
        System.out.println(cal.GenererNumeroBonus());
        
        for (Grille arg : grilleDao.getAll()) {
            System.out.println(arg);
        }


    }
}
