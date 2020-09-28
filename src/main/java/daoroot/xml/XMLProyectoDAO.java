package daoroot.xml;

import enums.LineaAccion;
import enums.SublineaAccion;
import exceptions.DaoException;
import model.Proyecto;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class XMLProyectoDAO extends XMLDAO<Proyecto> {

    public XMLProyectoDAO() {
        this.subfolderPrefixFile = "proyecto/proyecto";
        this.prefixPath = "output/proyecto";
        this.clase = Proyecto.class;
    }

    @Override
    protected void updateFile(Object t, int field, String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, DaoException, NoSuchFieldException {
        String method = "";
        Class<?> type;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = null;

        switch (field) {
            case 0:
                throw new DaoException("El ID no se puede modificar");
            case 1:
                method = "setNombreProyecto";
                type = getFieldType((Proyecto) t, "nombreProyecto");
                t.getClass().getMethod(method, type).invoke(t, value);
                break;
            case 2:
                // no implementado
                method = "setLocalizacion";
                break;
            case 3:
                method = "setLineaAccion";
                type = getFieldType((Proyecto) t, "lineaAccion");
                LineaAccion lineaAccion = LineaAccion.valueOf(value);
                t.getClass().getMethod(method, type).invoke(t, lineaAccion);
                break;
            case 4:
                method = "setSublineaAccion";
                type = getFieldType((Proyecto) t, "sublineaAccion");
                SublineaAccion sublineaAccion = SublineaAccion.valueOf(value);
                t.getClass().getMethod(method, type).invoke(t, sublineaAccion);
                break;
            case 5:
                method = "setFechaInicio";
                type = getFieldType((Proyecto) t, "fechaInicio");
                date = LocalDate.parse(value, formatter);
                t.getClass().getMethod(method, type).invoke(t, date);
                break;
            case 6:
                method = "setFechaFin";
                type = getFieldType((Proyecto) t, "fechaFin");
                date = LocalDate.parse(value, formatter);
                t.getClass().getMethod(method, type).invoke(t, date);
                break;
            case 7:
                method = "setSocioLocal";
                type = getFieldType((Proyecto) t, "socioLocal");
                t.getClass().getMethod(method, type).invoke(t, value);
                break;
            case 8:
                method ="setAccionesRealizar";
                type = getFieldType((Proyecto) t, "accionesRealizar");
                t.getClass().getMethod(method, type).invoke(t, value);
                break;
        }

        create((Proyecto) t);
    }
}
