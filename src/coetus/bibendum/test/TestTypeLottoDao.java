/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coetus.bibendum.test;

import coetus.bibendum.dao.TypeLottoDao;
import coetus.bibendum.modele.TypeLotto;

/**
 *
 * @author Daniel
 */
public class TestTypeLottoDao {
    public static void main(String[] args) {
        TypeLotto type = new TypeLotto("SAM");
        TypeLottoDao typeLottoDao = new TypeLottoDao();
//        typeLottoDao.updateNom("Diamant", type); 
        
            System.out.println(typeLottoDao.getById(2));
        
//        TypeLotto retreive = typeLottoDao.getById(1);
        
//        for (TypeLotto v : typeLottoDao.getAll())
//            System.out.println(v);
        
      
    }
}
