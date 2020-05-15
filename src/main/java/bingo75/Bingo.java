/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo75;

import java.time.LocalDate;

/**
 *
 * @author Jesus
 */
public abstract class Bingo {

    private String id;
    private LocalDate fecha;
    private String idJugador;
    private static long contador = 0;

    public Bingo(LocalDate fecha, String idJugador) {
        this.id = String.valueOf(contador++);
        this.fecha = fecha;
        this.idJugador = idJugador;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
    }

}
