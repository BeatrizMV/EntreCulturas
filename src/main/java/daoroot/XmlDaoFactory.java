package daoroot;

import java.util.List;
import java.util.Optional;

public abstract class XmlDaoFactory<T> implements DaoFactory<T> {

	public abstract void crearNuevo(T t);

    public abstract Optional<T> obtener(String id);

    public abstract void actualizar(T t, String[] params);

    public abstract void borrar(T t);

    public abstract List<T> obtenerDatos();
}
