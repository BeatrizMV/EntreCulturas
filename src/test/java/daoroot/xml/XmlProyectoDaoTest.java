package daoroot.xml;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import enums.LineaAccion;
import enums.Rol;
import root.Direccion;
import root.MiembroEquipo;
import root.Proyecto;

public class XmlProyectoDaoTest {
	
	private XmlProyectoDao toTest = new XmlProyectoDao();

	private Proyecto createProyecto() {
		List<MiembroEquipo> miembrosEquipo = Arrays.asList(new MiembroEquipo(
				8, 
				"45324402D", 
				"Maria", 
			    "Benitez",
			    "Suarez", 
			    new Direccion(
			    		"calle",
			    		"los chopos",
			    		18,
			    		"Cantabria",
			    		47894,
			    		"Espa�a",
			    		"Muy lejos del centro"
				),
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
				"Espa�a",
				"Nada que comentar"
				);
		return pro;
	}
	
	@Test
	public void xmlGetsCreated() {
		System.out.println("Probando");
		Proyecto proyecto = createProyecto();
		toTest.crearNuevo(proyecto);
	}
}
