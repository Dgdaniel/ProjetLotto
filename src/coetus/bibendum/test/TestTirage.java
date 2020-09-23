/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.test;

import coetus.bibendum.modele.Tirage;

/**
 *
 * @author Daniel
 */
public class TestTirage {
    
    public static void main(String[] args) {
        Tirage n = new Tirage(14, 15, 18, 78, 90, 5);
        System.out.println(n);
        
        System.out.println(n.getJourTirage());
    }
}
