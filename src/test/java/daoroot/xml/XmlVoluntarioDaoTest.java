package daoroot.xml;

import java.util.Optional;

import exceptions.DaoException;
import org.junit.jupiter.api.Test;

import enums.Rol;
import root.Direccion;
import root.Voluntario;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class XmlVoluntarioDaoTest {
    private final XMLVoluntarioDAO toTest = new XMLVoluntarioDAO();

    private Voluntario createVoluntario() {

        final Voluntario vol = new Voluntario(1, "44444444M", "Ana", "Vidal", "Fernandez", "calle", "Wallaby", 42,
                "Sidney", 28977, "Spain", "", 666223344, "avidalfern@uoc.edu", "avidalfern", "daotest", Rol.ADMIN);
        return vol;
    }

  
  @Test
	public void xmlGetsCreatedDoesNotRaiseExceptions() throws DaoException {
		Voluntario voluntario = createVoluntario();
		toTest.crearNuevo(voluntario);
	}

	@Test
	public void xmlGetsReadFromDoesNotRaiseExceptions() throws DaoException {
		Voluntario voluntario = createVoluntario();
		toTest.crearNuevo(voluntario);
		Optional<Voluntario> ret = toTest.obtener(String.valueOf(voluntario.getIdPersona()));
		assertTrue(ret.isPresent());
	}

	@Test
	public void xmlIsDeleted() throws DaoException {
		Voluntario voluntario = createVoluntario();
		toTest.crearNuevo(voluntario);

		toTest.borrar(voluntario);

		assertFalse(toTest.obtener(String.valueOf(voluntario.getIdPersona())).isPresent());
	}
}