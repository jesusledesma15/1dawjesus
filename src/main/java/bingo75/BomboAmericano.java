/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo75;

import bingo.Bombo;

/**
 *
 * @author Jesus
 */
public final class BomboAmericano extends Bombo {

    public static final int CANTIDAD_BOLAS = 75;

    //Permite rellenar el bombo con el número de bolas de un bingo Americano
    @Override
    public void rellenarBombo() {
        for (int i = 1; i <= CANTIDAD_BOLAS; i++) {
            getNumeros().add(i);
        }
    }

}
