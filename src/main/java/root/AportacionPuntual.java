package root;

import java.time.LocalDate;

import enums.TipoPuntual;

public class AportacionPuntual extends IngresoPrivado {

    private TipoPuntual tipoPuntual;
    private double importe;
    private String donante;
    private LocalDate fecha;
    private String destinoPartida;

    public AportacionPuntual(int numIngreso, String tipoIngreso, LocalDate fecha, float financiacionAportada,
                             String destinoPartida, TipoPuntual tipoPuntual, double importe, String donante, LocalDate fecha2,
                             String destinoPartida2) {
        super(numIngreso, tipoIngreso, fecha, financiacionAportada, destinoPartida);
        this.tipoPuntual = tipoPuntual;
        this.importe = importe;
        this.donante = donante;
        fecha = fecha2;
        destinoPartida = destinoPartida2;
    }

    public TipoPuntual getTipoPuntual() {
        return tipoPuntual;
    }

    public void setTipoPuntual(TipoPuntual tipoPuntual) {
        this.tipoPuntual = tipoPuntual;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getDonante() {
        return donante;
    }

    public void setDonante(String donante) {
        this.donante = donante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDestinoPartida() {
        return destinoPartida;
    }

    public void setDestinoPartida(String destinoPartida) {
        this.destinoPartida = destinoPartida;
    }

    @Override
    public String toString() {
        return "AportacionPuntual [tipoPuntual=" + tipoPuntual + ", importe=" + importe + ", donante=" + donante
                + ", fecha=" + fecha + ", destinoPartida=" + destinoPartida + "]";
    }


}
