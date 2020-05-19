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
public final class CartonAmericano extends Carton {

    private Patron premio;
    public static final int COLUMNAS = 5;
    public static final int FILAS = 5;

    public CartonAmericano(Patron premio) {
        super(FILAS, COLUMNAS);
        this.premio = premio;
    }

    @Override
    public void generarCarton() {
        
    }

    public Patron getPremio() {
        return premio;
    }

    @Override
    public String toString() {
        return "CartonAmericano{" + "premio=" + premio + '}';
    }

    @Override
    public boolean isBingo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
