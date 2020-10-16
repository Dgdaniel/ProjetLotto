/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.modele;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Daniel
 */
public class Calcul {

    private Random random;
    private int valeurGrille = 50;
    private int table[] = new int[5];
    private int numbonusTirage;
    private int nombreDeFoisNumeroTrouverAvecPositionTirageExacte;
    private int nombreDeFoisQuILATrouberLeBonNumero;
    private int precisionJoueur;
    private Float prixGagner;

    /**
     *  <p>Renvoie un tableau de nombre entier compris entre 1 et 90.
     *  Les bornes sont comprises.</p>
     *   
     * @return table
     */
    public int[] genererTirage() {
        random = new Random();

        for (int y = 0; y < 5; y++) {
            int n = 1 + random.nextInt(90);
            table[y] = n;
        }
        return table;
    }

    /**
     * Permet de recuperer le numero bonus.
     * 
     * @return numbonusTirage
     */
    public int GenererNumeroBonus() {
        random = new Random();
        numbonusTirage = 1 + random.nextInt(11);
        return numbonusTirage;
    }

    /**
     * Pour recuperer le numero de Tickect
     * Le numero de ticket est aleatoire.
     * @return
     */
    public String GenererNumeroTicket() {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz"
                + "123456789";

        StringBuilder s = new StringBuilder(10);
        String fBuilder = "Num#";
        s.append(fBuilder);

        for (int i = 0; i < 10; i++) {
            int index = (int) (str.length() * Math.random());
            s.append(str.charAt(index));
        }

        return s.toString();
    }

    /**
     *
     * @return
     */
    public int[] getTable() {
        return table;
    }

    /**
     *
     * @param table
     */
    public void setTable(int[] table) {
        this.table = table;
    }

    /**
     *
     * @return
     */
    public int getNumbonusTirage() {
        return numbonusTirage;
    }

    /**
     *
     * @param numbonusTirage
     */
    public void setNumbonusTirage(int numbonusTirage) {
        this.numbonusTirage = numbonusTirage;
    }

    /**
     * Cette methode permet de savoir si la position du jeu jouer par le joueur
     * est le meme que celui de la grille. C'est a dire que la premiere case du
     * jeu de l'utilisateur correspond a la premiere case du tirage et ainsi de
     * suite
     */
    /**
     ** Cette methode permet de savoir si la position du jeu jouer par le joueur
     * est le meme que celui de la grille. C'est a dire que la premiere case du
     * jeu de l'utilisateur correspond a la premiere case du tirage et ainsi de
     * suite
     * @param tableauJoueur
     * @param tirage
     * @return
     */
    public int ordreGagner(int[] tableauJoueur, int[] tirage) {
        nombreDeFoisQuILATrouberLeBonNumero = 0;
        nombreDeFoisNumeroTrouverAvecPositionTirageExacte = 0;
        for (int i = 0; i < tableauJoueur.length; i++) {
            int pos = i;
            for (int j = 0; j < tirage.length; j++) {
                int y = j;
                if (tableauJoueur[i] == tirage[j]) {
                    nombreDeFoisQuILATrouberLeBonNumero++;

                }
                if (tableauJoueur[i] == tirage[j]) {
                    nombreDeFoisNumeroTrouverAvecPositionTirageExacte++;
                }

            }

        }
        return nombreDeFoisQuILATrouberLeBonNumero;

    }

    /*
        Cette methode permet de savoir si le joueur a gagner ou non 
     */
    /**
     *
     * @param tableauJoueur
     * @param tirage
     * @return
     */
    public boolean aGagner(int[] tableauJoueur, int[] tirage) {
        nombreDeFoisQuILATrouberLeBonNumero = 0;
        for (int i = 0; i < tableauJoueur.length; i++) {

            for (int j = 0; j < tirage.length; j++) {

                if (tableauJoueur[i] == tirage[j]) {
                    nombreDeFoisQuILATrouberLeBonNumero++;
                }

            }

        }
        return true ? nombreDeFoisQuILATrouberLeBonNumero >0: false;
    }

    /*
    Cette methode de a gagner retourne un tableau pour le cas de tombola
     */

