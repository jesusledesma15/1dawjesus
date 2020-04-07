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
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[0].length; j++) {
                carton[i][j] = getNumEntre(1, 90);
            }
        }
    }

    private String getNumEntre(int desde, int hasta) {
        Random rdn = new Random();
        return String.valueOf(rdn.nextInt(hasta - desde + 1) + desde);
    }

    public void imprimirCarton() {
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[0].length; j++) {
                System.out.print(carton[i][j] + "\t");
                if (j == 2 && (i == 2 || i == 5)) {
                    System.out.println("");
                }
            }

        }
    }

}
