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
    
    /**
     *
     */
    public Compte()
    {
        
    }

    /**
     *
     * @param idCompte
     * @param pseudo
     * @param solde
     * @param prixGagner
     * @param dateCompte
     * @param proprio
     */
    public Compte(int idCompte, String pseudo, float solde, float prixGagner, LocalDate dateCompte, Personne proprio) {
        this.idCompte = idCompte;
        this.pseudo = pseudo;
        this.solde = solde;
        this.prixGagner = prixGagner;
        this.dateCompte = dateCompte;
        this.proprio = proprio;
    }

    /**
     *
     * @param idCompte
     * @param pseudo
     * @param motDePasse
     * @param solde
     * @param prixGagner
     * @param proprio
     */
    public Compte(int idCompte, String pseudo, String motDePasse, float solde, float prixGagner, Personne proprio) 
    {
        this.idCompte = idCompte;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.solde = solde;
        this.prixGagner = prixGagner;
        this.proprio = proprio;
    }

    /**
     *
     * @param idCompte
     * @param pseudo
     * @param motDePasse
     * @param solde
     * @param prixGagner
     * @param proprio
     * @param dateCompte
     */
    public Compte (int idCompte, String pseudo, String motDePasse, float solde, float prixGagner, Personne proprio, LocalDate dateCompte)
    {
        this(idCompte,  pseudo, motDePasse,  solde,  prixGagner, proprio);
        this.dateCompte = dateCompte;
    }

    /**
     *
     * @param idCompte
     * @param pseudo
     * @param motDePasse
     * @param solde
     * @param dateCompte
     * @param proprio
     */
    public Compte(int idCompte, String pseudo, String motDePasse, float solde, LocalDate dateCompte, Personne proprio) {
        this.idCompte = idCompte;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.solde = solde;
        this.dateCompte = dateCompte;
        this.proprio = proprio;
    }

    /**
     *
     * @param pseudo
     * @param motDePasse
     * @param solde
     * @param proprio
     */
    public Compte(String pseudo, String motDePasse, float solde, Personne proprio) {
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.solde = solde;
        this.proprio = proprio;
    }
    
    /**
     *
     * @return
     */
    public int getIdCompte() {
        return idCompte;
    }

    /**
     *
     * @param idCompte
     */
    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    /**
     *
     * @return
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     *
     * @param pseudo
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     *
     * @return
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     *
     * @param motDePasse
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    /**
     *
     * @return
     */
    public float getSolde() {
        return solde;
    }

    /**
     *
     * @param solde
     */
    public void setSolde(float solde) {
        this.solde = solde;
    }

    /**
     *
     * @return
     */
    public float getPrixGagner() {
        return prixGagner;
    }

    /**
     *
     * @param prixGagner
     */
    public void setPrixGagner(float prixGagner) {
        this.prixGagner = prixGagner;
    }

    /**
     *
     * @return
     */
    public LocalDate getDateCompte() {
        return dateCompte;
    }

    /**
     *
     * @param dateCompte
     */
    public void setDateCompte(LocalDate dateCompte) {
        this.dateCompte = dateCompte;
    }

    /**
     *
     * @return
     */
    public Personne getProprio() {
        return proprio;
    }

    /**
     *
     * @param proprio
     */
    public void setProprio(Personne proprio) {
        this.proprio = proprio;
    }

    @Override
    public String toString() {
        return "Compte   " + " IdCompte :  " + idCompte + " Pseudo :  " + pseudo + " MotDePasse :  " + motDePasse + " Solde :  "
                + solde  +"\n"+" PrixGagner :  " + prixGagner + " DateCompte :  " + dateCompte + "\n Proprio :  " + proprio ;
    }
    
    
}
