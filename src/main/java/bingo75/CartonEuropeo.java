/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo75;

import bingo.Carton;

/**
 *
 * @author Jesus
 */
public class CartonEuropeo extends Carton {

    public static final int COLUMNAS = 9;
    public static final int FILAS = 3;

    public CartonEuropeo() {
        super(FILAS, COLUMNAS);
    }

    @Override
    public boolean isBingo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void generarCarton() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
