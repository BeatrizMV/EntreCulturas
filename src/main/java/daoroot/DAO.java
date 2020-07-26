package daoroot;

        import exceptions.DaoException;
        import java.lang.reflect.InvocationTargetException;
        import java.util.List;
        import java.util.Optional;

public interface DAO<T> {
    public void crearNuevoArchivo(T t) throws DaoException;

    public Optional<T> obtenerDatos(String id) throws DaoException;

    public void actualizarArchivo(int field, String value, int idArchivo) throws DaoException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException;

    public void borrarArchivo(String id) throws DaoException;

    public List<T> obtenerDatos() throws DaoException;
}
