/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo75;

import bingo.Carton;
import java.util.Random;

/**
 *
 * @author Jesus
 */
public class CartonEuropeo extends Carton {

    public static final int COLUMNAS = 9;
    public static final int FILAS = 3;

    public CartonEuropeo() {
        super(FILAS, COLUMNAS);
    }
 //Creado para el metodo generarEspacios()
    //Permite poner el espacio en indices diferentes, habrá 4 espacios por fila, devuelve true si todos los números son diferentes
    private boolean areNumDiferent(int uno, int dos, int tres, int cuatro) {
        boolean distintos = false;
        if (uno != dos && uno != tres && uno != cuatro) {
            if (dos != tres && dos != cuatro) {
                if (tres != cuatro) {
                    distintos = true;
                }
            }
        }
        return distintos;
    }
    private void generarEspacios() {
        Random rdn = new Random();
        int espacio1, espacio2, espacio3, espacio4;
        int cont = 0; //Con este contado sabré los espacios que me quedan por poner en la tercera fila
        //Recorremos la primera fila del cartón, le llamo j porque está invertido el recorrido, ya que utilizo una matriz de 9x3
        for (int j = getCarton()[0].length - 1; j >= 0; j--) {
            //Debemos tener por fila cuatro espacios, por la tanto uso el metodo areNumDiferents para sacar cuatros espacios en indices difentes
            do {
                //Creamos 4 indices aleatorios donde poner los espacios
                espacio1 = rdn.nextInt(9);
                espacio2 = rdn.nextInt(9);
                espacio3 = rdn.nextInt(9);
                espacio4 = rdn.nextInt(9);
            } while (!areNumDiferent(espacio1, espacio2, espacio3, espacio4)); //Salimos del bucle cuando los 4 números para los indices sean difentes
            for (int i = 0; i < getCarton()[0].length; i++) {
                //Con este if accedemos solo a la primera y segunda fila
                if (j == 2 || j == 1) { // Añadimos los espacios a la primera y segunda fila del cartón, no importa el indice en el que caigan los espacios
                    getCarton()[espacio1][j] = 0;
                    getCarton()[espacio2][j] = 0;
                    getCarton()[espacio3][j] = 0;
                    getCarton()[espacio4][j] = 0;
                }
                //Con este if entramos en la tercera fila, para colocar los espacios seguros, que será cuando la misma posicion de las dos filas superiores ya tengan números
                if (j == 0) {
                    if (!(getCarton()[i][1] == 0 || getCarton()[i][2] == 0)) { //Con este if sabremos si en las posiciones superiores tienen dos números
                        //Si es así estamos obligado a colocar ahí un espacio
                        getCarton()[i][j] = 0;
                        //Actualizamos el contador para finalmente saber cuantos espacios más debemos colocar en la tercera fila
                        cont++;
                    }
                }

            }
        }
        //Control de los espacios restantes de la tercera fila
        //Si contador no vale cuatro es porque necesitamos colocar aún espacios en la tercera fila

        if (cont < 4) {
            //Dentro debemos acceder solo a la última fila que para mi es carton[0]
            for (int[] carton1 : getCarton()) {
                //Podremos poner los espacios que faltan si, en alguna de las dos posiciones de arriba de la propia columna, al menos hay un espacio
                //Y además en la propia posición de la fila tres no hay un espacio ya.
                if (carton1[0] != 0 && (carton1[2] != 0 || carton1[1] != 0)) {
                    //Cumpliendo lo anterior podremos añadir un espacio y sumarselo al contador
                    carton1[0] = 0;
                    cont++;
                }
                //Como estamos recorriendo la ultima fila entera saber que es lo que tenemos, debemos controlar que si cont ya vale 4 salir del bucle
                if (cont == 4) {
                    break;
                }
            }
        }
    }

    //Devuelve true si la primera linea contiene 5 X
    public boolean isFirstLine() {
        int cont = 0;
        for (int[] carton1 : getCarton()) {
            if (carton1[2].contains("X")) {
                cont++;
            }
        }
        return cont == 5;
    }

    //Devuelve true si la segunda linea contiene 5 X
    public boolean isSecondLine() {
        int cont = 0;
        for (int[] carton1 : carton) {
            if (carton1[1].contains("X")) {
                cont++;
            }
        }
        return cont == 5;
    }

    //Devuelve true si la tercera linea contiene 5 X
    public boolean isThirdLine() {
        int cont = 0;
        for (String[] carton1 : carton) {
            if (carton1[0].contains("X")) {
                cont++;
            }
        }
        return cont == 5;
    }
    //Devuelve true si todas las lineas se han tachado

    @Override
    public boolean isBingo() {
        return isFirstLine() && isSecondLine() && isThirdLine();
    }

    @Override
    public void generarCarton() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
