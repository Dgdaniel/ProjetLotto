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
public class Compte {
    
    private int idCompte;
    private String pseudo, motDePasse;
    private float solde;
    private float prixGagner;
    private LocalDate dateCompte;
    private Personne proprio;
    
    public Compte()
    {
        
    }

    public Compte(int idCompte, String pseudo, float solde, float prixGagner, LocalDate dateCompte, Personne proprio) {
        this.idCompte = idCompte;
        this.pseudo = pseudo;
        this.solde = solde;
        this.prixGagner = prixGagner;
        this.dateCompte = dateCompte;
        this.proprio = proprio;
    }

    
    
    public Compte(int idCompte, String pseudo, String motDePasse, float solde, float prixGagner, Personne proprio) 
    {
        this.idCompte = idCompte;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.solde = solde;
        this.prixGagner = prixGagner;
        this.proprio = proprio;
    }

    public Compte (int idCompte, String pseudo, String motDePasse, float solde, float prixGagner, Personne proprio, LocalDate dateCompte)
    {
        this(idCompte,  pseudo, motDePasse,  solde,  prixGagner, proprio);
        this.dateCompte = dateCompte;
    }

    public Compte(int idCompte, String pseudo, String motDePasse, float solde, LocalDate dateCompte, Personne proprio) {
        this.idCompte = idCompte;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.solde = solde;
        this.dateCompte = dateCompte;
        this.proprio = proprio;
    }

    public Compte(String pseudo, String motDePasse, float solde, Personne proprio) {
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.solde = solde;
        this.proprio = proprio;
    }
    
    
    
    

    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public float getPrixGagner() {
        return prixGagner;
    }

    public void setPrixGagner(float prixGagner) {
        this.prixGagner = prixGagner;
    }

    public LocalDate getDateCompte() {
        return dateCompte;
    }

    public void setDateCompte(LocalDate dateCompte) {
        this.dateCompte = dateCompte;
    }

    public Personne getProprio() {
        return proprio;
    }

    public void setProprio(Personne proprio) {
        this.proprio = proprio;
    }

    @Override
    public String toString() {
        return "Compte   " + " IdCompte :  " + idCompte + " Pseudo :  " + pseudo + " MotDePasse :  " + motDePasse + " Solde :  "
                + solde  +"\n"+" PrixGagner :  " + prixGagner + " DateCompte :  " + dateCompte + "\n Proprio :  " + proprio ;
    }
    
    
}
