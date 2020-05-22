package daoroot.xml;

import daoroot.DAO;
import exceptions.DaoException;
import root.Voluntario;

import java.lang.reflect.InvocationTargetException;

public class XMLVoluntarioDAO extends XMLDAO<Voluntario> implements DAO<Voluntario> {

    public XMLVoluntarioDAO() {
        this.subfolderPrefixFile = "voluntario/voluntario";
        this.prefixPath = "output/voluntario";
        this.clase = Voluntario.class;
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

        t.getClass().getMethod(method, String.class).invoke(t, value);
        crearNuevoArchivo((Voluntario) t);
    }
}