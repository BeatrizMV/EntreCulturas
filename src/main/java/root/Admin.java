package root;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import daoroot.DAO;
import daoroot.DAOFactory;
import enums.LineaAccion;
import enums.Rol;
import enums.SublineaAccion;
import exceptions.DaoException;
import others.Helper;

import static daoroot.db.DbConstants.DIR_STR_SEPARATOR;
import static enums.Rol.ADMIN;

public class Admin {
    BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
    private Rol userType;

    DAO<Voluntario> voluntarioDAO;
    DAO<Sede> sedeDAO;
    DAO<Proyecto> proyectoDAO;

    public Admin(Rol userType, DAOFactory daoFactory) {
        setUserType(userType);
        voluntarioDAO = daoFactory.getVoluntarioDAO();
        sedeDAO = daoFactory.getSedeDAO();
        proyectoDAO = daoFactory.getProyectoDAO();
    }

    public void menu(Rol userType) throws IOException, ParseException, DaoException, NoSuchMethodException, NoSuchFieldException, InstantiationException, IllegalAccessException, InvocationTargetException {
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
        System.out.println("3 - Menu sedes. //No implementado");
        System.out.println("4 - Menu trabajadores. //No implementado");
        System.out.println("0 - Cerrar aplicación.");
    }

    private void enterMenuOption(int option) throws IOException, ParseException, DaoException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
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