    /**
     *
     * @param tableauJoueur
     * @param tirage
     * @return
     */
    public ArrayList<Integer> tableauAGagner(int[] tableauJoueur, int[] tirage) {
        nombreDeFoisQuILATrouberLeBonNumero = 0;
        ArrayList<Integer> foundArrayList = new ArrayList<Integer>();
        for (int i = 0; i < tableauJoueur.length; i++) {

            for (int j = 0; j < tirage.length; j++) {

                if (tableauJoueur[i] == tirage[j]) {
                    nombreDeFoisQuILATrouberLeBonNumero++;
                    int retreive = tableauJoueur[i];
                    foundArrayList.add(retreive);
                }

            }

        }
        return foundArrayList;
    }

    public float matchDeuxPrix(int sizeOfPlayerTable, float laMiseDuJoueur, int parie ) {
        prixGagner = 0F;
        if (sizeOfPlayerTable == 2 && laMiseDuJoueur > 0 && laMiseDuJoueur <= 1000 && parie == sizeOfPlayerTable) {
            prixGagner = laMiseDuJoueur * valeurGrille;
        } else if (sizeOfPlayerTable == 2 && laMiseDuJoueur > 999 && laMiseDuJoueur <= 10000 && parie == sizeOfPlayerTable) {
            valeurGrille = 60;
            prixGagner = laMiseDuJoueur * valeurGrille;
        } else if (sizeOfPlayerTable == 2 && laMiseDuJoueur > 99999 && laMiseDuJoueur <= 100000 && parie == sizeOfPlayerTable) {
            valeurGrille = 65;
            prixGagner = laMiseDuJoueur * valeurGrille;
        } else if (sizeOfPlayerTable == 2 && laMiseDuJoueur > 999999 && laMiseDuJoueur <= 1000000 && parie == sizeOfPlayerTable) {
            valeurGrille = 85;
            prixGagner = laMiseDuJoueur * valeurGrille;
        } else {
            valeurGrille = 20;
            prixGagner = laMiseDuJoueur * valeurGrille;
        }

        return prixGagner;
    }

    public float matchTroisPrix(int sizeOfPlayerTable, float laMiseDuJoueur , int parie) {
        prixGagner = 25F;
        if (sizeOfPlayerTable == 3 && laMiseDuJoueur > 0 && laMiseDuJoueur <= 1000 && parie == sizeOfPlayerTable) {
            valeurGrille = 55;
            prixGagner = laMiseDuJoueur * valeurGrille + prixGagner;
        } else if (sizeOfPlayerTable == 3 && laMiseDuJoueur > 999 && laMiseDuJoueur <= 10000 && parie == sizeOfPlayerTable) {
            valeurGrille = 62;
            prixGagner = laMiseDuJoueur * valeurGrille + prixGagner;
        } else if (sizeOfPlayerTable == 3 && laMiseDuJoueur > 99999 && laMiseDuJoueur <= 100000 && parie == sizeOfPlayerTable) {
            valeurGrille = 67;
            prixGagner = laMiseDuJoueur * valeurGrille + prixGagner;
        } else if (sizeOfPlayerTable == 3 && laMiseDuJoueur > 999999 && laMiseDuJoueur <= 1000000 && parie == sizeOfPlayerTable) {
            valeurGrille = 86;
            prixGagner = laMiseDuJoueur * valeurGrille + prixGagner;

        } else {
            valeurGrille = 35;
            prixGagner = laMiseDuJoueur * valeurGrille + prixGagner;
        }
        return prixGagner;
    }

    public float matchPrixQuatre(int sizeOfPlayerTable, float laMiseDuJoueur , int parie) {
        prixGagner = 50F;
        if (sizeOfPlayerTable == 4 && laMiseDuJoueur > 0 && laMiseDuJoueur <= 1000 && parie == sizeOfPlayerTable) {
            valeurGrille = 60;
            prixGagner = laMiseDuJoueur * valeurGrille + prixGagner;
        } else if (sizeOfPlayerTable == 4 && laMiseDuJoueur > 999 && laMiseDuJoueur <= 10000 && parie == sizeOfPlayerTable) {
            valeurGrille = 63;
            prixGagner = laMiseDuJoueur * valeurGrille + prixGagner;
        } else if (sizeOfPlayerTable == 4 && laMiseDuJoueur > 99999 && laMiseDuJoueur <= 100000 && parie == sizeOfPlayerTable) {
            valeurGrille = 68;
            prixGagner = laMiseDuJoueur * valeurGrille + prixGagner;
        } else if (sizeOfPlayerTable == 4 && laMiseDuJoueur > 999999 && laMiseDuJoueur <= 1000000 && parie == sizeOfPlayerTable) {
            valeurGrille = 89;
            prixGagner = laMiseDuJoueur * valeurGrille + prixGagner;

        } else {
            valeurGrille = 50;
            prixGagner = laMiseDuJoueur * valeurGrille + prixGagner;
        }

        return prixGagner;
    }

