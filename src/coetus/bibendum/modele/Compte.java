
package coetus.bibendum.modele;

import java.time.LocalDate;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Daniel
 */
public class Compte {
    
    public Compte() {
        
    }
    
    private SimpleIntegerProperty idCompte;
    private SimpleStringProperty pseudo, motDePasse;
    private SimpleFloatProperty solde;
    private SimpleFloatProperty prixGagner;
    private LocalDate dateCompte;
    private Personne proprio;

    public Compte(SimpleIntegerProperty idCompte, SimpleStringProperty pseudo, SimpleStringProperty motDePasse, SimpleFloatProperty solde, SimpleFloatProperty prixGagner, LocalDate dateCompte, Personne proprio) {
        this.idCompte = idCompte;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.solde = solde;
        this.prixGagner = prixGagner;
        this.dateCompte = dateCompte;
        this.proprio = proprio;
    }
    /**
     * 
     * @param pseudo
     * @param motDePasse
     * @param solde
     * @param prixGagner
     * @param dateCompte
     * @param proprio 
     */

    public Compte(SimpleStringProperty pseudo, SimpleStringProperty motDePasse, SimpleFloatProperty solde, SimpleFloatProperty prixGagner, LocalDate dateCompte, Personne proprio) {
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.solde = solde;
        this.prixGagner = prixGagner;
        this.dateCompte = dateCompte;
        this.proprio = proprio;
    }

    public SimpleIntegerProperty getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(SimpleIntegerProperty idCompte) {
        this.idCompte = idCompte;
    }

    public SimpleStringProperty getPseudo() {
        return pseudo;
    }

    public void setPseudo(SimpleStringProperty pseudo) {
        this.pseudo = pseudo;
    }

    public SimpleStringProperty getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(SimpleStringProperty motDePasse) {
        this.motDePasse = motDePasse;
    }

    public SimpleFloatProperty getSolde() {
        return solde;
    }

    public void setSolde(SimpleFloatProperty solde) {
        this.solde = solde;
    }

    public SimpleFloatProperty getPrixGagner() {
        return prixGagner;
    }

    public void setPrixGagner(SimpleFloatProperty prixGagner) {
        this.prixGagner = prixGagner;
    }

    public LocalDate getDateCompte() {
        return dateCompte;
    }

    public void setDateCompte(LocalDate dateCompte) {
        this.dateCompte = dateCompte;
    }

    /**
     * 
     * @return 
     */
    public Personne getProprio() {
        return this.proprio;
    }

    public void setProprio(Personne proprio) {
        this.proprio = proprio;
    }

    @Override
    public String toString() {
        return "Compte{" + "idCompte=" + idCompte + ", pseudo=" + pseudo + ", motDePasse=" + motDePasse + ", solde=" + solde + ", prixGagner=" + prixGagner + ", dateCompte=" + dateCompte + ", proprio=" + proprio + '}';
    }
    
    
    
 
    
    
}
