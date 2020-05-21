/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo75;

import bingo.Carton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Jesus
 */
public final class CartonAmericano extends Carton {

    private Patron premio;
    public static final int COLUMNAS = 5;
    public static final int FILAS = 5;

    public CartonAmericano() {
        super(FILAS, COLUMNAS);
        this.premio = patronRandom();
    }

    private Patron patronRandom() {
        Random rdm = new Random();

        switch (rdm.nextInt(3)) {
            case 0:
                return Patron.CARTON_LLENO;
            case 1:
                return Patron.FORMA_CRUZ;
            case 2:
                return Patron.FORMA_L;
            case 3:
                return Patron.FORMA_T;
            default:
                return Patron.FORMA_X;
        }
    }

//    private ArrayList<Integer> numDistintos(int desde, int hasta) {
//        ArrayList<Integer> numDistintos = new ArrayList<>();
//        int numero;
//        while (numDistintos.size() != 5) {
//            numero = getNumEntre(desde, hasta);
//            if (!numDistintos.contains(numero)) {
//                numDistintos.add(numero);
//            }
//        }
//
//        return numDistintos;
//    }
    @Override
    public void generarCarton() {
        for (int i = 0; i < premio.getCasillas().size(); i++) {
            for (int j = 0; j < premio.getCasillas().size(); j++) {
                premio.getCasillas().get(i).x = 1;
            }
        }
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

    private int getNumEntre(int desde, int hasta) {
        Random rdn = new Random();
        return (rdn.nextInt(hasta - desde + 1) + desde);
    }

}
