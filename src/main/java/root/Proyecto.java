package root;

import java.util.Date;
import java.util.List;

import enums.LineaAccion;
import enums.SublineaAccion;

public class Proyecto {
    private int codigoProyecto;
    private String nombreProyecto;
    private Direccion localizacion;
    private LineaAccion lineaAccion;
    private SublineaAccion sublineaAccion;
    private Date fechaInicio;
    private Date FechaFin;
    private String SocioLocal;
    private String accionesRealizar;
    private List<MiembroEquipo> miembrosEquipo;

    public Proyecto(int codigoProyecto, String nombreProyecto, LineaAccion lineaAccion, Date fechaInicio, String socioLocal, String accionesRealizar, List<MiembroEquipo> miembrosEquipo, String tipoVia, String via, int num, String provincia, int codigoPostal, String pais, String observaciones) {
        setCodigoProyecto(codigoProyecto);
        setNombreProyecto(nombreProyecto);
        setLineaAccion(lineaAccion);
        setFechaInicio(fechaInicio);
        setSocioLocal(socioLocal);
        setAccionesRealizar(accionesRealizar);
        setLocalizacion(tipoVia, via, num, provincia, codigoPostal, pais, observaciones);
    }

    public int getCodigoProyecto() {
        return codigoProyecto;
    }

    public Proyecto setCodigoProyecto(int codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
        return this;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public Proyecto setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
        return this;
    }

    public Direccion getLocalizacion() {
        return localizacion;
    }

    public Proyecto setLocalizacion(String tipoVia, String via, int num, String provincia, int codigoPostal, String pais, String observaciones) {
        localizacion = new Direccion(tipoVia, via, num, provincia, codigoPostal, pais, observaciones);
        return this;
    }

    public LineaAccion getLineaAccion() {
        return lineaAccion;
    }

    public Proyecto setLineaAccion(LineaAccion lineaAccion) {
        this.lineaAccion = lineaAccion;
        return this;
    }

    public SublineaAccion getSublineaAccion() {
        return sublineaAccion;
    }

    public Proyecto setSublineaAccion(SublineaAccion sublineaAccion) {
        this.sublineaAccion = sublineaAccion;
        return this;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Proyecto setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }

    public Date getFechaFin() {
        return FechaFin;
    }

    public Proyecto setFechaFin(Date fechaFin) {
        FechaFin = fechaFin;
        return this;
    }

    public String getSocioLocal() {
        return SocioLocal;
    }

    public Proyecto setSocioLocal(String socioLocal) {
        SocioLocal = socioLocal;
        return this;
    }

    public String getAccionesRealizar() {
        return accionesRealizar;
    }

    public Proyecto setAccionesRealizar(String accionesRealizar) {
        this.accionesRealizar = accionesRealizar;
        return this;
    }

    public List<MiembroEquipo> getMiembrosEquipo() {
        return miembrosEquipo;
    }

    public Proyecto setMiembrosEquipo(List<MiembroEquipo> miembrosEquipo) {
        this.miembrosEquipo = miembrosEquipo;
        return this;
    }
}
