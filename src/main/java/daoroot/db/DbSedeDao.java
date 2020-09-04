package daoroot.db;

import DBConnector.DBConnector;
import daoroot.DAO;
import exceptions.DaoException;
import root.Sede;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

public class DbSedeDao implements DAO<Sede>, DbConstants {

    private final DBConnector dbConnector;

    public DbSedeDao(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public List<Sede> listAll() throws DaoException {
        return null;
    }

    @Override
    public Optional<Sede> findById(int id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public void updateFieldById(int field, String value, int idArchivo) throws DaoException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
    }

    @Override
    public void deleteById(int id) throws DaoException {
    }

    @Override
    public void create(Sede data) throws DaoException {
    }
}
