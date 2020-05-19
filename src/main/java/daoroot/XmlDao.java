package daoroot;

import exceptions.DaoException;

import java.util.List;
import java.util.Optional;

public abstract class XmlDao<T> implements Dao<T> {

	public abstract void crearNuevo(T t) throws DaoException;

    public abstract Optional<T> obtener(String id) throws DaoException;

    public abstract void actualizar(T t) throws DaoException;

    public abstract void borrar(T t) throws DaoException;

    public abstract List<T> obtenerDatos() throws DaoException;
}