    private void menuProyecto() throws IOException, DaoException, ParseException, NoSuchMethodException, NoSuchFieldException, InstantiationException, IllegalAccessException, InvocationTargetException {
        int option;
        Integer[] availableOptions = setMaxAvailableOptions(6);
        String entrada = "";
        String valor = "";

        Helper.clearScreen();

        System.out.println("Por favor, introduce el número de la acción que deseas realizar: ");
        System.out.println("1 - Ver proyecto por ID");
        System.out.println("2 - Ver todos los proyectos");
        if (userType == ADMIN) {
            System.out.println("3 - Crear proyecto");
            System.out.println("4 - Actualizar proyecto");
            System.out.println("5 - Eliminar proyecto proyecto");
        }
        System.out.println("0 - Volver a menu principal.");

        option = selectMenuOption(availableOptions);

        Helper.clearScreen();

        switch (option) {

            case 0:
                menu(userType);
                break;
            case 1:
            case 4:
                System.out.println("Cual es el id del proyecto?");
                String id = reader.readLine();
                Optional<Proyecto> optionalProyecto = proyectoDAO.findById(Integer.parseInt(id));
                if (optionalProyecto.isPresent()) {
                    Proyecto proyecto = optionalProyecto.get();

                    showProyectInfo(proyecto);
                } else {
                    System.out.println("El proyecto no existe.");
                    option = 1;
                }

                do {
                    System.out.println("Haz click en enter para continuar.");
                    entrada = reader.readLine();
                } while (!entrada.equals(""));

                if (option == 1) {
                    break;
                }

                if (userType == ADMIN) {

                    boolean seguirModificando = false;
                    do {
                        System.out.println("Que campo quieres modificar:");
                        System.out.println("1. Nombre proyecto");
                        System.out.println("2. Dirección");
                        System.out.println("3. Línea de acción");
                        System.out.println("4. Sublínea de acción");
                        System.out.println("5. Fecha de inicio");
                        System.out.println("6. Fecha de fin");
                        System.out.println("7. Socio local");
                        System.out.println("8. Acciones a realizar");
                        Integer seleccion = Integer.parseInt(reader.readLine());

                        switch (seleccion) {
                            case 2:
                                System.out.println("Tipo vía: ");
                                String via = reader.readLine();
                                System.out.println("Nombre de la vía: ");
                                String nombreVia = reader.readLine();
                                System.out.println("Número: ");
                                Integer numero = Integer.parseInt(reader.readLine());
                                System.out.println("Provincia: ");
                                String provincia = reader.readLine();
                                System.out.println("Código postal: ");
                                Integer codigoPostal = Integer.parseInt(reader.readLine());
                                System.out.println("País: ");
                                String pais = reader.readLine();
                                System.out.println("Observaciones: ");
                                String observaciones = reader.readLine();
                                proyectoDAO.updateFieldById(seleccion,
                                        "" + via +
                                                DIR_STR_SEPARATOR + nombreVia +
                                                DIR_STR_SEPARATOR + numero +
                                                DIR_STR_SEPARATOR + provincia +
                                                DIR_STR_SEPARATOR + codigoPostal +
                                                DIR_STR_SEPARATOR + pais +
                                                DIR_STR_SEPARATOR + observaciones,
                                        Integer.parseInt(id));
                                break;
                            case 3:
                                LineaAccion lineaAccion = selectLineaAccion();
                                valor = lineaAccion.name();
                                break;
                            case 5:
                            case 6:
                                System.out.println("Recuerda que las fechas tienen que estar en formato dd/MM/yyyy");
                            default:
                                System.out.println("¿Cuál es el nuevo valor que quieres introducir?");
                                valor = reader.readLine();
                                break;
                        }
                        proyectoDAO.updateFieldById(seleccion, valor, Integer.parseInt(id));
                        System.out.println("Se ha modificado el archivo.");
                        System.out.println("¿Quieres modificar algún dato más? (Y,N)");
                        String next = reader.readLine();
                        do {
                            if (next.equals("Y") || next.equals("y")) {
                                seguirModificando = true;
                            } else if (next.equals("N") || next.equals("n")) {
                                seguirModificando = false;
                            } else {
                                System.out.println("Tienes que poner Y o N");
                            }
                        } while (!next.equals("Y") && !next.equals("N") && !next.equals("y") && !next.equals("n"));
                    } while (seguirModificando);
                } else {
                    System.out.println("No tienes acceso a esta opción");
                }
                break;

            case 2:
                List<Proyecto> optionalProyectos = proyectoDAO.listAll();
                if (!optionalProyectos.isEmpty()) {
                    for (Proyecto proyecto : optionalProyectos) {
                        showProyectInfo(proyecto);
                        System.out.println();
                    }
                    System.out.println("Total: "+optionalProyectos.size()+" proyectos");
                } else {
                    System.out.println("No existe ningún proyecto");
                }

                break;
            case 3:
                if (userType == ADMIN) {
                    System.out.println("Por favor, indica los siguientes datos:");

                    int proyectId = 0;
                    boolean idExists;
                    if(DAOFactory.selectedDaoType == DAOFactory.XML){
                        do {
                            idExists = false;
                            System.out.println("Cual es el ID del proyecto:");
                            proyectId = Integer.parseInt(reader.readLine());

                            List<Proyecto> proyectos = proyectoDAO.listAll();
                            for (Proyecto proyecto : proyectos) {
                                if (proyecto.getCodigoProyecto() == proyectId) {
                                    idExists = true;
                                    System.out.println("Este ID de proyecto ya existe.");
                                    break;
                                }
                            }
                        } while (idExists);
                    }

                    System.out.println("¿Cuál es el nombre del proyecto?:");
                    String proyectName = reader.readLine();

                    LineaAccion lineaAccion = selectLineaAccion();
                    // OJO: FALTA PARA EN EL FUTURO PODER METERLO
                    SublineaAccion sublineaAccion = null;

                    System.out.println("¿Cuál es la fecha de inicio del proyecto? (Formato es dd/MM/yyyy)");
                    String fechaInicio = reader.readLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate dateInicio = LocalDate.parse(fechaInicio, formatter);

                    System.out.println("¿Cuál es la fecha de fin del proyecto? (Formato es dd/MM/yyyy)");
                    String fechaFin = reader.readLine();
                    LocalDate dateFin = LocalDate.parse(fechaFin, formatter);

                    System.out.println("¿Quién es el socio local del proyecto?:");
                    String socioLocal = reader.readLine();

                    System.out.println("¿Cuáles son las acciones a realizar?:");
                    String acciones = reader.readLine();

                    System.out.println("A continuación, vamos a rellenar la dirección:");
                    System.out.println("Tipo vía: ");
                    String via = reader.readLine();
                    System.out.println("Nombre vía: ");
                    String nombreVia = reader.readLine();
                    System.out.println("Número: ");
                    Integer numero = Integer.parseInt(reader.readLine());
                    System.out.println("Provincia: ");
                    String provincia = reader.readLine();
                    System.out.println("Código postal: ");
                    Integer codigoPostal = Integer.parseInt(reader.readLine());
                    System.out.println("País: ");
                    String pais = reader.readLine();
                    System.out.println("Observaciones: ");
                    String observaciones = reader.readLine();

                    Proyecto proyecto =
                            DAOFactory.selectedDaoType == DAOFactory.XML
                                    ? new Proyecto(proyectId, proyectName, lineaAccion, sublineaAccion, dateInicio, dateFin, socioLocal, acciones, via, nombreVia, numero, provincia, codigoPostal, pais, observaciones)
                                    : new Proyecto(proyectName, lineaAccion, sublineaAccion, dateInicio, dateFin, socioLocal, acciones, via, nombreVia, numero, provincia, codigoPostal, pais, observaciones);


                    proyectoDAO.create(proyecto);

                    System.out.println("Proyecto creado. Apreta enter para volver al menú.");
                } else {
                    System.out.println("No tienes acceso a esta opción");
                }
                do {
                    entrada = reader.readLine();
                } while (!entrada.equals(""));

                break;
            case 5:
                if (userType == ADMIN) {
                    System.out.println("¿Cuál es el id del proyecto que quieres eliminar?");
                    Integer deleteId = Integer.parseInt(reader.readLine());
                    if (proyectoDAO.findById(deleteId).isPresent()) {
                        proyectoDAO.deleteById(deleteId);
                        System.out.println("Proyecto borrado. Pulsa enter para volver al menú.");
                    } else {
                        System.out.println("El proyecto no existe");
                    }
                } else {
                    System.out.println("No tienes acceso a esta opción");
                }

                do {
                    entrada = reader.readLine();
                } while (!entrada.equals(""));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }

        menuProyecto();
    }

