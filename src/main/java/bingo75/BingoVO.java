/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo75;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jesus
 */
public class BingoVO {

    private String id;
    private LocalDate fecha;
    private String idjugador;
    private int tipo;
    private ArrayList<Integer> bombo;
    private int[][] carton;

    public BingoVO(String id, LocalDate fecha, String idjugador, int tipo, ArrayList<Integer> bombo, int[][] carton) {
        this.id = id;
        this.fecha = fecha;
        this.idjugador = idjugador;
        this.tipo = tipo;
        this.bombo = bombo;
        this.carton = carton;
    }

    public BingoVO() {
    }

    public String bomboToString() {
        String cadena = "";
        for (Integer num : this.bombo) {
            cadena += num + ",";
        }
        return cadena;
    }

    public String cartonToString() {
        String cadena = "";
        for (int j = carton[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < carton.length; i++) {
                cadena += carton[i][j] + ",";
            }
        }

        return cadena;

    }

    public static ArrayList<Integer> stringBomboToArrayList(String bombo) {
        List<String> bdList = new ArrayList<>(Arrays.asList(bombo.split(",")));
        List<Integer> bomboList = new ArrayList<>();
        bdList.forEach((fav) -> {
            bomboList.add(Integer.parseInt(fav.trim()));
        });
        return (ArrayList<Integer>) bomboList;
    }

    public static int[][] stringCartonToArrayInt(String carton, int tipo) {
        List<String> bdList = new ArrayList<>(Arrays.asList(carton.split(",")));
        int fila = tipo == 1 ? 5 : 3;
        int columna = tipo == 1 ? 5 : 9;
        int[][] cartonList = new int[columna][fila];
        for (int j = cartonList[0].length - 1; j >= 0; j--) {
            for (int[] cartonList1 : cartonList) {
                if (!bdList.isEmpty()) {
                    cartonList1[j] = Integer.valueOf(bdList.get(0));
                    bdList.remove(0);
                }
            }
        }
        return cartonList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(String idjugador) {
        this.idjugador = idjugador;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Integer> getBombo() {
        return bombo;
    }

    public void setBombo(ArrayList<Integer> bombo) {
        this.bombo = bombo;
    }

    public int[][] getCarton() {
        return carton;
    }

    public void setCarton(int[][] carton) {
        this.carton = carton;
    }

    @Override
    public String toString() {
        return "BingoVO{" + "id=" + id + ", fecha=" + fecha + ", idjugador=" + idjugador + ", tipo=" + tipo + ", bombo=" + bombo + ", carton=" + Arrays.deepToString(carton) + '}';
    }

//    public static void main(String[] args) {
//        ArrayList<Integer> bombo = BingoVO.stringBomboToArrayList("42,82,61,17,21,66,36,3,10,37,39,19,33,32,76,89,29,43,18,53,72,68,34,16,62,30,24,40,31,15,51,4,55,25,11,67,88,9,13,73,5,63,58,81,77,8,38,26,44,22,78,71,60,7,83,69,27,85,70,41,86,46,87,56,59,48,47,57,65,80,74,23,6,20,79,64,52,35,49,90,14,54,");
//        bombo.forEach(System.out::println);
//        int[][] prueba = BingoVO.stringCartonToArrayInt("5,14,21,0,41,0,62,0,0,0,15,22,35,0,55,64,0,0,0,0,0,36,48,56,0,78,-84", 2);
//        System.out.println(Arrays.deepToString(prueba));
//          
//    }
}
