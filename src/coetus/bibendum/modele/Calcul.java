/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.modele;


import java.util.Random;

/**
 *
 * @author Daniel
 */
public class Calcul {
    
    
    Random random;
    int valeurGrille = 50;
    int table [] = new int[5];
    int numbonusTirage;
    
    
    public int [] genererTirage(){
        random = new Random();
  
        for(int y=0; y<5; y++)
        {
             int n = 1+random.nextInt(90);
              table[y] = n;
        }
       return table;
    }
    
    public int GenererNumeroBonus()
    {
        random = new Random();
        numbonusTirage = random.nextInt(11);
        return numbonusTirage;
    }
    
    
    public String GenererNumeroTicket()
    {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz"
                + "123456789";

        StringBuilder s = new StringBuilder(10);
        String fBuilder = "Num#";
        s.append(fBuilder);

        for (int i = 0; i < 10; i++) {
            int index = (int) (str.length() * Math.random());
            s.append(str.charAt(index));
        }
       
        return s.toString();
    }

    public int[] getTable() {
        return table;
    }

    public void setTable(int[] table) {
        this.table = table;
    }

    
    
    public int getNumbonusTirage() {
        return numbonusTirage;
    }

    public void setNumbonusTirage(int numbonusTirage) {
        this.numbonusTirage = numbonusTirage;
    }

   
    
    
    
}
