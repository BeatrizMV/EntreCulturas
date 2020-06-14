package DBConnector;

import java.sql.Connection;
import java.util.List;

public interface DataBase<T> {
    // Aquí van las constantes

    public Connection connect();

    public void disconnect(Connection connection);

    public List<T> getData(Connection connection);

    public void updateData(Connection connection);

    public void removeData(Connection connection);
}