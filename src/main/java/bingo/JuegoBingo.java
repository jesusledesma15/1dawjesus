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

    public static void jugarBingoEuropeo() {
        BomboEuropeo bomboEU = new BomboEuropeo();
        CartonEuropeo cartonEU = new CartonEuropeo();
        bomboEU.rellenarBombo();
        cartonEU.generarCarton();
        cartonEU.imprimirCarton();
        int contL1=0, contL2=0,contL3=0;

        System.out.println("Bienvenido al Bingo Euroepo");
        //Bucle del juego
        do {
            controlarTecla();
            int num = bomboEU.sacarBola();
            System.out.println("Sale el " + num);
            System.out.println((cartonEU.tacharCasilla(num).getX() == -1 && cartonEU.tacharCasilla(num).getX() == -1) ? "No lo tienes" : "Se ha tachado el " + num);
            cartonEU.imprimirCarton();
            //Comprobamos si hace primera línea
            if (cartonEU.isFirstLine() && contL1 < 1) {
                System.out.println("Primera línea completada");
                contL1++;
            }
            //Comprobamos si hace segunda línea
            if (cartonEU.isSecondLine() && contL2 < 1) {
                System.out.println("Segunda línea completada");
                contL2++;
            }
            //Comprobamos si hace segunda línea
            if (cartonEU.isThirdLine() && contL3 < 1) {
                System.out.println("Tercera línea completada");
                contL3++;
            }
        } while (!cartonEU.isBingo()); //El juego termina el cartón canta bingo
        //Si sale del bucle es porque se ha hecho bingo y lo cantamos
        System.out.println("BINGOOOO");
    }
}
