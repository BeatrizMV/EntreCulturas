package daoroot.db;

import DBConnector.DBConnector;
import root.Proyecto;

import java.sql.Connection;
import java.util.List;

public class DbProyectoDao implements  DBDAO<Proyecto> {

    private DBConnector conexion = new DBConnector();

    @Override
    public List<Proyecto> getData(Connection connection) {
        return null;
    }

    @Override
    public void updateData(Connection connection, Proyecto data) {

    }

    @Override
    public void removeData(Connection connection, Proyecto data) {

    }

    @Override
    public void insertData(Connection connection, Proyecto data) {

    }
}
