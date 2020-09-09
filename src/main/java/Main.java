import DBConnector.DBConnector;
import daoroot.DAO;
import daoroot.DAOFactory;
import daoroot.DbDAOFactory;
import daoroot.XMLDAOFactory;
import daoroot.db.DbProyectoDao;
import daoroot.db.DbSedeDao;
import daoroot.db.DbVoluntarioDao;
import daoroot.xml.XMLProyectoDAO;
import daoroot.xml.XMLSedeDAO;
import daoroot.xml.XMLVoluntarioDAO;
import enums.Rol;
import exceptions.DaoException;
import others.Helper;
import root.Admin;
import root.Proyecto;
import root.Sede;
import root.Voluntario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException, DaoException, ParseException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String user;
        String password;
        Rol userType = null;
        boolean isLogged = false;

        Helper.clearScreen();

        System.out.println("************");
        System.out.println("ONG MANAGER");
        System.out.println("************\n");

        menuVolcado(reader);

        DAOFactory daoFactory = menuDaoFactory(reader);

        DAO<Voluntario> voluntarioDAO = DAOFactory.getDAOFactory(DAOFactory.XML).getVoluntarioDAO();

        ArrayList<Voluntario> listaDeVoluntarios = (ArrayList<Voluntario>) voluntarioDAO.listAll();

        do {
            System.out.println("Por favor, introduce tu usuario: ");
            user = reader.readLine();
            System.out.println("Por favor, introduce tu contraseña: ");
            password = reader.readLine();


            for(Voluntario voluntario: listaDeVoluntarios){
                if(voluntario.getUsuario().equals(user) && voluntario.getPassword().equals(password)){
                    isLogged = true;
                    userType = voluntario.getRol();
                    break;
                }

            }
            Helper.clearScreen();
        } while (!isLogged);

        Admin admin = new Admin(userType, daoFactory);
        admin.menu(admin.getUserType());
    }

    private static void menuVolcado (BufferedReader reader) throws IOException {
        System.out.println ( "¿Quieres volcar los ficheros XML guardados en la BD? (s/n) ");
        String respuesta = reader.readLine();

        if (respuesta.equals("s")) {
            XMLDAOFactory xmlFactory = (XMLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.XML);
            XMLProyectoDAO pDao = xmlFactory.getProyectoDAO();
            XMLSedeDAO sDao = xmlFactory.getSedeDAO();
            XMLVoluntarioDAO vDao = xmlFactory.getVoluntarioDAO();

            DbDAOFactory dbFactory = (DbDAOFactory) DAOFactory.getDAOFactory(DAOFactory.DB);
            DbProyectoDao pbDao = dbFactory.getProyectoDAO();
            DbSedeDao sbDao = dbFactory.getSedeDAO();
            DbVoluntarioDao vbDao = dbFactory.getVoluntarioDAO();

            List<Proyecto> proyectos = null;
            List<Sede> sedes = null;
            List<Voluntario> voluntarios = null;

            //leemos todos los xml
            try {
                proyectos = pDao.listAll();
                sedes = sDao.listAll();
                voluntarios = vDao.listAll();
            } catch (DaoException e) {
                e.printStackTrace();
            }

            //escribimos en la bd la lectura recogida
            try {
                for (Proyecto p : proyectos) {
                    pbDao.create(p);
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }

            try {
                for (Sede s : sedes) {
                    sbDao.create(s);
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }

            try {
                for (Voluntario v : voluntarios) {
                    vbDao.create(v);
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }

            System.out.println("Archivos volcados");

        }else {
            System.out.println("No hemos volcado nada");
        }
    }

    private static DAOFactory menuDaoFactory(BufferedReader reader) throws IOException {
        System.out.println("Por favor, introduce la conexión:");
        System.out.println(DAOFactory.XML+") XML");
        System.out.println(DAOFactory.DB+") MySql");


        int daoType = Integer.parseInt(reader.readLine());
        DAOFactory.selectedDaoType = daoType;
        return DAOFactory.getDAOFactory(daoType);
    }
}