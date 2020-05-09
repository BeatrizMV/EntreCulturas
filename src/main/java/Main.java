import Others.Helper;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException, JAXBException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String user;
        String password;
        int userType = 0;
        boolean isLogged = false;

        Helper.clearScreen();

        System.out.println("************");
        System.out.println("ONG MANAGER");
        System.out.println("************\n");

        do{
            System.out.println("Por favor, introduce tu usuario: ");
            user = reader.readLine();
            System.out.println("Por favor, introduce tu contraseña: ");
            password = reader.readLine();

            // TODO: Cambiar el if para que coja el usuario con el DAO. Seguramente habrá que hacer un método para que recorra el XML.
            if(user.equals("Erik") && password.equals("Erik")){
                isLogged = true;
                // TODO: Recibir el tipo de usuario que es
                // userType = ??
            }
            Helper.clearScreen();
        }while(!isLogged);

        Admin admin = new Admin(userType);
        admin.menu(admin.getUserType());
    }
}