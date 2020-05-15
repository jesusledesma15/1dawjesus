/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import bombo.Bombo;
import carton.Carton;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class JuegoBingo {

    public static void main(String[] args) {

        //Creación de objetos necesarios
        Bombo bombo = new Bombo();
        Carton carton = new Carton();
        //Contadores para que solo cante esa linea una sola vez en el blucle
        int contL1 = 0, contL2 = 0, contL3 = 0;
        //Rellenamos el bombo de bolas
        bombo.rellenarBombo();
        //Creamos nuestro carton
        carton.generarCarton();
        carton.copyToFileTxt();
        
        System.out.println("Bienvenido al Bingo");
        //Bucle del juego
        do {
            //control de la tecla pulsada
            controlarTecla(); //Hasta que no pulse enter para sacar bola no continuara la partida
            //Imprimimos la bola que sale del bombo
            String nBola = String.valueOf(bombo.expulsarBola());
            System.out.println("Bola: " + nBola);
            //Comprobamos si el número está en el cartón para tacharla
            String tachar = (carton.tacharCasilla(nBola)) ? "Se ha tachado el número " + nBola : "No tienes el número " + nBola;
            System.out.println(tachar);
            //Comprobamos si hace primera línea
            if (carton.isFirstLine() && contL1 < 1) {
                System.out.println("Primera línea completada");
                contL1++;
            }
            //Comprobamos si hace segunda línea
            if (carton.isSecondLine() && contL2 < 1) {
                System.out.println("Segunda línea completada");
                contL2++;
            }
            //Comprobamos si hace segunda línea
            if (carton.isThirdLine() && contL3 < 1) {
                System.out.println("Tercera línea completada");
                contL3++;
            }
            //Imprimos el estado del cartón
            carton.imprimirCarton();
        } while (!carton.isBingo()); //El juego termina el cartón canta bingo
        //Si sale del bucle es porque se ha hecho bingo y lo cantamos
        System.out.println("BINGOOOO");
        carton.copyToFileTxt();
    }

    public static void controlarTecla() {
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
}