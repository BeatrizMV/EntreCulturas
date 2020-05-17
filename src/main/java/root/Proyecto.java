package root;

import java.time.LocalDate;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import enums.LineaAccion;
import enums.SublineaAccion;

@XmlRootElement
public class Proyecto {
    private int codigoProyecto;
    private String nombreProyecto;
    private Direccion localizacion;
    private LineaAccion lineaAccion;
    private SublineaAccion sublineaAccion;
    private LocalDate fechaInicio;
    private LocalDate FechaFin;
    private String SocioLocal;
    private String accionesRealizar;
    private List<MiembroEquipo> miembrosEquipo;

    public Proyecto(int codigoProyecto, String nombreProyecto, LineaAccion lineaAccion, LocalDate fechaInicio, String socioLocal, String accionesRealizar, List<MiembroEquipo> miembrosEquipo, String tipoVia, String via, int num, String provincia, int codigoPostal, String pais, String observaciones) {
        setCodigoProyecto(codigoProyecto);
        setNombreProyecto(nombreProyecto);
        setLineaAccion(lineaAccion);
        setFechaInicio(fechaInicio);
        setSocioLocal(socioLocal);
        setAccionesRealizar(accionesRealizar);
        setLocalizacion(tipoVia, via, num, provincia, codigoPostal, pais, observaciones);
    }

    public Proyecto() {}

    @XmlElement
    public int getCodigoProyecto() {
        return codigoProyecto;
    }

    public Proyecto setCodigoProyecto(int codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
        return this;
    }

    @XmlElement
    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public Proyecto setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
        return this;
    }

    @XmlElement
    public Direccion getLocalizacion() {
        return localizacion;
    }

    public Proyecto setLocalizacion(String tipoVia, String via, int num, String provincia, int codigoPostal, String pais, String observaciones) {
        localizacion = new Direccion(tipoVia, via, num, provincia, codigoPostal, pais, observaciones);
        return this;
    }

    @XmlElement
    public LineaAccion getLineaAccion() {
        return lineaAccion;
    }

    public Proyecto setLineaAccion(LineaAccion lineaAccion) {
        this.lineaAccion = lineaAccion;
        return this;
    }

    @XmlElement
    public SublineaAccion getSublineaAccion() {
        return sublineaAccion;
    }

    public Proyecto setSublineaAccion(SublineaAccion sublineaAccion) {
        this.sublineaAccion = sublineaAccion;
        return this;
    }

    @XmlElement
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public Proyecto setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }

    @XmlElement
    public LocalDate getFechaFin() {
        return FechaFin;
    }

    public Proyecto setFechaFin(LocalDate fechaFin) {
        FechaFin = fechaFin;
        return this;
    }

    @XmlElement
    public String getSocioLocal() {
        return SocioLocal;
    }

    public Proyecto setSocioLocal(String socioLocal) {
        SocioLocal = socioLocal;
        return this;
    }

    @XmlElement
    public String getAccionesRealizar() {
        return accionesRealizar;
    }

    public Proyecto setAccionesRealizar(String accionesRealizar) {
        this.accionesRealizar = accionesRealizar;
        return this;
    }

    @XmlElement
    public List<MiembroEquipo> getMiembrosEquipo() {
        return miembrosEquipo;
    }

    public Proyecto setMiembrosEquipo(List<MiembroEquipo> miembrosEquipo) {
        this.miembrosEquipo = miembrosEquipo;
        return this;
    }
}
