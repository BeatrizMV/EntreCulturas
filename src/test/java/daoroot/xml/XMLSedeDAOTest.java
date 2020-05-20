package daoroot.xml;

import root.Sede;

import org.junit.jupiter.api.Test;

import java.io.File;

class XMLSedeDAOTest {

    private XMLSedeDAO xmlSedeDao = new XMLSedeDAO();

    private Sede createSede(){
        Sede sede = new Sede(1, "Barcelona", "Calle", "Pujades", 29, "Barcelona", 8905, "España", "", "+34666999888", "barcelona@entreculturas.org", true);
        return sede;
    }

    @Test
    public void XmlGetsCreated() {
        File file = new File("output/sede/sede_1.xml");
        Sede sede = createSede();
        xmlSedeDao.crearNuevaSede(sede);
        assert(file.exists());
    }
}