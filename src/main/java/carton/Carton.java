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

    public boolean isFirstLine() {
        int cont = 0;
        for (String[] carton1 : carton) {
            if (carton1[2].contains("X")) {
                cont++;
            }
        }
        return cont == 5;
    }

    public boolean isSecondLine() {
        int cont = 0;
        for (String[] carton1 : carton) {
            if (carton1[1].contains("X")) {
                cont++;
            }
        }
        return cont == 5;
    }

    private boolean isThirdLine() {
        int cont = 0;
        for (String[] carton1 : carton) {
            if (carton1[0].contains("X")) {
                cont++;
            }
        }
        return cont == 5;
    }

    public boolean isBingo() {
        return isFirstLine() && isSecondLine() && isThirdLine();

    }

//    private void generarEspacios() {
//        Random rdn = new Random();
//        int espacio1, espacio2, espacio3, espacio4;
//        int cont = 0;
//        for (int j = carton[0].length - 1; j >= 0; j--) {
//            //Podemos tener por filas un máximo de cuatro espacios
//            do {
//                //Creamos 4 indices aleatorios donde poner los espacios
//                espacio1 = rdn.nextInt(9);
//                espacio2 = rdn.nextInt(9);
//                espacio3 = rdn.nextInt(9);
//                espacio4 = rdn.nextInt(9);
//            } while (!areNumDiferent(espacio1, espacio2, espacio3, espacio4)); //Utilizamos el metodo areNumDiferent para controlar que los cuatro indices sean diferentes
//            System.out.println("espacio1: " + espacio1);
//            System.out.println("espacio2: " + espacio2);
//            System.out.println("espacio3: " + espacio3);
//            System.out.println("espacio4: " + espacio4);
//            for (int i = 0; i < carton.length; i++) {
//                if (j == 2 || j == 1) { // Añadimos los espacios a la primera y segunda columna, no importa el indice en el que caigan los espacios
//                    carton[espacio1][j] = "";
//                    carton[espacio2][j] = "";
//                    carton[espacio3][j] = "";
//                    carton[espacio4][j] = "";
//                }
//                if (j == 0) {
//                    if (!(carton[i][1].equals("") || carton[i][2].equals(""))) {
//                        carton[i][j] = "";
//                        cont++;
//                    }
//                    if (cont < 4) {
//                        if ((!carton[i][1].equals("") || carton[i][2].equals("")) || (carton[i][1].equals("") || !carton[i][2].equals(""))) {
//
//                        }
//                        if (!carton[i][j].equals("") && j == 0) {
//                            carton[i][j] = "";
//                            cont++;
//
//                        }
//                    }
//
//                }
//                System.out.println("Cont: " + cont);
//            }
//
//        }
//    }
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
//        generarEspacios();
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
