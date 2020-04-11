/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carton;

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

    public String[][] getCarton() {
        return carton;
    }

    public void setCarton(String[][] carton) {
        this.carton = carton;
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
            //Este if permite que la ultima columna pueda tener el 90 también.
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

    }

    //Devuelve un String con un numero aleatorio entre desde y hasta 
    private String getNumEntre(int desde, int hasta) {
        Random rdn = new Random();
        return String.valueOf(rdn.nextInt(hasta - desde + 1) + desde);
    }

    public void imprimirCarton() {
        //Al tener la lógica montada para un cartón vertical, tenemos que imprimirlo en horizontal, por lo tanto invertimos i y j.
        //También tenemos que invertir j ya que el menor irá arriba y el menor irá abajo
        for (int j = carton[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < carton.length; i++) {
                System.out.print("i:" + i + " j:" + j + " " + carton[i][j] + "\t");
                if (i == 8) { //Cuando i vale 8 es cuando se produce el salto a una nueva fila del carton
                    System.out.println("");
                }
            }
        }
    }

}
