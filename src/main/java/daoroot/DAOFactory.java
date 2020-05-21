package daoroot;

import root.Proyecto;
import root.Sede;
import root.Voluntario;

public abstract class DAOFactory {
    public static final int XML = 1;

    public abstract DAO<Sede> getSedeDAO();
    /*
    public abstract DAO<Proyecto> getProyectoDAO();
    public abstract DAO<Voluntario> getVoluntarioDAO();
    */

    public static DAOFactory getDAOFactory(int whichFactory) {

        switch (whichFactory) {
            case 1:
                return new XMLDAOFactory();
            /* case 2:
                return new SQLDAOFactory();
             */
            default:
                return null;
        }

    }
}
