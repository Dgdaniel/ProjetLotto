/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.test;

import coetus.bibendum.dao.CompteDao;
import coetus.bibendum.dao.PersonneDao;
import coetus.bibendum.modele.Compte;
import coetus.bibendum.modele.Personne;

/**
 *
 * @author Daniel
 */
public class TestCompteDao {

    public static void main(String[] args) {

        Personne falcon = new Personne(1, "canAll", "TheGreatJesus", 15000, "Masculin");
        Compte c = new Compte("greg", "GrassWilk", 14500, falcon);
        PersonneDao pdao = new PersonneDao();
        Personne person = new Personne(2, "Frankeinstein", "king", 35, "Masculin");

        Compte newCompte = new Compte("Frank", "frank052", 15000, person);
        CompteDao dao = new CompteDao();
        
        System.out.println(dao.getByPseudoPassWord("Frank", "frank052"));
//        System.out.println(dao.verifierPseudo("Frank"));
//        dao.creerCompte(newCompte);
       // dao.creerCompte(c);

//        dao.deleteById(1);
//pdao.createPersonne(pu);
//       dao.creerCompte(c);
//        dao.transfert("aniz", "Frank", 14000);
//        
//        dao.depot("Frank", 10000);
//        dao.achat("Frank", 300f);
//        dao.achat("Frank", 10000);
//dao.transfert("chadWik","Frank", 14000);
//        
//        Compte vo = dao.getById(1);
//        System.out.println(vo);
    }

}
