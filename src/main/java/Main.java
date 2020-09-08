import DBConnector.DBConnector;
import daoroot.DAO;
import daoroot.DAOFactory;
import daoroot.db.DbProyectoDao;
import enums.Rol;
import exceptions.DaoException;
import others.Helper;
import root.Admin;
import root.Proyecto;
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

    private static DAOFactory menuDaoFactory(BufferedReader reader) throws IOException {
        System.out.println("Por favor, introduce la conexión:");
        System.out.println(DAOFactory.XML+") XML");
        System.out.println(DAOFactory.DB+") MySql");

        int daoType = Integer.parseInt(reader.readLine());
        DAOFactory.selectedDaoType = daoType;
        return DAOFactory.getDAOFactory(daoType);
    }
}