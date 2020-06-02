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
public class BingoAmericano extends Bingo{
    private Carton cartonAmericano;
    public Bombo bomboAmericano;

    public BingoAmericano(Carton cartonAmericano, Bombo bomboAmericano, LocalDate fecha, String idJugador) {
        super(fecha, idJugador);
        this.cartonAmericano = cartonAmericano;
        this.bomboAmericano = bomboAmericano;
    }



    public Carton getCartonAmericano() {
        return cartonAmericano;
    }

    public Bombo getBomboAmericano() {
        return bomboAmericano;
    }

    @Override
    public String toString() {
        return super.toString() + "BingoAmericano{" + "cartonAmericano=" + cartonAmericano + ", bomboAmericano=" + bomboAmericano + '}';
    }

      
}
