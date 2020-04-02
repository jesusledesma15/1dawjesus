/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

/**
 *
 * @author Jesus
 */
public class Prueba {
    
    public static void main(String[] args) {
        
        Bombo bombo = new Bombo();
        bombo.rellenarBombo();
        bombo.mostrarBombo();
        System.out.println(bombo.expulsarBola());
        bombo.mostrarBombo();
        
    }
}
