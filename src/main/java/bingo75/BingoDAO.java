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
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jesus
 */
public class BingoDAO {

    private Connection con = null;

    public BingoDAO() {
        con = Conexion.getInstance();
    }

    public boolean insertPartida(BingoVO partida) {
        boolean numFilas = false;
        String sql = "insert into partidas values (?,?,?,?,?,?)";

        // Instanciamos el objeto PreparedStatement para inserción
        // de datos. Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setString(1, getId());
            prest.setDate(2, Date.valueOf(partida.getFecha()));
            prest.setString(3, partida.getIdjugador());
            prest.setInt(4, partida.getTipo());
            prest.setString(5, partida.bomboToString());
            prest.setString(6, partida.cartonToString());

            numFilas = prest.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Problemas durante la inserción de datos en la tabla partidas");
            System.out.println(e);
        }
        return numFilas;
    }

    public List<BingoVO> getAll() throws SQLException {
        List<BingoVO> lista = new ArrayList<>();

        // Preparamos la consulta de datos mediante un objeto Statement
        // ya que no necesitamos parametrizar la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select * from partidas");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {
                BingoVO b = new BingoVO();
                // Recogemos los datos de la partida, guardamos en un objeto

                b.setId(res.getString("id"));
                b.setFecha(res.getDate("fecha").toLocalDate());
                b.setIdjugador(res.getString("idjugador"));
                b.setTipo(res.getInt("tipo"));
                b.setBombo(BingoVO.stringBomboToArrayList(res.getString("bombo")));
                b.setCarton(BingoVO.stringCartonToArrayInt(res.getString("carton"), b.getTipo()));

                //Añadimos el objeto a la lista
                lista.add(b);
            }
        }

        return lista;
    }

    public static String getId() throws SQLException {
        BingoDAO bdDao = new BingoDAO();
        String dia = String.valueOf(LocalDate.now().getDayOfYear());
        String mes = String.valueOf(LocalDate.now().getMonthValue());
        String anyo = String.valueOf(LocalDate.now().getYear());
        List<BingoVO> lista = bdDao.getAll();
        if (!lista.isEmpty()) {
            int idNew = Integer.parseInt(lista.get(lista.size()-1).getId())+1;
            return String.valueOf(idNew);
        }
        
        return "0";
    }

    public static void main(String[] args) throws SQLException {
        BingoDAO bdDao = new BingoDAO();
//        List<BingoVO> lista = bdDao.getAll();
//        lista.forEach(System.out::println);
        List<BingoVO> partidas = bdDao.getAll();
        partidas.forEach(System.out::println);
        System.out.println("---------------------------------------------");
        System.out.println("-"+getId()+"-");

    }
}
