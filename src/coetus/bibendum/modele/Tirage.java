/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.modele;

import java.time.LocalDate;

/**
 *
 * @author Daniel
 */
public class Tirage {

    private int idTirage;
    private int numtir1, numtir2, numtir3, numtir4, numtir5, numtirbonus;
    private LocalDate datetirage;
    private String typeJouer;
    private String jourTirage;

    public Tirage() {

    }

    public Tirage(int idTirage, int numtir1, int numtir2, int numtir3, int numtir4, int numtir5, int numtirbonus, LocalDate datetirage, String typeJouer, String jourTirage) {
        this.idTirage = idTirage;
        this.numtir1 = numtir1;
        this.numtir2 = numtir2;
        this.numtir3 = numtir3;
        this.numtir4 = numtir4;
        this.numtir5 = numtir5;
        this.numtirbonus = numtirbonus;
        this.datetirage = datetirage;
        this.typeJouer = typeJouer;
        this.jourTirage = jourTirage;
    }

    public Tirage(int numtir1, int numtir2, int numtir3, int numtir4, int numtir5, int numtirbonus, LocalDate datetirage, String typeJouer, String jourTirage) {
        this.numtir1 = numtir1;
        this.numtir2 = numtir2;
        this.numtir3 = numtir3;
        this.numtir4 = numtir4;
        this.numtir5 = numtir5;
        this.numtirbonus = numtirbonus;
        this.datetirage = datetirage;
        this.typeJouer = typeJouer;
       this.jourTirage = RecevoirJourDeLaSemaine(LocalDate.now().getDayOfWeek().ordinal());
    }

    
    
    
    /**
     * 
     * @param idTirage
     * @param numtir1
     * @param numtir2
     * @param numtir3
     * @param numtir4
     * @param numtir5
     * @param numtirbonus 
     */
    public Tirage(int idTirage, int numtir1, int numtir2, int numtir3, int numtir4, int numtir5, int numtirbonus) {
        if (numtir1 <= 90 && numtir2 <= 90 && numtir3 <= 90 && numtir4 <= 90 && numtir5 <= 90 && numtirbonus <= 10) {
            this.idTirage = idTirage;
            this.numtir1 = numtir1;
            this.numtir2 = numtir2;
            this.numtir3 = numtir3;
            this.numtir4 = numtir4;
            this.numtir5 = numtir5;
            this.numtirbonus = numtirbonus;

            this.jourTirage = RecevoirJourDeLaSemaine(LocalDate.now().getDayOfWeek().ordinal());
        } else {
            System.err.println("Le numero ne doit pas depasser 90 de meme que le numero bonus ne doit pas depasser 10");
        }

    }

    public Tirage(int numtir1, int numtir2, int numtir3, int numtir4, int numtir5, int numtirbonus) {
        if (numtir1 <= 90 && numtir2 <= 90 && numtir3 <= 90 && numtir4 <= 90 && numtir5 <= 90 && numtirbonus <= 10) {

            this.numtir1 = numtir1;
            this.numtir2 = numtir2;
            this.numtir3 = numtir3;
            this.numtir4 = numtir4;
            this.numtir5 = numtir5;
            this.numtirbonus = numtirbonus;
            this.jourTirage = RecevoirJourDeLaSemaine(LocalDate.now().getDayOfWeek().ordinal());
        } else {
            System.err.println("Le numero ne doit pas depasser 90 de meme que le numero bonus ne doit pas depasser 10");
        }
    }

    public Tirage(int numtir1, int numtir2) {
        if (numtir1 <= 90 && numtir2 <= 90) {
            this.numtir1 = numtir1;
            this.numtir2 = numtir2;
            this.jourTirage = RecevoirJourDeLaSemaine(LocalDate.now().getDayOfWeek().ordinal());
        } else {
            System.err.println("Le numero ne doit pas depasser 90 de meme que le numero bonus ne doit pas depasser 10");
        }

    }

    public Tirage(int numtir1, int numtir2, int numtir3) {

        if (numtir1 <= 90 && numtir2 <= 90 && numtir3 <= 90) {
            this.numtir1 = numtir1;
            this.numtir2 = numtir2;
            this.numtir3 = numtir3;
            this.jourTirage = RecevoirJourDeLaSemaine(LocalDate.now().getDayOfWeek().ordinal());
        }

    }

