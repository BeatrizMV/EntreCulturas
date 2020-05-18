package daoroot.xml;

import org.junit.jupiter.api.Test;

import enums.Rol;
import root.Direccion;
import root.Voluntario;


public class XmlVoluntarioDaoTest {
    private final XmlVoluntarioDao toTest = new XmlVoluntarioDao();

    private Voluntario createVoluntario() {

        final Voluntario vol = new Voluntario(1, "44444444M", "Ana", "Vidal", "Fernandez", "calle", "Wallaby", 42,
                "Sidney", 28977, "Spain", 666223344, "avidalfern@uoc.edu", "avidalfern", "daotest", Rol.ADMIN);
        return vol;
    }

    @Test
    public void xmlGetsCreated() {
        System.out.println("Probando");
        final Volntario voluntario = createVoluntario();
		toTest.crearNuevo(voluntario);
	}
}