import java.time.LocalDate;

public class Ingreso {
	
	private int numIngreso;
	private String tipoIngreso;
	private LocalDate fecha;
	private float financiacionAportada;
	private String destinoPartida;
	
	public Ingreso(int numIngreso, String tipoIngreso, LocalDate fecha, float financiacionAportada,
			String destinoPartida) {
		this.numIngreso = numIngreso;
		this.tipoIngreso = tipoIngreso;
		this.fecha = fecha;
		this.financiacionAportada = financiacionAportada;
		this.destinoPartida = destinoPartida;
	}

	public int getNumIngreso() {
		return numIngreso;
	}

	public void setNumIngreso(int numIngreso) {
		this.numIngreso = numIngreso;
	}

	public String getTipoIngreso() {
		return tipoIngreso;
	}

	public void setTipoIngreso(String tipoIngreso) {
		this.tipoIngreso = tipoIngreso;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public float getFinanciacionAportada() {
		return financiacionAportada;
	}

	public void setFinanciacionAportada(float financiacionAportada) {
		this.financiacionAportada = financiacionAportada;
	}

	public String getDestinoPartida() {
		return destinoPartida;
	}

	public void setDestinoPartida(String destinoPartida) {
		this.destinoPartida = destinoPartida;
	}

	@Override
	public String toString() {
		return "Ingreso [numIngreso=" + numIngreso + ", tipoIngreso=" + tipoIngreso + ", fecha=" + fecha
				+ ", financiacionAportada=" + financiacionAportada + ", destinoPartida=" + destinoPartida + "]";
	}
	
	
	
	
	

}
