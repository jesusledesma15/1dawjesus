/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Jesus
 */
public abstract class Bombo {

    //Lista de números (bolas) atributo del bombo
    private ArrayList<Integer> bombo;

    //Inicializamos el arrayList en el constructor
    public Bombo() {
        this.bombo = new ArrayList<>();
    }

    public abstract void rellenarBombo();

    //Metodo que dice el numero de bolas dentro
    public int bolasDentro(){
        return bombo.size();
    }

    //Si la lista no está vacía, saca una posición aleatoria, borra esa posición y devuelve el número (bola) que habia en esa posición, si esta vacía devuelve -1
    public int sacarBola() {
        Random rdn = new Random();
        int numero;
        if (!bombo.isEmpty()) {
            int posicion = rdn.nextInt(bolasDentro()); //Posicion aleatoria del arraylist
            numero = bombo.get(posicion); //Lo guardamos antes de borrarlo para poder devolverlo sin que sea alterado.
            bombo.remove(posicion); //Borra la posicion aleatoria obtenida
            return numero;//Devolvemos el número que se ha obtenido en esa posición
        }
        return -1;
    }
    
    //Devuelve true si la lista de numero esta vacia
    public boolean vacio(){
        return this.bombo.isEmpty();
    }

    //Imprime las bolas que hay dentro del bombo
    public void mostrarBombo() {
        bombo.forEach((bola) -> {
            System.out.print("(" + bola + ") ");
        });
        System.out.println("");
    }

    //Getter y Setter
    public ArrayList<Integer> getNumeros() {
        return bombo;
    }

    public void setNumeros(ArrayList<Integer> numeros) {
        this.bombo = numeros;
    }

}
