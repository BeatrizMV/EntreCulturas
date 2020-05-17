package root;
import java.time.LocalDate;

import enums.ProcedenciaPublico;

public class IngresoPublico extends Ingreso {

	private ProcedenciaPublico procedenciaPublico;
	
	public IngresoPublico(int numIngreso, String tipoIngreso, LocalDate fecha, float financiacionAportada,
			String destinoPartida, ProcedenciaPublico procedenciaPublico) {
		super(numIngreso, tipoIngreso, fecha, financiacionAportada, destinoPartida);
		
		this.procedenciaPublico= procedenciaPublico;
	
	}
	
	
}
