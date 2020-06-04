/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo75;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Jesus
 */
public class BingoVO {
    
    private String id;
    private LocalDate fecha;
    private String idjugador;
    private int tipo;
    private ArrayList<Integer> bombo;
    private int[][] carton;

    public BingoVO(String id, LocalDate fecha, String idjugador, int tipo, ArrayList<Integer> bombo, int[][] carton) {
        this.id = id;
        this.fecha = fecha;
        this.idjugador = idjugador;
        this.tipo = tipo;
        this.bombo = bombo;
        this.carton = carton;
    }

    public BingoVO() {
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

    public String getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(String idjugador) {
        this.idjugador = idjugador;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Integer> getBombo() {
        return bombo;
    }

    public void setBombo(ArrayList<Integer> bombo) {
        this.bombo = bombo;
    }

    public int[][] getCarton() {
        return carton;
    }

    public void setCarton(int[][] carton) {
        this.carton = carton;
    }

    @Override
    public String toString() {
        return "BingoVO{" + "id=" + id + ", fecha=" + fecha + ", idjugador=" + idjugador + ", tipo=" + tipo + ", bombo=" + bombo + ", carton=" + carton + '}';
    }        
    
}
