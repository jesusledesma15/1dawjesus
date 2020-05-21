/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo75;

import bingo.Carton;
import java.util.ArrayList;
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

    private ArrayList<Integer> numDistintos(int desde, int hasta) {
        ArrayList<Integer> numDistintos = new ArrayList<>();
        int numero;
        while (numDistintos.size() != 6) {
            numero = getNumEntre(desde, hasta);
            if (!numDistintos.contains(numero)) {
                numDistintos.add(numero);
            }
        }

        return numDistintos;
    }

    @Override
    public void generarCarton() {
        ArrayList<Integer> y0 = numDistintos(1, 15);
        ArrayList<Integer> y1 = numDistintos(16, 30);
        ArrayList<Integer> y2 = numDistintos(31, 45);
        ArrayList<Integer> y3 = numDistintos(46, 60);
        ArrayList<Integer> y4 = numDistintos(61, 75);
        for (int i = 0; i < premio.getCasillas().size(); i++) {
            switch (premio.getCasillas().get(i).y) {
                case 0:
                    getCarton()[premio.getCasillas().get(i).x][premio.getCasillas().get(i).y] = y0.remove(y0.size() - 1);
                    break;
                case 1:
                    getCarton()[premio.getCasillas().get(i).x][premio.getCasillas().get(i).y] = y1.remove(y1.size() - 1);
                    break;
                case 2:
                    getCarton()[premio.getCasillas().get(i).x][premio.getCasillas().get(i).y] = y2.remove(y2.size() - 1);
                    break;
                case 3:
                    getCarton()[premio.getCasillas().get(i).x][premio.getCasillas().get(i).y] = y3.remove(y3.size() - 1);
                    break;
                case 4:
                    getCarton()[premio.getCasillas().get(i).x][premio.getCasillas().get(i).y] = y4.remove(y4.size() - 1);
                    break;
            }

        }
    }

    @Override
    public void imprimirCarton() {
        System.out.println("B\tI\tN\tG\tO");
        for (int i = 0; i < getCarton().length; i++) {
            for (int j = 0; j < getCarton()[0].length; j++) {
                System.out.print(getCarton()[i][j] + "\t");
                if (j == 4) {
                    System.out.println("");
                }
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
