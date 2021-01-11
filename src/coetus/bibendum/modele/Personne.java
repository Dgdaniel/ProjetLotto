/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.modele;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Daniel
 */
public class Personne {
    private SimpleIntegerProperty idpersonne;
    private SimpleStringProperty nom, prenom;
    private SimpleIntegerProperty age;
    private SimpleStringProperty sexe;
    
    public Personne()
    {
        
    }

    public Personne(SimpleIntegerProperty idpersonne, SimpleStringProperty nom, SimpleStringProperty prenom, SimpleIntegerProperty age, SimpleStringProperty sexe) {
        this.idpersonne = idpersonne;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.sexe = sexe;
    }

    public Personne(SimpleStringProperty nom, SimpleStringProperty prenom, SimpleIntegerProperty age, SimpleStringProperty sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.sexe = sexe;
    }

    public Personne(SimpleStringProperty nom, SimpleStringProperty prenom, SimpleIntegerProperty age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public SimpleIntegerProperty getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(SimpleIntegerProperty idpersonne) {
        this.idpersonne = idpersonne;
    }

    public SimpleStringProperty getNom() {
        return nom;
    }

    public void setNom(SimpleStringProperty nom) {
        this.nom = nom;
    }

    public SimpleStringProperty getPrenom() {
        return prenom;
    }

    public void setPrenom(SimpleStringProperty prenom) {
        this.prenom = prenom;
    }

    public SimpleIntegerProperty getAge() {
        return age;
    }

    public void setAge(SimpleIntegerProperty age) {
        this.age = age;
    }

    public SimpleStringProperty getSexe() {
        return sexe;
    }

    public void setSexe(SimpleStringProperty sexe) {
        this.sexe = sexe;
    }

   
    

    @Override
    public String toString() {
        return "Personne  " + "Id  :  " + idpersonne + " Nom :  " + nom + "  Prenom :  " + prenom + "Age :  " +age+ "  Sexe :  " + sexe ;
    }
    
    
    
}
