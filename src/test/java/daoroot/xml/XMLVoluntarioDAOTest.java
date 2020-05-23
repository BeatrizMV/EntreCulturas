package daoroot.xml;

import daoroot.DAO;
import daoroot.DAOFactory;
import exceptions.DaoException;
import org.junit.jupiter.api.*;
import others.Helper;
import root.Voluntario;
import enums.Rol;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class XMLVoluntarioDAOTest {


    private DAOFactory xmlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
    private DAO<Voluntario> voluntarioDAO = (XMLVoluntarioDAO) xmlDAOFactory.getVoluntarioDAO();

    private static Voluntario voluntario;

    @BeforeAll
    public static void nuevoVoluntario() {
        voluntario = new Voluntario(1, "00000000T", "Ana", "Vidal", "Fernandez", "Calle", "Wallaby", 42, "Sidney", 28977, "España", "", 606223344, "avidalfern@uoc.edu", "avidalfern", "uoc2020", Rol.ADMIN);
    }

    @BeforeEach
    public void crearArchivo() throws DaoException {
        voluntarioDAO.crearNuevoArchivo(voluntario);
    }

    @AfterEach
    public void deleteXML() throws DaoException {
        voluntarioDAO.borrarArchivo("1");
    }

    @Test
    public void XmlGetsCreated() throws DaoException {
        File file = new File("output/voluntario/voluntario_1.xml");
        assertTrue(file.exists());
    }

    @Test
    public void XmlObtainTest() throws DaoException {
        voluntarioDAO.crearNuevoArchivo(voluntario);
        Optional<Voluntario> ret = voluntarioDAO.obtenerDatos("1");
        assertTrue(ret.isPresent());
    }

    @Test
    public void XMLGetsDeleted() throws DaoException {
        voluntarioDAO.borrarArchivo("1");
        assertFalse(voluntarioDAO.obtenerDatos("1").isPresent());
    }

    @Test
    public void XMLGetsUpdated() throws DaoException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, InstantiationException {
        voluntarioDAO.crearNuevoArchivo(voluntario);

        Object t = null;
        int field = 1;
        String value = "Juana";
        voluntarioDAO.actualizarArchivo(field, value, 1);

        Optional<Voluntario> dataOptional = voluntarioDAO.obtenerDatos("1");
        t = dataOptional.get();

        Class cls = t.getClass();
        Field fieldToCheck = Helper.findFieldInTopParent(cls,"nombre");
        fieldToCheck.setAccessible(true);

        String testValue = (String) fieldToCheck.get(t);

        assertTrue(testValue.equals(value));
    }    
}