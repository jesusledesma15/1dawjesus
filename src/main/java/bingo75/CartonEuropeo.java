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

    //Devuelve true si la primera linea contiene 5 X
    public boolean isFirstLine() {
        int cont = 0;
        for (String[] carton1 : carton) {
            if (carton1[2].contains("X")) {
                cont++;
            }
        }
        return cont == 5;
    }

    //Devuelve true si la segunda linea contiene 5 X
    public boolean isSecondLine() {
        int cont = 0;
        for (String[] carton1 : carton) {
            if (carton1[1].contains("X")) {
                cont++;
            }
        }
        return cont == 5;
    }

    //Devuelve true si la tercera linea contiene 5 X
    public boolean isThirdLine() {
        int cont = 0;
        for (String[] carton1 : carton) {
            if (carton1[0].contains("X")) {
                cont++;
            }
        }
        return cont == 5;
    }
    //Devuelve true si todas las lineas se han tachado

    @Override
    public boolean isBingo() {
        return isFirstLine() && isSecondLine() && isThirdLine();
    }

    @Override
    public void generarCarton() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
