package daoroot.xml;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import exceptions.DaoException;
import org.junit.jupiter.api.Test;

import enums.LineaAccion;
import enums.Rol;
import root.Direccion;
import root.MiembroEquipo;
import root.Proyecto;

import javax.xml.bind.JAXBException;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class XMLProyectoDAOTest {

    private XMLProyectosDAO toTest = new XMLProyectosDAO();

    private Proyecto createProyecto() {
        List<MiembroEquipo> miembrosEquipo = Arrays.asList(new MiembroEquipo(
                8,
                "45324402D",
                "Maria",
                "Benitez",
                "Suarez",
                //new Direccion(
                "calle",
                "los chopos",
                18,
                "Cantabria",
                47894,
                "Espa�a",
                "Muy lejos del centro",
                //),
                946881122,
                "mbenitez@gmail.com",
                "mbenitezlokita",
                "1234",
                Rol.USER)
        );
        Proyecto pro = new Proyecto(1,
                "mi proyecto",
                LineaAccion.ACCION_HUMANITARIA,
                LocalDate.now(),
                "socio local",
                "accion a realizar",
                miembrosEquipo,
                "calle",
                "gran via",
                18,
                "Cantabria",
                47890,
                "España",
                "Nada que comentar"
        );
        return pro;
    }

    @Test
    public void xmlGetsCreatedDoesNotRaiseExceptions() throws DaoException{
        Proyecto proyecto = createProyecto();
        toTest.crearNuevoArchivo(proyecto);
    }

    @Test
    public void xmlGetsReadFromDoesNotRaiseExceptions() throws DaoException {
        Proyecto proyecto = createProyecto();
        toTest.crearNuevoArchivo(proyecto);
        Optional<Proyecto> ret = toTest.obtener(String.valueOf(proyecto.getCodigoProyecto()));
        assertTrue(ret.isPresent());
    }

    @Test
    public void xmlIsDeleted() throws DaoException {
        Proyecto proyecto = createProyecto();
        toTest.crearNuevoArchivo(proyecto);

        toTest.borrar(proyecto);

        assertFalse(toTest.obtener(String.valueOf(proyecto.getCodigoProyecto())).isPresent());
    }
}