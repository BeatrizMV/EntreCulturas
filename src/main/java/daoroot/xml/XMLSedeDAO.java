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
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

public class XMLSedeDAO extends XMLDAO<Sede> implements DAO<Sede> {

    public XMLSedeDAO(){
        this.subfolderPrefixFile = "sede/sede";
        this.prefixPath = "output/sede";
        this.clase = Sede.class;
    }

    @Override
    protected void updateFile(Object t, int field, String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, DaoException {
        String method = "";
        switch (field) {
            case 0:
                throw new DaoException("El ID no se puede modificar");
            case 1:
                method = "setNombreSede";
                break;
        }

        t.getClass().getMethod(method, String.class).invoke(t,value);
        crearNuevoArchivo((Sede) t);
    }
}
