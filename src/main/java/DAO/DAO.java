package DAO;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    public void crearNuevo(T t) throws JAXBException;

    public Optional<T> obtener(String id);

    public void actualizar(T t, String[] params);

    public void borrar(T t);

    public List<T> obtenerDatos() throws JAXBException;
}