    public float matchCinqPrix(int sizeOfPlayerTable, float laMiseDuJoueur, int parie ) {
        prixGagner = 67F;
        if (sizeOfPlayerTable == 5 && laMiseDuJoueur > 0 && laMiseDuJoueur <= 1000 && parie == sizeOfPlayerTable) {
            valeurGrille = 67;
            prixGagner = laMiseDuJoueur * valeurGrille;
        } else if (sizeOfPlayerTable == 5 && laMiseDuJoueur > 999 && laMiseDuJoueur <= 10000 && parie == sizeOfPlayerTable) {
            valeurGrille = 70;
            prixGagner = laMiseDuJoueur * valeurGrille;
        } else if (sizeOfPlayerTable == 5 && laMiseDuJoueur > 99999 && laMiseDuJoueur <= 100000 && parie == sizeOfPlayerTable) {
            valeurGrille = 95;
            prixGagner = laMiseDuJoueur * valeurGrille;
        } else if (sizeOfPlayerTable == 5 && laMiseDuJoueur > 999999 && laMiseDuJoueur <= 1000000 && parie == sizeOfPlayerTable) {
            valeurGrille = 97;
            prixGagner = laMiseDuJoueur * valeurGrille;

        } else {
            valeurGrille = 52;
            prixGagner = laMiseDuJoueur * valeurGrille;
        }

        return prixGagner;

    }
    
    
    public float givePriceTotheWinner(int nombreDefoisTouver,int sizeOfPlayerTable, float laMiseDuJoueur , int parie){
        float price = 0;
        switch (nombreDefoisTouver) {
            case 2:
                switch (sizeOfPlayerTable) {
                    case 2:
                        price = matchDeuxPrix(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                    case 3:
                        price = matchTroisPrix(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                    case 4:
                        price = matchPrixQuatre(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                    case 5:
                        price = matchCinqPrix(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                    case 6:
                        price = matchCinqPrix(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                }

                break;
            case 3:
                switch (sizeOfPlayerTable) {
                    case 2:
                        price = matchDeuxPrix(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                    case 3:
                        price = matchTroisPrix(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                    case 4:
                        price = matchPrixQuatre(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                    case 5:
                        price = matchCinqPrix(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                    case 6:
                        price = matchCinqPrix(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                }
                break;

            case 4:
                switch (sizeOfPlayerTable) {
                    case 2:
                        price = matchDeuxPrix(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                    case 3:
                        price = matchTroisPrix(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                    case 4:
                        price = matchPrixQuatre(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                    case 5:
                        price = matchCinqPrix(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                    case 6:
                        price = matchCinqPrix(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                }
                break;
            case 5:
                switch (sizeOfPlayerTable) {
                    case 2:
                        price = matchDeuxPrix(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                    case 3:
                        price = matchTroisPrix(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                    case 4:
                        price = matchPrixQuatre(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                    case 5:
                        price = matchCinqPrix(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                    case 6:
                        price = matchCinqPrix(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                }
                break;

            case 6:
                switch (sizeOfPlayerTable) {
                    case 2:
                        price = matchDeuxPrix(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                    case 3:
                        price = matchTroisPrix(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                    case 4:
                        price = matchPrixQuatre(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                    case 5:
                        price = matchCinqPrix(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                    case 6:
                        price = matchCinqPrix(sizeOfPlayerTable, laMiseDuJoueur, parie);
                        break;
                }
                break;

        }
    
        return price;

        
    }
//    public void tranfererPrixGagner(float prix, Compte destinataire){
//        
//    }

  

}
