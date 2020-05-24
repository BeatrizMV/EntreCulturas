import javax.xml.bind.JAXBException;

import daoroot.DAO;
import daoroot.DAOFactory;
import daoroot.xml.XMLVoluntarioDAO;
import enums.Rol;
import exceptions.DaoException;
import others.Helper;
import root.Admin;
import root.Voluntario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException, DaoException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String user;
        String password;
        Rol userType = null;
        boolean isLogged = false;

        DAOFactory xmlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
        DAO<Voluntario> voluntarioDAO = xmlDAOFactory.getVoluntarioDAO();

        Helper.clearScreen();

        System.out.println("************");
        System.out.println("ONG MANAGER");
        System.out.println("************\n");

        ArrayList<Voluntario> listaDeVoluntarios = (ArrayList<Voluntario>) voluntarioDAO.obtenerDatos();

        do {
            System.out.println("Por favor, introduce tu usuario: ");
            user = reader.readLine();
            System.out.println("Por favor, introduce tu contraseña: ");
            password = reader.readLine();

            // TODO: Cambiar el if para que coja el usuario con el DAO. Seguramente habrá que hacer un método para que recorra el XML.
            for(Voluntario voluntario: listaDeVoluntarios){
                String loggedUser = voluntario.getUsuario();
                String loggedPassword = voluntario.getPassword();

                if(voluntario.getUsuario().equals(user) && voluntario.getPassword().equals(password)){
                    isLogged = true;
                    userType = voluntario.getRol();
                    break;
                }

            }
            Helper.clearScreen();
        } while (!isLogged);

        Admin admin = new Admin(userType);
        admin.menu(admin.getUserType());
    }
}