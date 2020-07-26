package DBConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DBConnector implements DataBase {

    @Override
    public Connection connect() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(RUTA, "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se ha podido conectar a la base de datos");
        }
        return connection;
    }

    @Override
    public void disconnect(Connection connection) {
        try {
            System.out.println("Cerrado la conexion");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Obtener los datos de la base de datos
    @Override
    public List getData(Connection connection) {
        return null;
    }

    //Actualizar los datos de la base de datos
    @Override
    public void updateData(Connection connection) {

    }

    //Eliminar los datos de la base de datos
    @Override
    public void removeData(Connection connection) {
    }

    //Insertar los datos a la base de datos
    @Override
    public void insertData(Connection connection) {

    }
}
