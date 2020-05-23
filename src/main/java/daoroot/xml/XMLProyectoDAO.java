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
            case 2:
                method = "setLocalizacion";
                break;
            case 3:
                method = "setLineaAccion";
                break;
            case 4:
                method = "setSublineaAccion";
                break;
            case 5:
                method = "setFechaInicio";
                break;
            case 6:
                method = "setFechaFin";
                break;
            case 7:
                method = "setSocioLocal";
                break;
            case 8:
                method ="setAccionesRealizar";
                break;
        }

        t.getClass().getMethod(method, String.class).invoke(t, value);
        crearNuevoArchivo((Proyecto) t);
    }
}
