/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo75;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 *
 * @author Jesus
 */
public class PartidasDAO {

    private Connection con = null;

    public PartidasDAO() {
        con = Conexion.getInstance();
    }

    public boolean insertPartida(BingoVO partida) {
        boolean numFilas = false;
        String sql = "insert into partidas values (?,?,?,?,?,?)";

        // Instanciamos el objeto PreparedStatement para inserción
        // de datos. Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setString(1, partida.getId());
            prest.setString(2, partida.getIdjugador());
            prest.setDate(3, Date.valueOf(partida.getFecha()));
            prest.setInt(4, partida.getTipo());
            prest.setString(5, partida.getBombo().toString());
            prest.setString(6, Arrays.deepToString(partida.getCarton()));

            numFilas = prest.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Problemas durante la inserción de datos en la tabla partidas");
            System.out.println(e);
        }
        return numFilas;
    }

}
