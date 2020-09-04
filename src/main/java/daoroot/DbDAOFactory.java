package daoroot;

import DBConnector.DBConnector;
import daoroot.db.DbProyectoDao;
import daoroot.db.DbSedeDao;
import daoroot.db.DbVoluntarioDao;

public class DbDAOFactory extends DAOFactory {

    @Override
    public DbProyectoDao getProyectoDAO() {
        return new DbProyectoDao(new DBConnector());
    }

    @Override
    public DbSedeDao getSedeDAO() {
        return new DbSedeDao(new DBConnector());
    }

    @Override
    public DbVoluntarioDao getVoluntarioDAO() {
        return new DbVoluntarioDao(new DBConnector());
    }

}
