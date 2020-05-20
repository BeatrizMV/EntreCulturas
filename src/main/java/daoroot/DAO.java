package daoroot;

import exceptions.DaoException;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    public void crearNuevo(T t) throws DaoException;

    public Optional<T> obtener(String id) throws DaoException;

    public void actualizar(T t) throws DaoException;

    public void borrar(T t) throws DaoException;

    public List<T> obtenerDatos() throws DaoException;
}
