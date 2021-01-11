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
public class TypeLotto {
    private SimpleIntegerProperty idTypeLotto;
    private SimpleStringProperty libelle;

    public TypeLotto(SimpleIntegerProperty idTypeLotto, SimpleStringProperty libelle) {
        this.idTypeLotto = idTypeLotto;
        this.libelle = libelle;
    }

    public TypeLotto(SimpleStringProperty libelle) {
        this.libelle = libelle;
    }

    public SimpleIntegerProperty getIdTypeLotto() {
        return idTypeLotto;
    }

    public void setIdTypeLotto(SimpleIntegerProperty idTypeLotto) {
        this.idTypeLotto = idTypeLotto;
    }

    public SimpleStringProperty getLibelle() {
        return libelle;
    }

    public void setLibelle(SimpleStringProperty libelle) {
        this.libelle = libelle;
    }

    
   
/**
 * lotto ou tombola ou kadoo ou .....
 * @return libelle 
 */


    @Override
    public String toString() {
        return "TypeLotto  " + "idTypeLotto :  " + idTypeLotto + " Libelle :   " + libelle; 
    }
    
    
    
}
