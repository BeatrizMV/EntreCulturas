package daoroot;

        import exceptions.DaoException;

        import javax.xml.bind.JAXBException;
        import java.util.List;
        import java.util.Optional;

public interface DAO<T> {
    public void crearNuevoArchivo(T t) throws DaoException;

    public Optional<T> obtenerDatos(String id, Class c) throws DaoException;

    public void actualizar(T t) throws DaoException;

    public void borrar(T t) throws DaoException;

    public List<T> obtenerDatos() throws DaoException;
}
