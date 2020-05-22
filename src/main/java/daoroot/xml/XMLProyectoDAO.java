package daoroot.xml;

import daoroot.DAO;
import exceptions.DaoException;
import root.Proyecto;

import java.lang.reflect.InvocationTargetException;

public class XMLProyectoDAO extends XMLDAO<Proyecto> implements DAO<Proyecto> {

    public XMLProyectoDAO() {
        this.subfolderPrefixFile = "proyecto/proyecto";
        this.prefixPath = "output/proyecto";
        this.clase = Proyecto.class;
    }

    @Override
    protected void updateFile(Object t, int field, String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, DaoException {
        String method = "";
        switch (field) {
            case 0:
                throw new DaoException("El ID no se puede modificar");
            case 1:
                method = "setNombreProyecto";
                break;
        }

        t.getClass().getMethod(method, String.class).invoke(t, value);
        crearNuevoArchivo((Proyecto) t);
    }
}
