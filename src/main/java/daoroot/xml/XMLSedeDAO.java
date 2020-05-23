package daoroot.xml;

import daoroot.DAO;
import exceptions.DaoException;
import root.Proyecto;
import root.Sede;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.valueOf;

public class XMLSedeDAO extends XMLDAO<Sede> implements DAO<Sede> {

    public XMLSedeDAO() {
        this.subfolderPrefixFile = "sede/sede";
        this.prefixPath = "output/sede";
        this.clase = Sede.class;
    }

    @Override
    protected void updateFile(Object t, int field, String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, DaoException, NoSuchFieldException {
        String method = "";
        Class typeClass = null;
        Field fieldType;
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

        crearNuevoArchivo((Sede) t);
    }
}
