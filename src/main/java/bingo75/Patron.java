/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo75;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Jesus
 */
public enum Patron {

    CARTON_LLENO(),
    FORMA_X(),
    FORMA_Y;

    private ArrayList<Point> casillas;
    private String descripcion;

    private Patron(ArrayList<Point> casillas, String descripcion) {
        this.casillas = casillas;
        this.descripcion = descripcion;
    }

    public ArrayList<Point> getCasillas() {
        return casillas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ArrayList<Point> cartonLLeno() {
        ArrayList<Point> patron = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                patron.add(new Point(i, j));
            }

        }

        return patron;
    }

    public ArrayList<Point> formaX() {
        ArrayList<Point> patron = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            patron.add(new Point(i, i));

        }
        patron.add(new Point(0, 4));
        patron.add(new Point(1, 3));
        patron.add(new Point(3, 2));
        patron.add(new Point(4, 0));

        return patron;
    }

    public ArrayList<Point> formaCruz() {
        ArrayList<Point> patron = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            patron.add(new Point(i, 2));
            patron.add(new Point(2, i));
        }
        return patron;
    }

    public ArrayList<Point> formaT() {
        ArrayList<Point> patron = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            patron.add(new Point(0, i));
            patron.add(new Point(2, i));
        }
        return patron;
    }


}
