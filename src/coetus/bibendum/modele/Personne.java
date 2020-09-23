/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.modele;

/**
 *
 * @author Daniel
 */
public class Personne {
    private int idpersonne;
    private String nom, prenom;
    private int age;
    private String sexe;
    
    public Personne()
    {
        
    }

    public Personne(int idpersonne, String nom, String prenom, int age ,String sexe) 
    {
        this.age = age;
        this.idpersonne = idpersonne;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
    }

    public Personne(String nom, String prenom, int age, String sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.sexe = sexe;
    }
    
    

    public int getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(int idpersonne) {
        this.idpersonne = idpersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    

    @Override
    public String toString() {
        return "Personne  " + "Id  :  " + idpersonne + " Nom :  " + nom + "  Prenom :  " + prenom + "Age :  " +age+ "  Sexe :  " + sexe ;
    }
    
    
    
}
