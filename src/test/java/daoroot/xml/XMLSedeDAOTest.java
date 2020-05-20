package daoroot.xml;

import org.junit.jupiter.api.BeforeEach;
import root.Sede;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.File;
import java.util.Optional;

class XMLSedeDAOTest {

    private XMLSedeDAO xmlSedeDao = new XMLSedeDAO();

    private Sede createSede() {
        Sede sede = new Sede(1, "Barcelona", "Calle", "Pujades", 29, "Barcelona", 8905, "España", "", "+34666999888", "barcelona@entreculturas.org", true);
        return sede;
    }

    @Test
    public void XmlGetsCreated() {
        File file = new File("output/sede/sede_1.xml");
        Sede nuevaSede = createSede();
        xmlSedeDao.crearNuevoArchivo(nuevaSede, xmlSedeDao.buildFileName(nuevaSede.getIdSede(), "sede/sede"), Sede.class);
        assert (file.exists());
    }

    @Test
    public void XmlObtainTest() {
        Sede sede = createSede();
        Optional<Sede> ret = xmlSedeDao.obtener(String.valueOf(sede.getIdSede()));
        assertTrue(ret.isPresent());
    }
}