package daoroot.xml;

/*
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
*/
public class XMLVoluntarioDAOTest {

/*
    private DAOFactory xmlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
    private DAO<Voluntario> voluntarioDAO = (XMLVoluntarioDAO) xmlDAOFactory.getVoluntarioDAO();

    private static Voluntario voluntario;

    @BeforeAll
    public static void nuevoVoluntario() {
        voluntario = new Voluntario(1, "00000000T", "Ana", "Vidal", "Fernandez", "Calle", "Wallaby", 42, "Sidney", 28977, "España", "", 606223344, "avidalfern@uoc.edu", "avidalfern", "uoc2020", Rol.ADMIN);
    }

    @BeforeEach
    public void crearArchivo() throws DaoException {
        voluntarioDAO.create(voluntario);
    }

    @AfterEach
    public void deleteXML() throws DaoException {
        voluntarioDAO.deleteById("1");
    }

    @Test
    public void XmlGetsCreated() throws DaoException {
        File file = new File("output/voluntario/voluntario_1.xml");
        assertTrue(file.exists());
    }

    @Test
    public void XmlObtainTest() throws DaoException {
        voluntarioDAO.create(voluntario);
        Optional<Voluntario> ret = voluntarioDAO.findById("1");
        assertTrue(ret.isPresent());
    }

    @Test
    public void XMLGetsDeleted() throws DaoException {
        voluntarioDAO.deleteById("1");
        assertFalse(voluntarioDAO.findById("1").isPresent());
    }

    @Test
    public void XMLGetsUpdated() throws DaoException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, InstantiationException {
        voluntarioDAO.create(voluntario);

        Object t = null;
        int field = 1;
        String value = "Juana";
        voluntarioDAO.updateFieldById(field, value, 1);

        Optional<Voluntario> dataOptional = voluntarioDAO.findById("1");
        t = dataOptional.get();

        Class cls = t.getClass();
        Field fieldToCheck = Helper.findFieldInTopParent(cls,"nombre");
        fieldToCheck.setAccessible(true);

        String testValue = (String) fieldToCheck.get(t);

        assertTrue(testValue.equals(value));
    }

 */
}