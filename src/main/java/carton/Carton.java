/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carton;

/**
 *
 * @author Jesus
 */
public class Carton {
    
    private String [][] carton;
    
    public Carton(){
        carton = new String [9][3];
    }

    public String[][] getCarton() {
        return carton;
    }

    public void setCarton(String[][] carton) {
        this.carton = carton;
    }   
    
    
}
