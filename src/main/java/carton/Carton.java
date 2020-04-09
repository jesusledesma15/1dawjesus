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

    private String[][] carton;

    public Carton() {
        carton = new String[9][3];
    }

    public String[][] getCarton() {
        return carton;
    }

    public void setCarton(String[][] carton) {
        this.carton = carton;
    }

    public void generarCarton() {
        int hasta = 10;
        int desde = 1;
        for (int i = 0; i < carton.length; i++) {
            String n1 = getNumEntre(desde, hasta);
            System.out.println("Columna " + i);
            System.out.println("F1: " + n1);
            String n2 = getNumEntre(desde, hasta);
            System.out.println("F2: " + n2);
            String n3 = getNumEntre(desde, hasta);
            System.out.println("F3: " + n3 + "\n");
            for (int j = 0; j < carton[0].length; j++) {
                //Control para el primer numero de cada columna
                if (Integer.parseInt(n1) <= hasta - 3) {
                    carton[i][2] = n1;
                } else {
                    do {
                        n1 = getNumEntre(desde, hasta);
                    } while (Integer.parseInt(n1) > hasta - 3);

                }
                //Control para el segundo numero de cada columna
                //El número siempre va a ser mas chico por dos números que el numero hasta de esa columna, además debe de ser mayor que el número de arriba
                if (Integer.parseInt(n2) <= hasta - 2 && Integer.parseInt(n2) > Integer.parseInt(n1)) {
                    carton[i][1] = n2;
                } else {
                    do {
                        n2 = getNumEntre(desde, hasta);
                    } while (Integer.parseInt(n2) > hasta - 2 || Integer.parseInt(n2) <= Integer.parseInt(n1));
                }

                //Control para el tercer numero de cada columna
                if (Integer.parseInt(n3) > Integer.parseInt(n2)) {
                    carton[i][0] = n3;
                } else {
                    do {
                        n3 = getNumEntre(desde, hasta);
                    } while (Integer.parseInt(n3) <= Integer.parseInt(n2));
                }
            }
            desde += 10;
            hasta += 10;
        }
    }

    private String getNumEntre(int desde, int hasta) {
        Random rdn = new Random();
        return String.valueOf(rdn.nextInt(hasta - desde + 1) + desde);
    }

    public void imprimirCarton() {
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[0].length; j++) {
                System.out.print(i + "" + j + " " + carton[i][j] + "\t");
                if (j == 2) {
                    System.out.println("");
                }
            }

        }
    }

}
