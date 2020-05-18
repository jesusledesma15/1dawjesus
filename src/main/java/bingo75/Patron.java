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

    public ArrayList<Point> cartonLLeno(int tam) {
        ArrayList<Point> patron = new ArrayList<>();
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < 10; j++) {
                patron.add(new Point(i, j));
            }

        }

        return patron;
    }
}
