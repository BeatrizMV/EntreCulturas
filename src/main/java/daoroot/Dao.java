package daoroot;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    public void crearNuevo(T t);

    public Optional<T> obtener(String id);

    public void actualizar(T t, String[] params);

    public void borrar(T t);

    public List<T> obtenerDatos();
}
