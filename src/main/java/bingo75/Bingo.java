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

    public Bingo(LocalDate fecha, String idJugador) {
        this.fecha = fecha;
        this.idJugador = idJugador;
        this.id = getID(idJugador);
    }

    //Método que permite obtener un id formado por letra final del idJugador, letra inicial del idJugador,
    // -, dia del año, anyo, longitud del idJugador , de cuando se creó la partida
    private String getID(String idJugador) {
        String letra1 = "A";
        String letra2 = "G";
        if (idJugador.length() > 1) {
            letra1 = String.valueOf(idJugador.toUpperCase().charAt(idJugador.length() - 1));
            letra2 = String.valueOf(idJugador.toUpperCase().charAt(0));
        }
        String dia = String.valueOf(LocalDate.now().getDayOfYear());
        String anyo = String.valueOf(LocalDate.now().getYear());
        String tamId = String.valueOf(idJugador.length());
        return letra1 + letra2 + "-" + dia + anyo + tamId;
    }

    //Getters y setters
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

    //To String
    @Override
    public String toString() {
        return "ID Partida: " + id + " Fecha:" + fecha + " ID Jugador: " + idJugador;
    }

}
