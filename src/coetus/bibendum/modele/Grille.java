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
public class Grille {
    private int idGrille;
    private int num1, num2, num3, num4,num5, numBonus;
    private float montantMise;
    private Compte joueur;
    private String Ticket;
    private TypeLotto typeLotto;
    private Tirage tirage;
    private LocalDate  dateJeu;
    /**
     * special int i
     */
    private  int idOfTyrageNotYetSet;
    Calcul calculation = new Calcul() ;
    
    public Grille ()
    {
        
    }

    public Grille(int idGrille, int num1, int num2, int num3, int num4, int num5, int numBonus, 
            float montantMise, Compte joueur, String Ticket, TypeLotto typeLotto, 
            Tirage tirage, LocalDate datejeu) {
       
        if (num1 < 91 && num2 < 91 && num3 < 91 && num4 < 91 && numBonus < 10) {
            this.idGrille = idGrille;
            this.num1 = num1;
            this.num2 = num2;
            this.num3 = num3;
            this.num4 = num4;
            this.num5 = num5;
            this.numBonus = numBonus;
            this.montantMise = montantMise;
            this.joueur = joueur;
            this.Ticket = Ticket;
            this.typeLotto = typeLotto;
            this.tirage = tirage;
            this.dateJeu = datejeu;
        }
        
    }

    public Grille(int idGrille, int num1, int num2, int num3, int num4, int num5, int numBonus, float montantMise, Compte joueur, String Ticket, TypeLotto typeLotto, LocalDate dateJeu) {
        this.idGrille = idGrille;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.num5 = num5;
        this.numBonus = numBonus;
        this.montantMise = montantMise;
        this.joueur = joueur;
        this.Ticket = Ticket;
        this.typeLotto = typeLotto;
        this.dateJeu = dateJeu;
    }
  
    
    /**
     * 
     * @param num1
     * @param num2
     * @param num3
     * @param num4
     * @param num5
     * @param numBonus
     * @param montantMise
     * @param joueur
     * @param typeLotto 
     */

    public Grille(int num1, int num2, int num3, int num4, int num5, int numBonus, float montantMise, 
            Compte joueur,  TypeLotto typeLotto) {
        if (num1 < 91 && num2 < 91 && num3 < 91 && num4 < 91 && num5 < 91 && numBonus < 10) {
            this.num1 = num1;
            this.num2 = num2;
            this.num3 = num3;
            this.num4 = num4;
            this.num5 = num5;
            this.numBonus = numBonus;
            this.montantMise = montantMise;
            this.joueur = joueur;
            this.Ticket = calculation.GenererNumeroTicket();
            this.typeLotto = typeLotto;
            
        }
        
  
    }

    public Grille(int num1, int num2, float montantMise, Compte joueur, TypeLotto typeLotto) {
        if (num1 < 91 && num2 < 91) {
            this.num1 = num1;
            this.num2 = num2;
            this.montantMise = montantMise;
            this.joueur = joueur;
            this.typeLotto = typeLotto;
            this.Ticket = calculation.GenererNumeroTicket();
        }

    }

    public Grille(int num1, int num2, int num3, float montantMise, Compte joueur, TypeLotto typeLotto) {
         if (num1 < 91 && num2 < 91 && num3 < 91 ) {
            this.num1 = num1;
            this.num2 = num2;
            this.num3 = num3;
            this.montantMise = montantMise;
            this.joueur = joueur;
            this.Ticket = calculation.GenererNumeroTicket();
            this.typeLotto = typeLotto;
            
        }
    }

    public Grille(int num1, int num2, int num3, int num4, float montantMise, Compte joueur, TypeLotto typeLotto) {
         if (num1 < 91 && num2 < 91 && num3 < 91 && num4 < 91) {
            this.num1 = num1;
            this.num2 = num2;
            this.num3 = num3;
            this.num4 = num4;
            this.montantMise = montantMise;
            this.joueur = joueur;
            this.Ticket = calculation.GenererNumeroTicket();
            this.typeLotto = typeLotto;
            
        }
    }
    
    
    
    
    public Grille(int num1, int num2, int num3, int num4, int num5,  float montantMise, 
            Compte joueur,  TypeLotto typeLotto) {
        if (num1 < 91 && num2 < 91 && num3 < 91 && num4 < 91 && num5 < 91 ) {
            this.num1 = num1;
            this.num2 = num2;
            this.num3 = num3;
            this.num4 = num4;
            this.num5 = num5;
            this.montantMise = montantMise;
            this.joueur = joueur;
            this.Ticket = calculation.GenererNumeroTicket();
            this.typeLotto = typeLotto;
            
        }
        
  
    }
    
    
    

    public String getTicket() {
        return this.Ticket;
    }

    public void setTicket(String Ticket) {
        this.Ticket = Ticket;
    }

    
    public int getIdGrille() {
        return idGrille;
    }

    public void setIdGrille(int idGrille) {
        this.idGrille = idGrille;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum3() {
        return num3;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }

    public int getNum4() {
        return num4;
    }

    public void setNum4(int num4) {
        this.num4 = num4;
    }

    public int getNum5() {
        return num5;
    }

    public void setNum5(int num5) {
        this.num5 = num5;
    }

    public float getMontantMise() {
        return montantMise;
    }

    public void setMontantMise(float montantMise) {
        this.montantMise = montantMise;
    }

    public Compte getJoueur() {
        return joueur;
    }

    public void setJoueur(Compte joueur) {
        this.joueur = joueur;
    }

    public Tirage getTirage() {
        return tirage;
    }

    public void setTirage(Tirage tirage) {
        this.tirage = tirage;
    }
    
    

    @Override
    public String toString() {
        
        return "Grille " + "idGrille :  " + idGrille + " num1 :  " + num1 + ", num2  : " + num2 + ", num3  : " + num3 + 
        "\n num4 :  " + num4 + " num5 :  " + num5 + " montantMise :  " + montantMise + "\n joueur :  " + joueur +
              "\n typeLotto=" + typeLotto ;
    }

    public int getNumBonus() {
        return numBonus;
    }

    public void setNumBonus(int numBonus) {
        this.numBonus = numBonus;
    }

    public TypeLotto getTypeLotto() {
        return typeLotto;
    }

    public void setTypeLotto(TypeLotto typeLotto) {
        this.typeLotto = typeLotto;
    }

    public LocalDate getDateJeu() {
        return dateJeu;
    }

    public void setDateJeu(LocalDate dateJeu) {
        this.dateJeu = dateJeu;
    }

    public Grille(int idGrille, int num1, int num2, int num3, int num4, int num5, int numBonus, float montantMise, Compte joueur, String Ticket, TypeLotto typeLotto, LocalDate dateJeu, int idOfTyrageNotYetSet) {
        this.idGrille = idGrille;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.num5 = num5;
        this.numBonus = numBonus;
        this.montantMise = montantMise;
        this.joueur = joueur;
        this.Ticket = Ticket;
        this.typeLotto = typeLotto;
        this.dateJeu = dateJeu;
        this.idOfTyrageNotYetSet = idOfTyrageNotYetSet;
    }



    
    
    
    
    
    
    
}
