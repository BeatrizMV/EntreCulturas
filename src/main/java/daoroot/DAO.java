package daoroot;

import exceptions.DaoException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    public void create(T t) throws DaoException;

    public Optional<T> findById(int id) throws DaoException;

    public void updateFieldById(int field, String value, int idArchivo) throws DaoException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException;

    public void deleteById(int id) throws DaoException;

    public List<T> listAll() throws DaoException;
}
