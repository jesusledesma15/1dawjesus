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

    private ArrayList<Integer> numeros;

    public Bombo() {
        this.numeros = new ArrayList<>();
    }

    public void rellenarBombo() {
        for (int i = 1; i <= 90; i++) {
            numeros.add(i);
        }
    }

    public int expulsarBola() {
        Random rdn = new Random();
        int numero;
        if (!numeros.isEmpty()) {
            System.out.println("Números dentro: " + numeros.size());
            numero = numeros.get(rdn.nextInt(numeros.size()) + 1);
            numeros.remove(numero - 1);
            return numero;
        }
        return 0;
    }

    public void mostrarBombo() {
        numeros.forEach((bola) -> {
            System.out.print("(" + bola + ") ");
        });
    }

    public ArrayList<Integer> getNumeros() {
        return numeros;
    }

    public void setNumeros(ArrayList<Integer> numeros) {
        this.numeros = numeros;
    }    
    
}
