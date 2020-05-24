package root;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import daoroot.DAO;
import daoroot.DAOFactory;
import enums.LineaAccion;
import enums.Rol;
import exceptions.DaoException;
import others.Helper;

import static enums.Rol.ADMIN;

public class Admin {
    BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
    private Rol userType;

    DAOFactory xmlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
    DAO<Voluntario> voluntarioDAO = xmlDAOFactory.getVoluntarioDAO();
    DAO<Sede> sedeDAO = xmlDAOFactory.getSedeDAO();
    DAO<Proyecto> proyectoDAO = xmlDAOFactory.getProyectoDAO();

    public Admin(Rol userType) {
        setUserType(userType);
    }

    public void menu(Rol userType) throws IOException, ParseException, DaoException {
        int option;
        Integer[] availableOptions = setMaxAvailableOptions(5);

        do {
            showMenu(userType);
            option = selectMenuOption(availableOptions);
            System.out.println(option);
            enterMenuOption(option);
        } while (option != 0);
    }

    private void showMenu(Rol userType) {
        Helper.clearScreen();
        System.out.println("Por favor, introduce el número de la acción que deseas realizar: ");
        System.out.println("1 - Menu socios //No implementado");
        System.out.println("2 - Menu proyectos.");
        System.out.println("3 - Menu sedes.");
        System.out.println("4 - Menu trabajadores.");
        System.out.println("0 - Cerrar aplicación.");
    }

    private void enterMenuOption(int option) throws IOException, ParseException, DaoException {
        Helper.clearScreen();
        switch (option) {
            case 0:
                System.exit(0);
                break;
            case 1:
                // no implementado
                break;
            case 2:
                menuProyecto();
                break;
            case 3:
                // menuSede();
                break;
            case 4:
                // menuTrabajadores();
                break;
        }
    }

    private void menuProyecto() throws IOException, DaoException, ParseException {
        int option;
        Integer[] availableOptions = setMaxAvailableOptions(6);
        int optionSelected = 0;

        System.out.println("Por favor, introduce el número de la acción que deseas realizar: ");
        System.out.println("1 - Ver proyecto por ID");
        System.out.println("2 - Ver todos los proyectos //No implementado");
        System.out.println("3 - Crear proyecto");
        System.out.println("4 - Actualizar proyecto");
        System.out.println("5 - Eliminar proyecto proyecto");
        System.out.println("0 - Volver a menu principal.");

        option = selectMenuOption(availableOptions);

        Helper.clearScreen();

        switch (option) {

            case 0:
                menu(userType);
                break;
            case 1:
                System.out.println("Cual es el id del proyecto?");
                String id = reader.readLine();
                Optional<Proyecto> optionalProyecto = proyectoDAO.obtenerDatos(id);
                if (optionalProyecto.isPresent()) {
                    Proyecto proyecto = optionalProyecto.get();
                    System.out.println("Nombre: " + proyecto.getNombreProyecto());

                }
                String entrada = "";

                do {
                    entrada = reader.readLine();
                } while (!entrada.equals(""));
                break;

            case 2:
                // No implementado
                break;
            case 3:
                System.out.println("Por favor, indica los siguientes datos: \n");

                System.out.println("Cual es el id del proyecto: \n");
                Integer proyectId = Integer.parseInt(reader.readLine());

                System.out.println("Cual es el nombre del proyecto: \n");
                String proyectName = reader.readLine();

                System.out.println("Cual es la linea de acción del proyecto: \n0. COOPERACION_DESARROLLO\n1. ACCION_HUMANITARIA\n2. FORTALECIMIENTO_INSTITUCIONAL\n3. EDUCACION_DESARROLLO \n");
                Integer[] lineaAccionOptions = setMaxAvailableOptions(4);
                optionSelected = selectMenuOption(lineaAccionOptions);
                LineaAccion lineaAccion = null;
                switch (optionSelected) {
                    case 1:
                        lineaAccion = LineaAccion.COOPERACION_DESARROLLO;
                        break;
                    case 2:
                        lineaAccion = LineaAccion.ACCION_HUMANITARIA;
                        break;
                    case 3:
                        lineaAccion = LineaAccion.FORTALECIMIENTO_INSTITUCIONAL;
                        break;
                    case 4:
                        lineaAccion = LineaAccion.EDUCACION_DESARROLLO;
                        break;
                }

                System.out.println("Cual es la fecha de inicio del proyecto (Formato es dd/MM/yyyy)");
                String fecha = reader.readLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                LocalDate date = LocalDate.parse(fecha, formatter);

                System.out.println("Quien es el socio local del proyecto:");
                String socioLocal = reader.readLine();

                System.out.println("Cuales son las acciones a realizar:");
                String acciones = reader.readLine();

                System.out.println("A continuación, vamos a rellenar la dirección:");
                System.out.println("Tipo via: ");
                String via = reader.readLine();
                System.out.println("Nombre via: ");
                String nombreVia = reader.readLine();
                System.out.println("Numero: ");
                Integer numero = Integer.parseInt(reader.readLine());
                System.out.println("Provincia: ");
                String provincia = reader.readLine();
                System.out.println("Codigo postal: ");
                Integer codigoPostal = Integer.parseInt(reader.readLine());
                System.out.println("Pais: ");
                String pais = reader.readLine();
                System.out.println("Observaciones: ");
                String observaciones = reader.readLine();

                Proyecto proyecto = new Proyecto(proyectId, proyectName, lineaAccion, date, socioLocal, acciones, via, nombreVia, numero, provincia, codigoPostal, pais, observaciones);
                proyectoDAO.crearNuevoArchivo(proyecto);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }

        menuProyecto();
    }

    private int selectMenuOption(Integer[] options) throws IOException {
        int optionSelected = 10000;
        do {
            try {
                optionSelected = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            if (!Arrays.asList(options).contains(optionSelected)) {
                System.out.println("Por favor, introduce un número de la lista anterior.\n");
            }

        } while (!Arrays.asList(options).contains(optionSelected));

        return optionSelected;
    }

    private Integer[] setMaxAvailableOptions(int availableOptions) {
        Integer[] options = new Integer[availableOptions];
        for (Integer i = 0; i < availableOptions; i++) {
            options[i] = i;
        }
        return options;
    }

    public Rol getUserType() {
        return userType;
    }

    public Admin setUserType(Rol userType) {
        this.userType = userType;
        return this;
    }
}
