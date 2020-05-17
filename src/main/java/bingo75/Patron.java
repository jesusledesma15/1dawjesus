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
    
    
}