    private void showProyectInfo(Proyecto proyecto) {
        System.out.println("Id: " + proyecto.getCodigoProyecto());

        if (!proyecto.getNombreProyecto().equals("")) {
            System.out.println("Nombre: " + proyecto.getNombreProyecto());
        } else {
            System.out.println("Nombre: (no existe nombre para el proyecto)");
        }

        if (proyecto.getLineaAccion() == null) {
            System.out.println("Línea de acción: (No existe linea de acción para el proyecto)");
        } else {
            System.out.println("Línea de acción: " + proyecto.getLineaAccion().name());
        }

        if (proyecto.getSublineaAccion() == null) {
            System.out.println("Sublínea de acción: (No existe sublínea de acción para el proyecto)");
        } else {
            System.out.println("Sublínea de acción: " + proyecto.getSublineaAccion().name());
        }

        if (proyecto.getFechaInicio() == null) {
            System.out.println("Fecha de inicio: No existe fecha de inicio para el proyecto");
        } else {
            System.out.println("Fecha de inicio: " + proyecto.getFechaInicio().toString());
        }

        if (proyecto.getFechaFin() == null) {
            System.out.println("Fecha de fin: no existe fecha de fin para el proyecto");
        } else {
            System.out.println("Fecha de fin: " + proyecto.getFechaFin().toString());
        }

        if (!proyecto.getSocioLocal().equals("")) {
            System.out.println("Socio local: " + proyecto.getSocioLocal());
        } else {
            System.out.println("Socio local: (No existe socio local para el proyecto)");
        }

        if (!proyecto.getAccionesRealizar().equals("")) {
            System.out.println("Acciones a realizar: " + proyecto.getAccionesRealizar());
        } else {
            System.out.println("Acciones a realizar: No existen acciones a realizar para el proyecto");
        }
    }

    private LineaAccion selectLineaAccion() throws IOException {
        System.out.println("¿Cuál es la línea de acción del proyecto? \n0. COOPERACION_DESARROLLO\n1. ACCION_HUMANITARIA\n2. FORTALECIMIENTO_INSTITUCIONAL\n3. EDUCACION_DESARROLLO");
        Integer[] lineaAccionOptions = setMaxAvailableOptions(4);
        int optionSelected = selectMenuOption(lineaAccionOptions);
        LineaAccion lineaAccion = null;
        switch (optionSelected) {
            case 0:
                lineaAccion = LineaAccion.COOPERACION_DESARROLLO;
                break;
            case 1:
                lineaAccion = LineaAccion.ACCION_HUMANITARIA;
                break;
            case 2:
                lineaAccion = LineaAccion.FORTALECIMIENTO_INSTITUCIONAL;
                break;
            case 3:
                lineaAccion = LineaAccion.EDUCACION_DESARROLLO;
                break;
        }

        return lineaAccion;
    }

    private int selectMenuOption(Integer[] options) throws IOException {
        int optionSelected = 10000;
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
