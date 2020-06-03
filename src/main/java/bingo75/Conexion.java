package bingo75;

/**
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String SERVIDOR = "jdbc:mysql://localhost/";
    private static final String NOMBRE_BASE_DATOS = "bingo";
    private static final String USER = "jesus";
    private static final String PASS = "hispalis";
    public static final String DRIVER = "com.mysql.jdbc.Driver";

    private static Connection instancia = null;

    private Conexion() {

    }

    // Método de clase para acceder a la instancia del objeto Connection
    public static Connection getInstance() {
        // Si el objeto Connection no está creado, se crea
        if (instancia == null) {
            try {
                Class.forName(DRIVER);
                // Se crea el objeto Connection	
                instancia = DriverManager.getConnection(SERVIDOR + NOMBRE_BASE_DATOS, USER, PASS);

                System.out.println("Conexión realizada con éxito.");

            } catch (SQLException e) {
                // Error en la conexión
                System.out.println("Conexión fallida: " + e.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return instancia;
    }

    public static void main(String[] args) {
        Connection conexion = Conexion.getInstance();
    }
}
