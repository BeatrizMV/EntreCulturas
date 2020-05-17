package root;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import others.Helper;

public class Admin {
    BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

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
        System.out.println("1 - Menu socios");
        if (getUserType() == 1) {
            System.out.println("9 - Crear trabajador");
        }
        System.out.println("0 - Cerrar aplicación.");
    }

    private int selectMenuOption() throws IOException {
        int optionSelected = 10000;
        Integer[] options = {0, 1};
        do {
            try {
                optionSelected = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException nfe) {
            }

            if (!Arrays.asList(options).contains(optionSelected)) {
                System.out.println("Por favor, introduce un número de la lista anterior.\n");
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
