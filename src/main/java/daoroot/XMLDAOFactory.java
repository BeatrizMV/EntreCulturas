package daoroot;

import daoroot.xml.XMLProyectosDAO;
import daoroot.xml.XMLSedeDAO;
import daoroot.xml.XMLVoluntarioDAO;
import exceptions.DaoException;
import root.Sede;
import root.Voluntario;

import java.util.List;
import java.util.Optional;

public class XMLDAOFactory extends DAOFactory {
    @Override
    public XMLProyectosDAO getProyectoDAO() {
        return new XMLProyectosDAO();
    }

    @Override
    public XMLSedeDAO getSedeDAO() {
        return new XMLSedeDAO();
    }

    @Override
    public XMLVoluntarioDAO getVoluntarioDAO() {
        return new XMLVoluntarioDAO();
    }
}
