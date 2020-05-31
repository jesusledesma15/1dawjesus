/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import bingo75.BomboAmericano;
import bingo75.BomboEuropeo;
import bingo75.CartonAmericano;
import bingo75.CartonEuropeo;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class JuegoBingo {

    public static void main(String[] args) {
    }

    private static void controlarTecla() {
        //Instanciamos un objeto de tipo Scanner para la entrada por teclado
        Scanner keyb = new Scanner(System.in);
        //Variable para controlar la tecla pulsada del usuario
        String tecla;
        //Bucle control de la tecla pulsada
        do {
            System.out.print("Pulse enter para sacar bola: ");
            tecla = keyb.nextLine();
        } while (!tecla.equalsIgnoreCase(""));
    }

    public static void jugarBingo75() {
        BomboAmericano bombo75 = new BomboAmericano();
        CartonAmericano carton75 = new CartonAmericano();
        bombo75.rellenarBombo();
        carton75.generarCarton();
        carton75.imprimirCarton();
        System.out.println("Bienvenido al Bingo Americano");
        do {
            controlarTecla();
            int num = bombo75.sacarBola();
            System.out.println("Sale el " + num);
            System.out.println((carton75.tacharCasilla(num).getX() == -1 && carton75.tacharCasilla(num).getX() == -1) ? "No lo tienes" : "Se ha tachado el " + num);
            carton75.imprimirCarton();

        } while (!carton75.isBingo());
        System.out.println("BINGOOOOO!!");
    }


}
