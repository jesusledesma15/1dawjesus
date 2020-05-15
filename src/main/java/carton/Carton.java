/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Jesus
 */
public class Carton {

    //Almacenará números, simbolos y espacios
    private String[][] carton;

    //Inicializamos el array en el constructor por defecto
    public Carton() {
        //El carton se creará verticalmente para que la lógica pueda seguir el orden natural de i j.
        carton = new String[9][3];
    }

    //Getters y setters
    public String[][] getCarton() {
        return carton;
    }

    public void setCarton(String[][] carton) {
        this.carton = carton;
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

    //Recibe un número si este está en el cartón, se tacha añadiendo una X después del número
    public boolean tacharCasilla(String numero) {
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[0].length; j++) {
                if (numero.equals(carton[i][j])) {
                    carton[i][j] = numero + "X";
                    return true;

                }
            }
        }
        return false;
    }

    //Devuelve true si la primera linea contiene 5 X
    public boolean isFirstLine() {
        int cont = 0;
        for (String[] carton1 : carton) {
            if (carton1[2].contains("X")) {
                cont++;
            }
        }
        return cont == 5;
    }

    //Devuelve true si la segunda linea contiene 5 X
    public boolean isSecondLine() {
        int cont = 0;
        for (String[] carton1 : carton) {
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
    public boolean isBingo() {
        return isFirstLine() && isSecondLine() && isThirdLine();

    }

    private void generarEspacios() {
        Random rdn = new Random();
        int espacio1, espacio2, espacio3, espacio4;
        int cont = 0; //Con este contado sabré los espacios que me quedan por poner en la tercera fila
        //Recorremos la primera fila del cartón, le llamo j porque está invertido el recorrido, ya que utilizo una matriz de 9x3
        for (int j = carton[0].length - 1; j >= 0; j--) {
            //Debemos tener por fila cuatro espacios, por la tanto uso el metodo areNumDiferents para sacar cuatros espacios en indices difentes
            do {
                //Creamos 4 indices aleatorios donde poner los espacios
                espacio1 = rdn.nextInt(9);
                espacio2 = rdn.nextInt(9);
                espacio3 = rdn.nextInt(9);
                espacio4 = rdn.nextInt(9);
            } while (!areNumDiferent(espacio1, espacio2, espacio3, espacio4)); //Salimos del bucle cuando los 4 números para los indices sean difentes
            for (int i = 0; i < carton.length; i++) {
                //Con este if accedemos solo a la primera y segunda fila
                if (j == 2 || j == 1) { // Añadimos los espacios a la primera y segunda fila del cartón, no importa el indice en el que caigan los espacios
                    carton[espacio1][j] = "";
                    carton[espacio2][j] = "";
                    carton[espacio3][j] = "";
                    carton[espacio4][j] = "";
                }
                //Con este if entramos en la tercera fila, para colocar los espacios seguros, que será cuando la misma posicion de las dos filas superiores ya tengan números
                if (j == 0) {
                    if (!(carton[i][1].equals("") || carton[i][2].equals(""))) { //Con este if sabremos si en las posiciones superiores tienen dos números
                        //Si es así estamos obligado a colocar ahí un espacio
                        carton[i][j] = "";
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
            for (String[] carton1 : carton) {
                //Podremos poner los espacios que faltan si, en alguna de las dos posiciones de arriba de la propia columna, al menos hay un espacio
                //Y además en la propia posición de la fila tres no hay un espacio ya.
                if (!carton1[0].equals("") && (!carton1[2].equals("") || !carton1[1].equals(""))) {
                    //Cumpliendo lo anterior podremos añadir un espacio y sumarselo al contador
                    carton1[0] = "";
                    cont++;
                }
                //Como estamos recorriendo la ultima fila entera saber que es lo que tenemos, debemos controlar que si cont ya vale 4 salir del bucle
                if (cont == 4) {
                    break;
                }
            }
        }
    }

    //Este método permite crear el carton con todos los requisitos
    public void generarCarton() {
        int hasta = 9;
        int desde = 1;
        for (int i = 0; i < carton.length; i++) {
            //Este if controla que apartir de la segunda columna en el carton puedan empezar por 10,20,30,40,50,60,70,80
            if (i == 1) {
                desde--;
            }
            //Este if permite que la ultima columna pueda tener el 90 también
            if (i == 8) {
                hasta++;
            }
            //Creacion de los números aleatorios por fila
            String n1 = getNumEntre(desde, hasta), n2 = getNumEntre(desde, hasta), n3 = getNumEntre(desde, hasta);

            for (int j = 0; j < carton[0].length; j++) {
                //Control para el primer numero de cada columna
                //El número siempre va a ser mas chico por tres números que el numero "hasta" de esa columna
                if (Integer.parseInt(n1) <= hasta - 4) {
                    carton[i][2] = n1;
                } else {
                    //Hasta que no salga un número con dicho requisito no podemos asignarlo a la primera posición
                    do {
                        n1 = getNumEntre(desde, hasta);
                    } while (Integer.parseInt(n1) > hasta - 4);

                }
                //Control para el segundo numero de cada columna
                //El número siempre va a ser mas chico por dos números que el numero hasta de esa columna, además va a ser mayor que el número de arriba
                if (Integer.parseInt(n2) <= hasta - 3 && Integer.parseInt(n2) > Integer.parseInt(n1)) {
                    carton[i][1] = n2;
                } else {
                    //Hasta que no salga un número con dichos requisitos no podemos asignarlo a la primera posición
                    do {
                        n2 = getNumEntre(desde, hasta);
                    } while (Integer.parseInt(n2) > hasta - 3 || Integer.parseInt(n2) <= Integer.parseInt(n1));
                }

                //Control para el tercer numero de cada columna
                //El número siempre va a ser mayor que el número de arriba
                if (Integer.parseInt(n3) > Integer.parseInt(n2)) {
                    carton[i][0] = n3;
                } else {
                    //Hasta que no salga un número con dichos requisitos no podemos asignarlo a la primera posición
                    do {
                        n3 = getNumEntre(desde, hasta);
                    } while (Integer.parseInt(n3) <= Integer.parseInt(n2));
                }
            }
            //Actualizamos los números que tendrá la siguiente fila
            desde += 10;
            hasta += 10;
        }
        generarEspacios();
    }

    //Devuelve un String con un numero aleatorio entre desde y hasta que pasamos por paramatros
    private String getNumEntre(int desde, int hasta) {
        Random rdn = new Random();
        return String.valueOf(rdn.nextInt(hasta - desde + 1) + desde);
    }

    public void imprimirCarton() {
        //Al tener la lógica montada para un cartón vertical, tenemos que imprimirlo en horizontal, por lo tanto invertimos i y j.
        //También tenemos que invertir j ya que el menor irá arriba y el menor irá abajo
        for (int j = carton[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < carton.length; i++) {
                System.out.print("|\t" + carton[i][j] + "\t|");
                if (i == 8) { //Cuando i vale 8 es cuando se produce el salto a una nueva fila del carton
                    System.out.println("");
                }
            }
        }
    }

    public void copyToFileTxt() {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idfichero = "carton.txt";

        // Array a escribir
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idfichero))) {
            for (int j = carton[0].length - 1; j >= 0; j--) {
                for (int i = 0; i < carton.length; i++) {
                    flujo.write("|\t" + carton[i][j] + "\t|");
                    if (i == 8) { //Cuando i vale 8 es cuando se produce el salto a una nueva fila del carton
                        flujo.newLine();
                    }
                }
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            //Cerramos la conexion 
            flujo.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
