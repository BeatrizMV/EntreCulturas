package model;

import enums.LineaAccion;
import enums.SublineaAccion;
import others.LocalDateAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.List;

@XmlRootElement
public class Proyecto {
    private int id;
    private String nombreProyecto;
    private Direccion localizacion = new Direccion();
    private LineaAccion lineaAccion;
    private SublineaAccion sublineaAccion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String socioLocal;
    private String accionesRealizar;
    private List<MiembroEquipo> miembrosEquipo;

    public Proyecto(int id, String nombreProyecto, LineaAccion lineaAccion, SublineaAccion sublineaAccion, LocalDate fechaInicio, LocalDate fechaFin, String socioLocal, String accionesRealizar, String tipoVia, String via, int num, String provincia, int codigoPostal, String pais, String observaciones) {
        setCodigoProyecto(id);
        setNombreProyecto(nombreProyecto);
        setLineaAccion(lineaAccion);
        setSublineaAccion(sublineaAccion);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setSocioLocal(socioLocal);
        setAccionesRealizar(accionesRealizar);
        setLocalizacion(tipoVia, via, num, provincia, codigoPostal, pais, observaciones);
    }

    public Proyecto(String nombreProyecto, LineaAccion lineaAccion, SublineaAccion sublineaAccion, LocalDate fechaInicio, LocalDate fechaFin, String socioLocal, String accionesRealizar, String tipoVia, String via, int num, String provincia, int codigoPostal, String pais, String observaciones) {
        setNombreProyecto(nombreProyecto);
        setLineaAccion(lineaAccion);
        setSublineaAccion(sublineaAccion);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setSocioLocal(socioLocal);
        setAccionesRealizar(accionesRealizar);
        setLocalizacion(tipoVia, via, num, provincia, codigoPostal, pais, observaciones);
    }

    public Proyecto() {
    }

    @XmlElement
    public int getCodigoProyecto() {
        return id;
    }

    public Proyecto setCodigoProyecto(int id) {
        this.id = id;
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

    @XmlElement(name = "localizacion")
    public Direccion getLocalizacion() {
        return localizacion;
    }

    public Proyecto setLocalizacion(String tipoVia, String via, int num, String provincia, int codigoPostal, String pais, String observaciones) {
        localizacion = new Direccion(tipoVia, via, num, provincia, codigoPostal, pais, observaciones);
        return this;
    }

    public Proyecto setLocalizacion(Direccion direccion) {
        localizacion = direccion;
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
        if(sublineaAccion == null) {
            this.sublineaAccion = SublineaAccion.NINGUNA;
        } else {
            this.sublineaAccion = sublineaAccion;
        }
        return this;
    }

    @XmlElement
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public Proyecto setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }

    @XmlElement
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public Proyecto setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
        return this;
    }

    @XmlElement
    public String getSocioLocal() {
        return socioLocal;
    }

    public Proyecto setSocioLocal(String socioLocal) {
        this.socioLocal = socioLocal;
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

    @Override
    public String toString() {
        String bloqueId = this.id == 0 ? "" : "Id: " + this.id + "\n";
        return bloqueId +
                "Nombre proyecto: " +
                this.nombreProyecto +
                "\nLinea de accion: " +
                this.lineaAccion +
                "\nFecha de inicio: " +
                this.fechaInicio.toString() +
                "\nFecha fin: " +
                this.fechaFin.toString() +
                "\nSocio local: " +
                this.socioLocal +
                "\nAcciones a realizar: " +
                this.accionesRealizar +
                "\nDireccion: " +
                this.localizacion.toString();
    }
}
