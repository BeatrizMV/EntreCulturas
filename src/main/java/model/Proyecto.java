package model;

import enums.LineaAccion;
import enums.SublineaAccion;
import others.LocalDateAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@XmlRootElement
@Entity
@Table(name = "proyectos")
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column (name = "idCodigoProyecto")
    private int id;
    @Column(name = "nombreProyecto")
    private String nombreProyecto;
    @Column (name = "localizacion")
    private Direccion localizacion = new Direccion();
    @OneToMany
    @Column (name = "lineaAccion")
    private LineaAccion lineaAccion;
    @Column (name = "fk_subLineaAccion")
    private SublineaAccion sublineaAccion;
    @Column (name = "fechaInicio")
    private LocalDate fechaInicio;
    @Column (name = "fechaFinal")
    private LocalDate fechaFin;
    @Column (name = "socioLocal")
    private String SocioLocal;
    @Column (name = "accionesRealizar")
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
