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
public class TypeLotto {
    private int idTypeLotto;
    private String libelle;

    public TypeLotto(int idTypeLotto, String libelle) {
        this.idTypeLotto = idTypeLotto;
        this.libelle = libelle;
    }

    public TypeLotto(String libelle) {
        this.libelle = libelle;
    }

    public int getIdTypeLotto() {
        return idTypeLotto;
    }

    public void setIdTypeLotto(int idTypeLotto) {
        this.idTypeLotto = idTypeLotto;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "TypeLotto  " + "idTypeLotto :  " + idTypeLotto + " Libelle :   " + libelle; 
    }
    
    
    
}
