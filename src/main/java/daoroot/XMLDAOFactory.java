package daoroot;

import daoroot.xml.XMLProyectoDAO;
import daoroot.xml.XMLSedeDAO;
import daoroot.xml.XMLVoluntarioDAO;

public class XMLDAOFactory extends DAOFactory {

    @Override
    public XMLProyectoDAO getProyectoDAO() {
        return new XMLProyectoDAO();
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
