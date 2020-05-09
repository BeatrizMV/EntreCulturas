import Others.Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Admin {
    private BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

    private int userType;

    public Admin(int userType) {
        setUserType(userType);
    }

    public void menu(int userType) throws IOException {
        int option;

        do {
            showMenu(userType);
            option = selectMenuOption();
            System.out.println(option);
            enterMenuOption(option);
        } while (option != 0);
    }

    private void showMenu(int userType) {
        //TODO: Mostrar opciones del menu según tipo de usuario
        System.out.println("Por favor, introduce el número de la acción que deseas realizar: ");
        if (getUserType() == 1) {
            System.out.println("Solo admins pueden ver esto");
        }
        System.out.println("0 - Cerrar aplicación.");
    }

    private int selectMenuOption() throws IOException {
        int optionSelected = 100000;
        Integer[] options = {0, 1};
        do {
            // TODO: Leer por pantalla la opción elegida
            try {
                optionSelected = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Introduce un número");
            }
        } while (!Arrays.asList(options).contains(optionSelected));
        return optionSelected;
    }

    private void enterMenuOption(int option) {
        switch (option) {
            case 0:
                Helper.clearScreen();
                System.exit(0);
                break;
            case 1:
                System.out.println("TEST");
                break;
        }
    }

    public int getUserType() {
        return userType;
    }

    public Admin setUserType(int userType) {
        this.userType = userType;
        return this;
    }
}
