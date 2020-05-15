/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.time.LocalDate;

/**
 *
 * @author Jesus
 */
public abstract class Bingo {
    private String id;
    private LocalDate fecha;
    private String idJugador;

    public Bingo(String id, LocalDate fecha, String idJugador) {
        this.id = id;
        this.fecha = fecha;
        this.idJugador = idJugador;
    }
    
    
    
}
