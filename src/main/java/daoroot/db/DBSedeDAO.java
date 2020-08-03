package daoroot.db;

import DBConnector.DBConnector;
import root.Sede;

import java.sql.Connection;
import java.util.List;

public class DBSedeDAO implements DBDAO<Sede> {

    private DBConnector conexion = new DBConnector();

    @Override
    public List getData(Connection connection) {
        return null;
    }

    @Override
    public void updateData(Connection connection, Sede data) {

    }

    @Override
    public void removeData(Connection connection, Sede data) {



    }

    @Override
    public void insertData(Connection connection, Sede data) {



    }
}
