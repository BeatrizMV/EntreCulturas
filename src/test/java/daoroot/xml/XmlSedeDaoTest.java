package daoroot.xml;

import root.Sede;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class XmlSedeDaoTest {

    private XmlSedeDao toTest = new XmlSedeDao();

    private Sede createSede(){
        Sede sede = new Sede(1, "Barcelona", "Calle", "Pujades", 29, "Barcelona", 8905, "España", "", "+34666999888", "barcelona@entreculturas.org", true);
        return sede;
    }

    @Test
    public void XmlGetsCreated(){
        Sede sede = createSede();
        toTest.crearNuevo(sede);
    }
}