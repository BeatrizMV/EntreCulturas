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
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void disconnect(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List getData(Connection connection) {
        return null;
    }

    @Override
    public void updateData(Connection connection) {

    }

    @Override
    public void removeData(Connection connection) {
    }
}
