package daoroot.db;

import DBConnector.DBConnector;
import daoroot.DAO;
import exceptions.DaoException;
import root.Voluntario;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

public class DbVoluntarioDao implements DAO<Voluntario>, DbConstants {

    private final DBConnector dbConnector;

    public DbVoluntarioDao(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public List<Voluntario> listAll() throws DaoException {
        return null;
    }

    @Override
    public Optional<Voluntario> findById(int id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public void updateFieldById(int field, String value, int idArchivo) throws DaoException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
    }

    @Override
    public void deleteById(int id) throws DaoException {
    }

    @Override
    public void create(Voluntario data) throws DaoException {
    }
}
