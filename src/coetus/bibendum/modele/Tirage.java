/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.modele;

import java.time.LocalDate;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Daniel
 */
public class Tirage {

    private SimpleIntegerProperty idTirage;
    private SimpleIntegerProperty numtir1, numtir2, numtir3, numtir4, numtir5, numtirbonus;
    private LocalDate datetirage;
    private SimpleStringProperty typeJouer;
    private SimpleStringProperty jourTirage;

    public Tirage() {
        
    }

    public Tirage(SimpleIntegerProperty idTirage, SimpleIntegerProperty numtir1, SimpleIntegerProperty numtir2, SimpleIntegerProperty numtir3, SimpleIntegerProperty numtir4, SimpleIntegerProperty numtir5, SimpleIntegerProperty numtirbonus, LocalDate datetirage, SimpleStringProperty typeJouer, SimpleStringProperty jourTirage) {
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

    public Tirage(SimpleIntegerProperty numtir1, SimpleIntegerProperty numtir2, SimpleIntegerProperty numtir3, SimpleIntegerProperty numtir4, SimpleIntegerProperty numtir5, SimpleIntegerProperty numtirbonus, LocalDate datetirage, SimpleStringProperty typeJouer, SimpleStringProperty jourTirage) {
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
     
    

    @Override
    public String toString() {
        return "Tirage " + "idTirage  : " + idTirage + ", numtir1  : " + numtir1 + ", numtir2  : " + numtir2 + ", numtir3  : " + numtir3 + ", numtir4  : " + numtir4 + ", numtir5  : " + numtir5 + ", numtirbonus  : " + numtirbonus + ", datetirage  : " + datetirage + ", typeJouer  : " + typeJouer + ", jourTirage  : " + jourTirage + '}';
    }

    public SimpleIntegerProperty getIdTirage() {
        return idTirage;
    }

    public void setIdTirage(SimpleIntegerProperty idTirage) {
        this.idTirage = idTirage;
    }

    public SimpleIntegerProperty getNumtir1() {
        return numtir1;
    }

    public void setNumtir1(SimpleIntegerProperty numtir1) {
        this.numtir1 = numtir1;
    }

    public SimpleIntegerProperty getNumtir2() {
        return numtir2;
    }

    public void setNumtir2(SimpleIntegerProperty numtir2) {
        this.numtir2 = numtir2;
    }

    public SimpleIntegerProperty getNumtir3() {
        return numtir3;
    }

    public void setNumtir3(SimpleIntegerProperty numtir3) {
        this.numtir3 = numtir3;
    }

    public SimpleIntegerProperty getNumtir4() {
        return numtir4;
    }

    public void setNumtir4(SimpleIntegerProperty numtir4) {
        this.numtir4 = numtir4;
    }

    public SimpleIntegerProperty getNumtir5() {
        return numtir5;
    }

    public void setNumtir5(SimpleIntegerProperty numtir5) {
        this.numtir5 = numtir5;
    }

    public SimpleIntegerProperty getNumtirbonus() {
        return numtirbonus;
    }

    public void setNumtirbonus(SimpleIntegerProperty numtirbonus) {
        this.numtirbonus = numtirbonus;
    }

    public LocalDate getDatetirage() {
        return datetirage;
    }

    public void setDatetirage(LocalDate datetirage) {
        this.datetirage = datetirage;
    }

    public SimpleStringProperty getTypeJouer() {
        return typeJouer;
    }

    public void setTypeJouer(SimpleStringProperty typeJouer) {
        this.typeJouer = typeJouer;
    }

    public SimpleStringProperty getJourTirage() {
        return jourTirage;
    }

    public void setJourTirage(SimpleStringProperty jourTirage) {
        this.jourTirage = jourTirage;
    }


    public static String RecevoirJourDeLaSemaine(int DayOfWeek) {
         String tab [] = new String [] {"LUNDI","MARDI", "MERCREDI","JEUDI", "VENDREDI", "SAMEDI", "DIMANCHE"};
        String jourDeLaSemaine;
        return jourDeLaSemaine = tab[DayOfWeek];
    }



}
