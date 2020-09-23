package daoroot;

import model.Proyecto;
import model.Sede;
import model.Voluntario;

public abstract class DAOFactory {
    public static final int XML = 1;
    public static final int DB = 2;

    public abstract DAO<Sede> getSedeDAO();
    public abstract DAO<Proyecto> getProyectoDAO();
    public abstract DAO<Voluntario> getVoluntarioDAO();

    public static int selectedDaoType;

    public static DAOFactory getDAOFactory(int whichFactory) {

        switch (whichFactory) {
            case XML:
                return new XMLDAOFactory();
            case DB:
                return new DbDAOFactory();
            default:
                return null;
        }

    }
}
