/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import bingo75.Bingo;
import bingo75.BingoAmericano;
import bingo75.BingoDAO;
import bingo75.BingoEuropeo;
import bingo75.BingoVO;
import bingo75.BomboAmericano;
import bingo75.BomboEuropeo;
import bingo75.CartonAmericano;
import bingo75.CartonEuropeo;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class JuegoBingo {

    public static void main(String[] args) throws SQLException {
        BingoDAO dao = new BingoDAO();
        String idJugador;
        boolean salir = false;

        do {
            switch (menu()) {
                case "1":
                    idJugador = getNick();
                    CartonAmericano carton75 = new CartonAmericano();
                    BomboAmericano bombo75 = new BomboAmericano();
                    BingoAmericano bingo75 = new BingoAmericano(carton75, bombo75, LocalDate.now(), idJugador);
                    bingo75.getBomboAmericano().rellenarBombo();
                    bingo75.getCartonAmericano().generarCarton();
                    jugarBingo75(dao, bingo75);
                    break;
                case "2":
                    idJugador = getNick();
                    CartonEuropeo cartonEU = new CartonEuropeo();
                    BomboEuropeo bomboEU = new BomboEuropeo();
                    BingoEuropeo bingoEU = new BingoEuropeo(cartonEU, bomboEU, LocalDate.now(), idJugador);
                    bingoEU.getBomboEuropeo().rellenarBombo();
                    bingoEU.getCartonEuropeo().generarCarton();
                    jugarBingoEuropeo(dao, bingoEU);
                    break;
                case "3":
                    String id = getID();
                    Bingo bingo = dao.cargarPartida(id);
                    if (bingo instanceof BingoAmericano) {
                        bingo75 = (BingoAmericano) bingo;
                        jugarBingo75(dao, bingo75);
                    } else {
                        bingoEU = (BingoEuropeo) bingo;
                        jugarBingoEuropeo(dao, bingoEU);
                    }
                    break;
                default:
                    System.out.println("Saliendo de Bingomaniacos");
                    salir = true;
                    break;
            }

        } while (!salir);

    }

    private static String menu() {
        Scanner kyb = new Scanner(System.in);
        String tipoBingo;
        do {
            System.out.print("\n1.Jugar Bingo Americano\n"
                    + "2.Jugar Bingo Europeo\n"
                    + "3.Cargar partida\n"
                    + "4.Salir\n opción: ");
            tipoBingo = kyb.next();
        } while (!tipoBingo.equalsIgnoreCase("1") && !tipoBingo.equalsIgnoreCase("2") && !tipoBingo.equalsIgnoreCase("3") && !tipoBingo.equalsIgnoreCase("4"));

        return tipoBingo;
    }

    private static String getID() {
        Scanner kyb = new Scanner(System.in);
        System.out.print("Inserte ID de partida: ");
        return kyb.nextLine();
    }

    private static String getNick() {
        Scanner kyb = new Scanner(System.in);
        System.out.print("Bienvenido a Bingomaniacos escriba un nick de usuario: ");
        return kyb.nextLine();
    }

    private static String controlarTecla() {
        //Instanciamos un objeto de tipo Scanner para la entrada por teclado
        Scanner keyb = new Scanner(System.in);
        //Variable para controlar la tecla pulsada del usuario
        String tecla;
        //Bucle control de la tecla pulsada
        do {
            System.out.print("Pulse G para GUARDAR partida o E para EXPULSAR bola: ");
            tecla = keyb.nextLine();
        } while (!tecla.equalsIgnoreCase("e") && !tecla.equalsIgnoreCase("g"));
        return tecla;
    }

    public static void jugarBingo75(BingoDAO dao, BingoAmericano bingo75) throws SQLException {
        String tecla;

        System.out.println("Hola " + bingo75.getIdJugador() + ", Bienvenido al Bingo Americano");
        bingo75.getCartonAmericano().imprimirCarton();

        do {
            tecla = controlarTecla();
            switch (tecla) {
                case "e":
                    int num = bingo75.getBomboAmericano().sacarBola();
                    System.out.println("Sale el " + num);
                    System.out.println((bingo75.getCartonAmericano().tacharCasilla(num).getX() == -1 && bingo75.getCartonAmericano().tacharCasilla(num).getX() == -1) ? "No lo tienes" : "Se ha tachado el " + num);
                    bingo75.getCartonAmericano().imprimirCarton();
                    break;
                case "g":
                    BingoVO bdBingo = new BingoVO(bingo75.getId(), bingo75.getFecha(), bingo75.getIdJugador(), 1, bingo75.getBomboAmericano().getNumeros(), bingo75.getCartonAmericano().getCarton());
                    if (dao.comprobarId(bdBingo.getId())) {
                        dao.updatePartida(bdBingo.getId(), bdBingo);
                    } else {
                        dao.insertPartida(bdBingo);
                    }
                    System.out.println("Guardando partida");
                    break;
            }

        } while (!(bingo75.getCartonAmericano().isBingo() || tecla.equalsIgnoreCase("g")));
        System.out.println((bingo75.getCartonAmericano().isBingo() ? "BINGO!!" : "CARGUE SU PARTIDA CON ESTE CÓDIGO: " + bingo75.getId()));

    }

    public static void jugarBingoEuropeo(BingoDAO dao, BingoEuropeo bingo) throws SQLException {
        int contL1 = 0, contL2 = 0, contL3 = 0;
        String tecla;
        System.out.println("Hola " + bingo.getIdJugador() + ", Bienvenido al Bingo Euroepo");
        bingo.getCartonEuropeo().imprimirCarton();

        //Bucle del juego
        do {
            tecla = controlarTecla();
            switch (tecla) {
                case "e":
                    int num = bingo.getBomboEuropeo().sacarBola();
                    System.out.println("Sale el " + num);
                    System.out.println((bingo.getCartonEuropeo().tacharCasilla(num).getX() == -1 && bingo.getCartonEuropeo().tacharCasilla(num).getX() == -1) ? "No lo tienes" : "Se ha tachado el " + num);
                    bingo.getCartonEuropeo().imprimirCarton();
                    //Comprobamos si hace primera línea
                    if (bingo.getCartonEuropeo().isFirstLine() && contL1 < 1) {
                        System.out.println("Primera línea completada");
                        contL1++;
                    }
                    //Comprobamos si hace segunda línea
                    if (bingo.getCartonEuropeo().isSecondLine() && contL2 < 1) {
                        System.out.println("Segunda línea completada");
                        contL2++;
                    }
                    //Comprobamos si hace tercera línea
                    if (bingo.getCartonEuropeo().isThirdLine() && contL3 < 1) {
                        System.out.println("Tercera línea completada");
                        contL3++;
                    }
                    break;
                case "g":
                    BingoVO bdBingo = new BingoVO(bingo.getId(), bingo.getFecha(), bingo.getIdJugador(), 2, bingo.getBomboEuropeo().getNumeros(), bingo.getCartonEuropeo().getCarton());
                    if (dao.comprobarId(bdBingo.getId())) {
                        dao.updatePartida(bdBingo.getId(), bdBingo);
                    } else {
                        dao.insertPartida(bdBingo);
                    }
                    System.out.println("Guardando partida");
                    break;
            }

        } while (!(bingo.getCartonEuropeo().isBingo() || tecla.equalsIgnoreCase("g"))); //El juego termina el cartón canta bingo
        //Si sale del bucle es porque se ha hecho bingo y lo cantamos
        System.out.println((bingo.getCartonEuropeo().isBingo() ? "BINGO!!" : "CARGUE SU PARTIDA CON ESTE CÓDIGO: " + bingo.getId()));

    }
}
