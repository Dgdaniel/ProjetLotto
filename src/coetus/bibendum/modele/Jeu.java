/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.modele;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author Daniel
 */
public class Jeu {
    private SimpleIntegerProperty idGrille;
    private SimpleIntegerProperty num1, num2, num3, num4,num5, numBonus;
    private SimpleFloatProperty montantMise;
    private Compte joueur;
    private SimpleStringProperty Ticket;
    private TypeLotto typeLotto;
    private Tirage tirage;
    private LocalDate  dateJeu;
    /**
     * special int i
     */
    private  int idOfTyrageNotYetSet;
    Calcul cal = new Calcul() ;
    
    public Jeu ()
    {
        
    }

    public Jeu(SimpleIntegerProperty idGrille, SimpleIntegerProperty num1, SimpleIntegerProperty num2, SimpleIntegerProperty 
            num3, SimpleIntegerProperty num4, SimpleIntegerProperty num5, SimpleIntegerProperty numBonus, 
            SimpleFloatProperty montantMise, Compte joueur, SimpleStringProperty Ticket, TypeLotto typeLotto, 
            Tirage tirage, LocalDate dateJeu) {
       
            
        this.idGrille = idGrille;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.num5 = num5;
        this.numBonus = numBonus;
        this.montantMise = montantMise;
        this.joueur = joueur;
        this.Ticket = Ticket ;
        this.typeLotto = typeLotto;
        this.tirage = tirage;
        this.dateJeu = dateJeu;
    
      
    }

    public Jeu(SimpleIntegerProperty num1, SimpleIntegerProperty num2, SimpleIntegerProperty num3, 
            SimpleIntegerProperty num4, SimpleIntegerProperty num5, SimpleIntegerProperty numBonus, 
            SimpleFloatProperty montantMise, Compte joueur, SimpleStringProperty Ticket, TypeLotto typeLotto, 
            Tirage tirage, LocalDate dateJeu) {
        
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.num5 = num5;
        this.numBonus = numBonus;
        this.montantMise = montantMise;
        this.joueur = joueur;
        this.Ticket =  new SimpleStringProperty(cal.GenererNumeroTicket());
        this.typeLotto = typeLotto;
        this.dateJeu = LocalDateTime.now().toLocalDate();
        
        
    }

    public Jeu(SimpleIntegerProperty num1, SimpleIntegerProperty num2, SimpleIntegerProperty num3, SimpleIntegerProperty num4, SimpleFloatProperty montantMise, Compte joueur, SimpleStringProperty Ticket, TypeLotto typeLotto, LocalDate dateJeu) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.montantMise = montantMise;
        this.joueur = joueur;
        this.Ticket = new SimpleStringProperty(cal.GenererNumeroTicket());
        this.typeLotto = typeLotto;
        this.dateJeu = LocalDateTime.now().toLocalDate();
    }

    public Jeu(SimpleIntegerProperty num1, SimpleIntegerProperty num2, 
            SimpleIntegerProperty num3, SimpleFloatProperty montantMise, Compte joueur, 
            SimpleStringProperty Ticket, TypeLotto typeLotto, LocalDate dateJeu) {
        
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.montantMise = montantMise;
        this.joueur = joueur;
        this.Ticket = new SimpleStringProperty(cal.GenererNumeroTicket());
        this.typeLotto = typeLotto;
        this.dateJeu = dateJeu;
    }

    public SimpleIntegerProperty getIdGrille() {
        return idGrille;
    }

    public void setIdGrille(SimpleIntegerProperty idGrille) {
        this.idGrille = idGrille;
    }

    public SimpleIntegerProperty getNum1() {
        return num1;
    }

    public void setNum1(SimpleIntegerProperty num1) {
        this.num1 = num1;
    }

    public SimpleIntegerProperty getNum2() {
        return num2;
    }

    public void setNum2(SimpleIntegerProperty num2) {
        this.num2 = num2;
    }

    public SimpleIntegerProperty getNum3() {
        return num3;
    }

    public void setNum3(SimpleIntegerProperty num3) {
        this.num3 = num3;
    }

    public SimpleIntegerProperty getNum4() {
        return num4;
    }

    public void setNum4(SimpleIntegerProperty num4) {
        this.num4 = num4;
    }

    public SimpleIntegerProperty getNum5() {
        return num5;
    }

    public void setNum5(SimpleIntegerProperty num5) {
        this.num5 = num5;
    }

    public SimpleIntegerProperty getNumBonus() {
        return numBonus;
    }

    public void setNumBonus(SimpleIntegerProperty numBonus) {
        this.numBonus = numBonus;
    }

    public SimpleFloatProperty getMontantMise() {
        return montantMise;
    }

    public void setMontantMise(SimpleFloatProperty montantMise) {
        this.montantMise = montantMise;
    }

    public Compte getJoueur() {
        return joueur;
    }

    public void setJoueur(Compte joueur) {
        this.joueur = joueur;
    }

    public SimpleStringProperty getTicket() {
        return Ticket;
    }

    public void setTicket(SimpleStringProperty Ticket) {
        this.Ticket = Ticket;
    }

    public TypeLotto getTypeLotto() {
        return typeLotto;
    }

    public void setTypeLotto(TypeLotto typeLotto) {
        this.typeLotto = typeLotto;
    }

    public Tirage getTirage() {
        return tirage;
    }

    public void setTirage(Tirage tirage) {
        this.tirage = tirage;
    }

    public LocalDate getDateJeu() {
        return dateJeu;
    }

    public void setDateJeu(LocalDate dateJeu) {
        this.dateJeu = dateJeu;
    }

    public int getIdOfTyrageNotYetSet() {
        return idOfTyrageNotYetSet;
    }

    public void setIdOfTyrageNotYetSet(int idOfTyrageNotYetSet) {
        this.idOfTyrageNotYetSet = idOfTyrageNotYetSet;
    }

    public Calcul getCal() {
        return cal;
    }

    public void setCal(Calcul cal) {
        this.cal = cal;
    }
    


    @Override
    public String toString() {
        
        return "Grille " + "idGrille :  " + idGrille + " num1 :  " + num1 + ", num2  : " + num2 + ", num3  : " + num3 + 
        "\n num4 :  " + num4 + " num5 :  " + num5 + " montantMise :  " + montantMise + "\n joueur :  " + joueur +
              "\n typeLotto=" + typeLotto ;
    }

   


    
    
    
    
    
    
    
}
