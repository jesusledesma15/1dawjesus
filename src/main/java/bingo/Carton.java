/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.awt.Point;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Jesus
 */
public abstract class Carton {

    //Almacenará números, simbolos y espacios
    private int[][] carton;

    //Inicializamos el array en el constructor por defecto
    public Carton(int filas, int columnas) {
        //El carton se creará verticalmente para que la lógica pueda seguir el orden natural de i j.
        carton = new int[filas][columnas];
    }

    //Getters y setters
    public int[][] getCarton() {
        return carton;
    }

    public void setCarton(int[][] carton) {
        this.carton = carton;
    }
    
    //El metodo tachar casilla devolverá el punto tachado y convierte el valor de este en negativo
    public Point tacharCasilla(int num){
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[0].length; j++) {
                if (carton[i][j] == num) {
                    carton[i][j] = num*-1;
                    return new Point(i, j);
                }
            }
        }
        return new Point(-1, -1);
    }

//    //Recibe un número si este está en el cartón, se tacha añadiendo una X después del número
//    public boolean tacharCasilla(String numero) {
//        for (int i = 0; i < carton.length; i++) {
//            for (int j = 0; j < carton[0].length; j++) {
//                if (numero.equals(carton[i][j])) {
//                    carton[i][j] = numero + "X";
//                    return true;
//
//                }
//            }
//        }
//        return false;
//    }

    public abstract boolean isBingo();// {


  

    //Este método permite crear el carton con todos los requisitos
    public abstract void generarCarton();// {

//    }

    public void imprimirCarton() {
        //Al tener la lógica montada para un cartón vertical, tenemos que imprimirlo en horizontal, por lo tanto invertimos i y j.
        //También tenemos que invertir j ya que el menor irá arriba y el menor irá abajo
        for (int j = carton[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < carton.length; i++) {

                System.out.print("|\t" +"i"+i+" j"+ carton[i][j] + "\t|");
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
                    if (i == 5) { //Cuando i vale 8 es cuando se produce el salto a una nueva fila del carton
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
