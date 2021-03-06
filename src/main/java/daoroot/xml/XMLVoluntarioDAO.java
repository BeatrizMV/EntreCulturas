package daoroot.xml;

import exceptions.DaoException;
import others.Helper;
import model.Voluntario;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class XMLVoluntarioDAO extends XMLDAO<Voluntario> {

    public XMLVoluntarioDAO() {
        this.subfolderPrefixFile = "voluntario/voluntario";
        this.prefixPath = "output/voluntario";
        this.clase = Voluntario.class;
    }

    @Override
    protected void updateFile(Object t, int field, String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, DaoException {
        String methodName = "";
        switch (field) {
            case 0:
                throw new DaoException("El ID no se puede modificar");
            case 1:
                methodName = "setNombre";
                break;
            case 2:
                methodName = "setApellido1";
                break;
            case 3:
                methodName = "setApellido2";
                break;
            case 4:
                methodName = "setDireccion";
                break;
            case 5:
                methodName = "setTelefono";
                break;
            case 6:
                methodName = "setEmail";
                break;
            case 7:
                methodName = "setUsuario";
            case 8:
                methodName = "setPassword";
                break;
        }

        Method method = Helper.findMethodInTopParent(clase, methodName, String.class);
        method.invoke(t, value);
        create((Voluntario) t);
    }
}