    public Tirage(int numtir1, int numtir2, int numtir3, int numtir4) {

        if (numtir1 <= 90 && numtir2 <= 90 && numtir3 <= 90 && numtir4 <= 90) {
            this.numtir1 = numtir1;
            this.numtir2 = numtir2;
            this.numtir3 = numtir3;
            this.numtir4 = numtir4;
            this.jourTirage = RecevoirJourDeLaSemaine(LocalDate.now().getDayOfWeek().ordinal());
        } else {
            System.err.println("Le numero ne doit pas depasser 90 de meme que le numero bonus ne doit pas depasser 10");
        }

    }

    public LocalDate getDatetirage() {
        return datetirage;
    }

    public void setDatetirage(LocalDate datetirage) {
        this.datetirage = datetirage;
    }

    public String getJourTirage() {
        return jourTirage;
    }

    public void setJourTirage(String jourTirage) {
        this.jourTirage = jourTirage;
    }

    public int getNumtirbonus() {
        return numtirbonus;
    }

    public void setNumtirbonus(int numtirbonus) {
        this.numtirbonus = numtirbonus;
    }

    public int getIdTirage() {
        return idTirage;
    }

    public void setIdTirage(int idTirage) {
        this.idTirage = idTirage;
    }

    public int getNumtir1() {
        return numtir1;
    }

    public void setNumtir1(int numtir1) {
        this.numtir1 = numtir1;
    }

    public int getNumtir2() {
        return numtir2;
    }

    public void setNumtir2(int numtir2) {
        this.numtir2 = numtir2;
    }

    public int getNumtir3() {
        return numtir3;
    }

    public void setNumtir3(int numtir3) {
        this.numtir3 = numtir3;
    }

    public int getNumtir4() {
        return numtir4;
    }

    public void setNumtir4(int numtir4) {
        this.numtir4 = numtir4;
    }

    public int getNumtir5() {
        return numtir5;
    }

    public void setNumtir5(int numtir5) {
        this.numtir5 = numtir5;
    }

    @Override
    public String toString() {
        return "Tirage  " + "   idTirage :  " + idTirage + "  " + " num Tirage 1 :  " + numtir1 + "  "
                + "  num Tirage 2 :  " + numtir2 + "  " + " num Tirage 3 :   " + numtir3 + "  " + " num Tirage 4 :  "
                + numtir4 + "  " + " num Tirage 5 :  " + numtir5 + "  " + " num Tirage Bonus  :  " + "  " + numtirbonus + " jour du tirage " + jourTirage;
    }

    public Tirage(int idTirage, int numtir1, int numtir2, int numtir3, int numtir4, int numtir5, int numtirbonus, 
            LocalDate datetirage, String jourTirage) {

 
            this.idTirage = idTirage;
            this.numtir1 = numtir1;
            this.numtir2 = numtir2;
            this.numtir3 = numtir3;
            this.numtir4 = numtir4;
            this.numtir5 = numtir5;
            this.numtirbonus = numtirbonus;
            this.datetirage = datetirage;
            this.jourTirage = jourTirage;
     

    }

    public Tirage(int numtir1, int numtir2, int numtir3, int numtir4, int numtir5, int numtirbonus, LocalDate datetirage, String jourTirage) {
        this.numtir1 = numtir1;
        this.numtir2 = numtir2;
        this.numtir3 = numtir3;
        this.numtir4 = numtir4;
        this.numtir5 = numtir5;
        this.numtirbonus = numtirbonus;
        this.datetirage = datetirage;
        this.jourTirage = jourTirage;
    }

    public Tirage(int numtir1, int numtir2, int numtir3, int numtir4, int numtir5, int numtirbonus, String jourTirage) {
        if (numtir1 <= 90 && numtir2 <= 90 && numtir3 <= 90 && numtir4 <= 90 && numtir5 <= 90 && numtirbonus <= 10) {
         
            this.numtir1 = numtir1;
            this.numtir2 = numtir2;
            this.numtir3 = numtir3;
            this.numtir4 = numtir4;
            this.numtir5 = numtir5;
            this.numtirbonus = numtirbonus;
            this.jourTirage = jourTirage;
        }

    }
    
    

    public static String RecevoirJourDeLaSemaine(int DayOfWeek) {
         String tab [] = new String [] {"LUNDI","MARDI", "MERCREDI","JEUDI", "VENDREDI", "SAMEDI", "DIMANCHE"};
        String jourDeLaSemaine;
        return jourDeLaSemaine = tab[DayOfWeek];
    }

        public String getTypeJouer() {
        return typeJouer;
    }

    public void setTypeJouer(String typeJouer) {
        this.typeJouer = typeJouer;
    }

}
