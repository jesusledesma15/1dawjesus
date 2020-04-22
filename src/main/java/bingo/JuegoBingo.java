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
        //Instanciamos un objeto de tipo Scanner para la entrada por teclado
        Scanner keyb = new Scanner(System.in);
        //Creación de objetos necesarios
        Bombo bombo = new Bombo();
        Carton carton = new Carton();
        //Variable para guardar por teclado la tecla pulsada por el usuario
        String tecla;
        //Contadores para que solo cante esa linea una sola vez en el blucle
        int contL1 = 0, contL2 = 0, contL3 = 0;
        //Rellenamos el bombo de bolas
        bombo.rellenarBombo();
        //Creamos nuestro carton
        carton.generarCarton();

    }
}
