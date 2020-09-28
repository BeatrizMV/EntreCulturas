package model;

import enums.TipoCuota;

import java.util.Date;

public class CuotaSocio {
    //Atributos
    private Socio socio;
    private Ingreso importe;
    private Ingreso fechaIngreso;
    private TipoCuota tipoCuota;
    private Date fechaInicio;
    private Date fechaFin;

    /**
     * Método constructor
     *
     * @param socio        alberga el socio
     * @param importe      alberga el importe de la cuota
     * @param fechaIngreso alberga la fecha del ingreso
     * @param tipoCuota    alberga el tipo de cuota
     * @param fechaInicio  alberga la fecha de inicio
     * @param fechaFin     alberga la fecha de fin
     */
    public CuotaSocio(Socio socio, Ingreso importe,
                      Ingreso fechaIngreso, TipoCuota tipoCuota, Date fechaInicio,
                      Date fechaFin) {
        this.socio = socio;
        this.importe = importe;
        this.fechaIngreso = fechaIngreso;
        this.tipoCuota = tipoCuota;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    /**
     * Metodo destructor destruye cosas
     */
    public void finalize() {
        // hacer algo para borrar
    }

    /**
     * Metodos para consultar y modificar los atributos
     *
     * @return retorna socio
     */
    public Socio getSocio() {
        return socio;
    }

    /**
     * @return retorna importe
     */
    public Ingreso getImporte() {
        return importe;
    }

    /**
     * @return retorna fechaIngreso
     */
    public Ingreso getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @return retorna tipoCuota
     */
    public TipoCuota getTipoCuota() {
        return tipoCuota;
    }

    /**
     * @return retorna fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @return retorna fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * metodo para modificar los datos del socio
     *
     * @param socio modifica el socio
     */
    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    /**
     * metodo para modificar los datos del importe
     *
     * @param importe modifica el importe
     */
    public void setImporte(Ingreso importe) {
        this.importe = importe;
    }

    /**
     * metodo para modificar la fecha de ingreso
     *
     * @param fechaIngreso modifica la fecha de ingreso
     */
    public void setFechaIngreso(Ingreso fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * metodo para modificar el tipo de cuota
     *
     * @param tipoCuota modifica el tipo de cuota
     */
    public void setTipoCuota(TipoCuota tipoCuota) {
        this.tipoCuota = tipoCuota;
    }

    /**
     * método para modificar la fecha de inicio de cuota
     *
     * @param fechaInicio modifica la fecha de inicio de la cuota
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * método para modificar la fecha de fin de la cuota
     *
     * @param fechaFin modifica la fecha de fin de la cuota
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

}