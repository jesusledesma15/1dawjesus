/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo75;

import bingo.Carton;
import java.awt.Point;
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

        switch (rdm.nextInt(5)) {
            case 0:
                return Patron.CARTON_LLENO;
            case 1:
                return Patron.FORMA_CRUZ;
            case 2:
                return Patron.FORMA_L;
            case 3:
                return Patron.FORMA_T;
            case 4:
                return Patron.FORMA_X;
        }
        return null;
    }

    private ArrayList<Integer> numDistintos(int desde, int hasta) {
        ArrayList<Integer> numDistintos = new ArrayList<>();
        int numero;
        while (numDistintos.size() != COLUMNAS + 1) {
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
                    getCarton()[premio.getCasillas().get(i).x][premio.getCasillas().get(i).y] = y0.remove(0);
                    break;
                case 1:
                    getCarton()[premio.getCasillas().get(i).x][premio.getCasillas().get(i).y] = y1.remove(0);
                    break;
                case 2:
                    getCarton()[premio.getCasillas().get(i).x][premio.getCasillas().get(i).y] = y2.remove(0);
                    break;
                case 3:
                    getCarton()[premio.getCasillas().get(i).x][premio.getCasillas().get(i).y] = y3.remove(0);
                    break;
                case 4:
                    getCarton()[premio.getCasillas().get(i).x][premio.getCasillas().get(i).y] = y4.remove(0);
                    break;
            }

        }
    }

    @Override
    public void imprimirCarton() {
        System.out.println("B\tI\tN\tG\tO");
        for (int i = 0; i < getCarton().length; i++) {
            for (int j = 0; j < getCarton().length; j++) {
                String valor = getCarton()[i][j] == 0 ? "" : String.valueOf(getCarton()[i][j]);
                System.out.print(valor + "\t");
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
        boolean isBingo = false;
        for (Point punto : this.premio.getCasillas()) {
            isBingo = (punto.getX()<0 && punto.getY()<0);
            if (!isBingo) {
                break;
            }
        }
        return isBingo;
    }

    private int getNumEntre(int desde, int hasta) {
        Random rdn = new Random();
        return (rdn.nextInt(hasta - desde + 1) + desde);
    }

    public static void main(String[] args) {
        CartonAmericano c = new CartonAmericano();
        c.generarCarton();
        System.out.println(c.getPremio());
        c.imprimirCarton();
    }
}
