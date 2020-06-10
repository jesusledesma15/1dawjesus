/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo75;

import bingo.Bombo;
import bingo.Carton;
import java.time.LocalDate;

/**
 *
 * @author Jesus
 */
public final class BingoEuropeo extends Bingo {
    private CartonEuropeo cartonEuropeo;
    private Bombo bomboEuropeo;

    public BingoEuropeo(CartonEuropeo cartonEuropeo, Bombo bomboEuropeo, LocalDate fecha, String idJugador) {
        super(fecha, idJugador);
        this.cartonEuropeo = cartonEuropeo;
        this.bomboEuropeo = bomboEuropeo;
    }
    
    
    public CartonEuropeo getCartonEuropeo() {
        return cartonEuropeo;
    }

    public Bombo getBomboEuropeo() {
        return bomboEuropeo;
    }
    
        @Override
    public String toString() {
        return super.toString() + "BingoEU: " +cartonEuropeo + " " + bomboEuropeo;
    }

}
