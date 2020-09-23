package daoroot.xml;

import exceptions.DaoException;
import model.Sede;

import java.lang.reflect.InvocationTargetException;

import static java.lang.Boolean.valueOf;

public class XMLSedeDAO extends XMLDAO<Sede> {

    public XMLSedeDAO() {
        this.subfolderPrefixFile = "sede/sede";
        this.prefixPath = "output/sede";
        this.clase = Sede.class;
    }

    @Override
    protected void updateFile(Object t, int field, String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, DaoException, NoSuchFieldException {
        String method = "";
        Class<?> type;

        switch (field) {
            case 0:
                throw new DaoException("El ID no se puede modificar");
            case 1:
                method = "setNombreSede";
                type = getFieldType((Sede) t, "nombreSede");
                t.getClass().getMethod(method, type).invoke(t, value);
                break;

            case 2:
                // No implementado
                method = "setDireccion";
                break;

            case 3:
                method = "setTelefono";
                type = getFieldType((Sede) t, "telefono");
                t.getClass().getMethod(method, type).invoke(t, value);
                break;

            case 4:
                method = "setEmail";
                type = getFieldType((Sede) t, "email");
                t.getClass().getMethod(method, type).invoke(t, value);
                break;

            case 5:
                method = "setCentral";
                type = getFieldType((Sede) t, "central");
                Boolean booleanValue = valueOf(value);
                t.getClass().getMethod(method, type).invoke(t, booleanValue);
                break;
        }

        create((Sede) t);
    }
}
