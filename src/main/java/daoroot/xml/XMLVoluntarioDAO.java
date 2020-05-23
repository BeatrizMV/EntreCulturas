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
                method = "setNombre";
                break;
            case 2:
                method = "setApellido1";
                break;
            case 3:
                method = "setApellido2";
                break;
            case 4:
                method = "setDireccion";
                break;
            case 5: 
                method = "setTelefono";
                break;
            case 6:
                method = "setEmail";
                break;
            case 7:
                method = "setUsuario";
            case 8:
                method = "setPassword";
                break;
        }

        t.getClass().getMethod(method, String.class).invoke(t, value);
        crearNuevoArchivo((Voluntario) t);
    }
}