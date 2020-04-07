/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

/**
 *
 * @author Jesus
 */
public class Prueba {

    public static void main(String[] args) {
        int i = 0;
        Bombo bombo = new Bombo();
        bombo.rellenarBombo();
        System.out.println("--------------------------------------------------");
        bombo.mostrarBombo();
        for (int j = 0; j < 91; j++) {
            System.out.println("Tirada nº" + j + " " + bombo.expulsarBola());
        }

    }
}
