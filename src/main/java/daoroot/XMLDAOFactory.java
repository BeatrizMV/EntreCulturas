package daoroot;

import daoroot.xml.XMLSedeDAO;

public class XMLDAOFactory extends DAOFactory {
    /*
    @Override
    public XMLProyectosDAO getProyectoDAO() {
        return new XMLProyectosDAO();
    }
     */

    @Override
    public XMLSedeDAO getSedeDAO() {
        return new XMLSedeDAO();
    }

    
    @Override
     public XMLVoluntarioDAO getVoluntarioDAO() {
        return new XMLVoluntarioDAO();
    }
    
}
