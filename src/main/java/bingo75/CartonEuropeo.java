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
public final class CartonEuropeo extends Carton {

    public static final int COLUMNAS = 9;
    public static final int FILAS = 3;

    public CartonEuropeo() {
        super(COLUMNAS, FILAS);
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

    //Devuelve un String con un numero aleatorio entre desde y hasta que pasamos por paramatros
    private int getNumEntre(int desde, int hasta) {
        Random rdn = new Random();
        return (rdn.nextInt(hasta - desde + 1) + desde);
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
            for (int i = 0; i < getCarton().length; i++) {
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

    //Devuelve true si la primera linea contiene 9 números menor que 1
    public boolean isFirstLine() {
        int cont = 0;
        for (int[] carton1 : getCarton()) {
            if (carton1[2] < 1) {
                cont++;
            }
        }
        return cont == COLUMNAS;
    }

    //Devuelve true si la segunda linea contiene 9 números menor que 1
    public boolean isSecondLine() {
        int cont = 0;
        for (int[] carton1 : getCarton()) {
            if (carton1[1] < 1) {
                cont++;
            }
        }
        return cont == COLUMNAS;
    }

    //Devuelve true si la tercera linea contiene 9 números menor que 1
    public boolean isThirdLine() {
        int cont = 0;
        for (int[] carton1 : getCarton()) {
            if (carton1[0] < 1) {
                cont++;
            }
        }
        return cont == COLUMNAS;
    }
    //Devuelve true si todas las lineas se han tachado

    @Override
    public boolean isBingo() {
        return isFirstLine() && isSecondLine() && isThirdLine();
    }

    @Override
    public void generarCarton() {
        int hasta = 9;
        int desde = 1;
        for (int i = 0; i < getCarton().length; i++) {
            //Este if controla que apartir de la segunda columna en el carton puedan empezar por 10,20,30,40,50,60,70,80
            if (i == 1) {
                desde--;
            }
            //Este if permite que la ultima columna pueda tener el 90 también
            if (i == 8) {
                hasta++;
            }
            //Creacion de los números aleatorios por fila
            int n1 = getNumEntre(desde, hasta), n2 = getNumEntre(desde, hasta), n3 = getNumEntre(desde, hasta);

            for (int j = 0; j < getCarton()[0].length; j++) {
                //Control para el primer numero de cada columna
                //El número siempre va a ser mas chico por tres números que el numero "hasta" de esa columna
                if (n1 <= hasta - 4) {
                    getCarton()[i][2] = n1;
                } else {
                    //Hasta que no salga un número con dicho requisito no podemos asignarlo a la primera posición
                    do {
                        n1 = getNumEntre(desde, hasta);
                    } while (n1 > hasta - 4);

                }
                //Control para el segundo numero de cada columna
                //El número siempre va a ser mas chico por dos números que el numero hasta de esa columna, además va a ser mayor que el número de arriba
                if (n2 <= hasta - 3 && n2 > (n1)) {
                    getCarton()[i][1] = n2;
                } else {
                    //Hasta que no salga un número con dichos requisitos no podemos asignarlo a la primera posición
                    do {
                        n2 = getNumEntre(desde, hasta);
                    } while (n2 > hasta - 3 || n2 <= n1);
                }

                //Control para el tercer numero de cada columna
                //El número siempre va a ser mayor que el número de arriba
                if (n3 > n2) {
                    getCarton()[i][0] = n3;
                } else {
                    //Hasta que no salga un número con dichos requisitos no podemos asignarlo a la primera posición
                    do {
                        n3 = getNumEntre(desde, hasta);
                    } while (n3 <= n2);
                }
            }
            //Actualizamos los números que tendrá la siguiente fila
            desde += 10;
            hasta += 10;
        }
        generarEspacios();
    }

    @Override
    public void imprimirCarton() {
        //Al tener la lógica montada para un cartón vertical, tenemos que imprimirlo en horizontal, por lo tanto invertimos i y j.
        //También tenemos que invertir j ya que el menor irá arriba y el menor irá abajo
        for (int j = getCarton()[0].length - 1; j >= 0; j--) {
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < getCarton().length; i++) {
                String valor = getCarton()[i][j] == 0 ? "" : String.valueOf(getCarton()[i][j]);
                System.out.print("|\t" + valor + "\t|");
                if (i == 8) { //Cuando i vale 8 es cuando se produce el salto a una nueva fila del carton
                    System.out.println("");
                }
            }
        }
         System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
    }

}
