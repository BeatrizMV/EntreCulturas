package DBConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static final String RUTA= "jdbc:mysql://localhost:3306/entreCulturas";
    private static final String USUARIO= "root";
    private static final String PASS= "root";

    /**
     * Se conecta a la base de datos
     * @return connection
     */
    public Connection connect() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(RUTA, USUARIO, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se ha podido conectar a la base de datos");
        }
        return connection;
    }

    /**
     * Se desconecta de la base de datos
     * @param connection
     */
    public void disconnect(Connection connection) {
        try {
            System.out.println("Cerrado la conexion");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
