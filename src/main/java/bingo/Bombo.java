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
public class Bombo {

    //Lista de números (bolas) atributo del bombo
    private ArrayList<Integer> bombo;

    //Inicializamos el arrayList en el constructor
    public Bombo() {
        this.bombo = new ArrayList<>();
    }

    //Añade números desde 1-90 inclusives al bombo
    public void rellenarBombo() {
        for (int i = 1; i <= 90; i++) {
            bombo.add(i);
        }
    }
    
    public int getBolasBombo(){
        return bombo.size();
    }

    //Si la lista no está vacía, saca una posición aleatoria, borra esa posición y devuelve el número (bola) que habia en esa posición, si esta vacía devuelve -1
    public int expulsarBola() {
        Random rdn = new Random();
        int numero;
        if (!bombo.isEmpty()) {
            int posicion = rdn.nextInt(getBolasBombo()); //Posicion aleatoria del arraylist
            numero = bombo.get(posicion); //Lo guardamos antes de borrarlo para poder devolverlo sin que sea alterado.
            bombo.remove(posicion); //Borra la posicion aleatoria obtenida
            return numero;//Devolvemos el número que se ha obtenido en esa posición
        }
        return -1;
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
