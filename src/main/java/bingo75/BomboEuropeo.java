/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo75;

import bingo.Bombo;
import java.util.Collections;

/**
 *
 * @author Jesus
 */
public final class BomboEuropeo extends Bombo {

    public static final int CANTIDAD_BOLAS = 90;
    
      @Override
    public void rellenarBombo() {
        for (int i = 1; i <= CANTIDAD_BOLAS; i++) {
            getNumeros().add(i);
        }
        Collections.shuffle(getNumeros());
    }

    
}
